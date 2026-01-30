package com.logical;

import java.util.Scanner;
import java.util.StringTokenizer;

public class LongestWord {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		StringTokenizer st=new StringTokenizer(s);
		int m=0;
		String res="";
		while(st.hasMoreTokens()) {
			String token=st.nextToken();
			if(token.length()>m) {
				m=token.length();
				res=token;
			}
		}
		System.out.println(res);
		
	}

}
