package com.interview;

public class ReplaceCharCount {
	 public static int countAndReplaceChar(
	            String input, char oldChar, char newChar) {

	        int count = 0;
	        char[] chars = input.toCharArray();

	        for (int i = 0; i < chars.length; i++) {
	            if (chars[i] == oldChar) {
	                chars[i] = newChar;
	                count++;
	            }
	        }

	        System.out.println("Result String: " + new String(chars));
	        return count;
	    }
	  public static void main(String[] args) {
	        int count = countAndReplaceChar("banana", 'a', 'o');
	        System.out.println("Replaced Count: " + count);
	    }

}
