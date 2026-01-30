package com.logical;

public class WarOfNumber {
	public static void main(String[] args) {
		int n[]= {23,21,3,4,2};
		int se=0,so=0;
		for(int i=0;i<n.length;i++) {
			if(n[i]%2==0)
				se=se+n[i];
			else
				so=so+n[i];
		}
		System.out.println(se-so);
		
	}

}
