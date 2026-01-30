package com.interview;

import java.util.regex.Pattern;

public class URLPAttern {
	private static final String URL="^(https:?\\/\\/)?(www\\.)?[a-zA-Z0-9\\-]+(\\.[a-zA-Z]{2,})(\\/\\S*)?$";

	public static void main(String[] args) {
        String url = "https://www.google.com/search?q=java";
        boolean isValid=Pattern.matches(URL, url);
        System.out.println(isValid);
	}
}
