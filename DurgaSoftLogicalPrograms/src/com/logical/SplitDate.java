package com.logical;

public class SplitDate {
	public static void main(String[] args) {
		String date="13-10-2001";
		String s[]=date.split("-");
		System.out.println(s[2].endsWith(Integer.toString(Integer.parseInt(s[0])*Integer.parseInt(s[1]))));
	}

}
