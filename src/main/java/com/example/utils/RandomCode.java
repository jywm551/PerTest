package com.example.utils;

public class RandomCode {
	private static int genCode(){
		return (int)((Math.random()*9+1)*100000);
	}
	
	public static void main(String[] args) {
		System.out.println(RandomCode.genCode());
	}
}
