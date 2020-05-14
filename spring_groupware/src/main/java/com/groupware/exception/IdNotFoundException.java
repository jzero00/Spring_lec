package com.groupware.exception;

public class IdNotFoundException extends Exception {
	
	public IdNotFoundException () {
		super("아이디가 존재하지 않습니다.");
	}
}
