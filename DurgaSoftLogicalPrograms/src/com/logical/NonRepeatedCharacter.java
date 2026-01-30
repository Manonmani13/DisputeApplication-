package com.logical;

import java.util.Scanner;

public class NonRepeatedCharacter {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i,u,j;
		for( i=0;i<s.length();i++) {
			u=1;
			for(j=0;j<s.length();j++) {
				if(i!=j && s.charAt(i)==s.charAt(j)) {
					u=0;
					break;	
				}
			
			}
			if(u==1) {
				System.out.println(s.charAt(i));
				break;
			}
		}
	}

}
