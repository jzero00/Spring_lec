<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
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