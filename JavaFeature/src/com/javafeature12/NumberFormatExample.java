package com.javafeature12;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatExample {
	public static void main(String[] args) {
		NumberFormat nf=NumberFormat.getCompactNumberInstance(Locale.US,
				NumberFormat.Style.SHORT);
		System.out.println(nf.format(1000));
		System.out.println(nf.format(100000));
	}

}
