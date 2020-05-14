<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>

$('input#picture').on('change',function(event){
	$('input[name="checkUpload"]').val(0);
	
	var fileFormat=
		this.value.substr(this .value.lastIndexOf(".")+1).toUpperCase();
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
	

	$('input#picture').value=this.files[0].name;
	
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
});

function upload_go(){
	
	//form 태그 양식을 객체화	
	var form = new FormData($('form[role="imageForm"]')[0]);
	
	if($('input[name="pictureFile"]').val()==""){
		alert("사진을 선택하세요.");
		$('input[name="pictureFile"]').click();
		return;
	};	
	$.ajax({
		url:"<%=request.getContextPath()%>/member/picture/upload.do",
		data:form,
		type:'post',
		processData:false,
		contentType:false,
		success:function(data){
			$('input#oldFile').val(data);
			$('form[role="form"] > input[name="picture"]').val(data);
			$('input[name="checkUpload"]').val(1);
			alert("사진을 업로드 했습니다.");
		},
		error:function(xhr,exception){
			alert("파일 업로드를 실패했습니다.");
		}
	});
	
}

//*****  ID 중복 체크
function CheckID() {
	alert("checkID");
	window.open('employee/idCheck?id=${id}');
}




//***** 경력사항 추가
function RegistCareer() {
	alert("RegistCarrer");
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
	alert('주소검색');
}
</script>