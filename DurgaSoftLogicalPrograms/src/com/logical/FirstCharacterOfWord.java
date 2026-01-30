package com.logical;

import java.util.Scanner;

public class FirstCharacterOfWord {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s[]=sc.nextLine().split(" ");
		for(String ss:s)
			System.out.println(ss.charAt(0));
	}

}
