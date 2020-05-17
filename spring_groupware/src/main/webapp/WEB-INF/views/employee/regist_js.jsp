<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>

//***** 이미지 미리보기
$('input#picture').on('change',function(event){
	
	var fileFormat=
		this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	//이미지 확장자 jpg 확인
	if(fileFormat!="JPG"){
		alert("이미지는 jpg 형식만 가능합니다.");
		return;
	} 
	//이미지 파일 용량 체크
	if(this.files[0].size>1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return;
	};
	
	var imgName = this.files[0].name;	//파일 이름
	var file = this.files[0];
	console.log(file);
	upload_go(file);
	
	$('input#picture').value=imgName
	
	if (this.files && this.files[0]) {
		
        var reader = new FileReader();
        
        reader.onload = function (e) {
        	//이미지 미리보기	        	
        	$('div#picturePreView')
        	.css({'background-image':'url('+e.target.result+')',
				  'background-position':'center',
				  'background-size':'cover',
				  'background-repeat':'no-repeat'
        		});
        }
        
        reader.readAsDataURL(this.files[0]);
	}
// 	alert(imgName);
	document.getElementById('picturePreView').setAttribute('value',imgName);
	console.log(imgName);
// 	upload_go(file);
});


//***** 이미지 ajax 처리 업로드
function upload_go(file){
	
	//form 태그 양식을 객체화	
	var form = new FormData($('form[name="image"]')[0]);
	form.append('file', file);
	
	if($('input[name="picture"]').val()==""){
		alert("사진을 선택하세요.");
		$('input[name="picture"]').click();
		return;
	};	
	
	$.ajax({
		url:"<%=request.getContextPath()%>/employee/picture/upload",
		data:form,
		type:'post',
// 		dataType:'text',
		processData:false,
		contentType:false,
		success:function(data){
// 			var obj = JSON.parse(json);
// 			$('input#oldFile').val(data);
// 			$('form[role="form"] > input[name="picture"]').val(data);
// 			$('input[name="checkUpload"]').val(1);
			alert("사진을 업로드 했습니다.");
		},
		error:function(xhr,exception){
			alert("파일 업로드를 실패했습니다.");
		}
	});
	
}

//*****  ID 중복 체크
function CheckID() {
	var id = document.getElementById('id').value;
	
	if(id=="") {
		alert('ID를 입력해주세요');
		return;
	}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/employee/idCheck",
		data:{
		'id':id			
		},
		type:'post',
		success:function(data){
			alert("입력한 " + id + "는 사용 가능한 ID입니다.");
		},
		error:function(xhr,exception){
			alert("이미 존재하는 ID입니다.");
		}
	})

}

//***** 날짜 입력
document.getElementById('regDate').addEventListener('click', dateSelect);
function dateSelect() {
	alert('날짜')
}




//***** 경력사항 추가
function RegistCareer() {
	alert("RegistCarrer");
	var input=$('<input>').attr({"type":"text","name":"career"})
	  .css("display","inline"); 
	var div=$('<div>').addClass("career");
	div.append(input).append("<button style='border:0;outline:0;' class='badge bg-red' type='button'>X</button");
	div.appendTo('.fileInput');
}



//***** 회원가입
function goSubmit(str){
	if(str == 'post'){
		var input = confirm('임직원 등록하시겠습니까?');
		if(input == true) {
			var registForm = document.getElementById('registForm');
			registForm.submit();
		}
	}
	
	if(str == 'close'){
// 		alert('닫기');
		var input = confirm('임직원 등록을 취소하시겠습니까?');
		if(input == true) {
			window.close();
		}
	}
}




//***** 주소 검색
function SearchAddress(){
	searchPostCode();
}

//***** 이메일 주소 입력시 checkbox 이벤트 처리
document.getElementById('directInput').addEventListener('click', checkboxClick);
function checkboxClick() {

	var checkbox = document.getElementById('directInput');
	var selectEmail = $('select[name=email]');

	if(checkbox.checked == true){
		selectEmail.hide();
		$('input[role=domain]').show().css("display", "inline");
		
	} else {
		$('input[role=domain]').hide();
		selectEmail.show();
	}
}

</script>




<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//***** 다음 지도 api 주소 검색
function searchPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postCode').value = data.zonecode;
            document.getElementById("address[0]").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("address[1]").focus();
        }
    }).open();	
}
</script>

