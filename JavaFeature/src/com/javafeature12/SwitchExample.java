package com.javafeature12;

public class SwitchExample {
	public static void main(String[] args) {
		int day=3;
		String dayType=switch(day) {
		case 1,7->"Weekend";
		case 2,3,4,5,6 ->"Weekday";
		default ->"Invalid day";
		};
		System.out.println(dayType);
	}

}
