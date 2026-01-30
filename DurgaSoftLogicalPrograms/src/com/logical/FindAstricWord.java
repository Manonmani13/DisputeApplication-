package com.logical;

import java.util.Scanner;

public class FindAstricWord {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st=sc.nextLine();
		int i=0,j=0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)=='*')
				System.out.print(st.charAt(j++));
		}
	}

}
