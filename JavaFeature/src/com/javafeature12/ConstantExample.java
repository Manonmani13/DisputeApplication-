package com.javafeature12;

import java.lang.constant.ClassDesc;

public class ConstantExample {
public static void main(String[] args) {
	ClassDesc desc=String.class.describeConstable().get();
	System.out.println(desc.displayName());
}
}
