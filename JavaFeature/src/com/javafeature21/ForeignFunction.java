package com.javafeature21;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class ForeignFunction {
	public static void main(String[] args) {
		try (var scope = MemorySession.openConfined()) {
		    MemorySegment buf = scope.allocate(4);
		    buf.set(ValueLayout.JAVA_INT, 0, 123);
		    System.out.println(buf.get(ValueLayout.JAVA_INT, 0));
		}
	}

}
