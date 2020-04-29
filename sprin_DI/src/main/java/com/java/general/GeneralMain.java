package com.java.general;

public class GeneralMain {

	public static void main(String[] args) {
	
		Calculator cal = new Calculator();
		TripleSummation trisum = new TripleSummation();
		
		cal.setSummation(trisum);
		
		cal.sum(3, 5);
		cal.sum(3, 5, 6);
		
	}

}
