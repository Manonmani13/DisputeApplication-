package com.logical;

public class VideoLength {
	public static void main(String[] args) {
		String s="02:01";
		int n1,n2;
		if(s.charAt(0)=='0')
			n1=Integer.parseInt(s.substring(1, 2));
		else
			n1=Integer.parseInt(s.substring(0,2));
		if(s.charAt(3)=='0')
			n2=Integer.parseInt(s.substring(4,5));
		else
			n2=Integer.parseInt(s.substring(3,5));
		System.out.println(n1*60+n2);
		
			
	}

}
