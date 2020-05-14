package com.groupware.exception;

public class InvalidPasswordException extends Exception {

	public InvalidPasswordException() {
		super("해당 ID의 패스워드가 일치하지 않습니다.");
	}
}
