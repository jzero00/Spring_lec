package com.groupware.exception;

public class EmptyMultipartFileException extends Exception {
	
	public EmptyMultipartFileException() {
		super("파일을 선택해주세요");
	}
}
