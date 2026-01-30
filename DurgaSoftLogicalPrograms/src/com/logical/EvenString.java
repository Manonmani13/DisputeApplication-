package com.logical;

import java.util.Scanner;

public class EvenString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] s=sc.nextLine().split(" ");
		for(String st: s) {
			if(st.length()%2==0)
				System.out.println(st+" ");
		}
		
	}

}
