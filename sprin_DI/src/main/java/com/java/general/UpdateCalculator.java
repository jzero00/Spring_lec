package com.java.general;

public class UpdateCalculator extends Calculator{
	
	private Summation summation;//= new Sumation();
	public void setSumation(Summation summation) {
		this.summation = summation;
	}
	
	public void sum(int a, int b) {		
		summation.setA(a);
		summation.setB(b);		
		System.out.println("두 정수 "+a+", "+b+"의 합은 "+summation.sum()+"일까요?");
	}
	
	public void sum(int a, int b, int c) {
		if(summation instanceof TripleSummation) {
			((TripleSummation) summation).setC(c);
			int result = summation.sum();
			System.out.println("세 정수 "+a+", "+b+", "+c+"의 합은 "+result+"인줄 알고계십니까?");
		}else {
			System.out.println("함부로 세 정수 합을 하지마세요.");
		}
	}
	
}





