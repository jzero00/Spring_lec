package com.groupware.exception;

public class OverflowFileSizeException extends Exception {

	public OverflowFileSizeException() {
		super("파일 용량을 초과하였습니다.");
	}
}
