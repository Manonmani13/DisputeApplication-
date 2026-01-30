package com.logical;

import java.util.Scanner;

public class MissingCharacter {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		StringBuffer sb=new StringBuffer();
		for(int i='a';i<'z';i++) {
			if(s.indexOf(i)==-1)
				sb.append((char)i);
		}
		System.out.println(sb);
	}

}
