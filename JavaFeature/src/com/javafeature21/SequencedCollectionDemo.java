package com.javafeature21;

import java.util.ArrayDeque;
import java.util.SequencedCollection;

public class SequencedCollectionDemo {
	public static void main(String[] args) {
        SequencedCollection<String> seq = new ArrayDeque();
        seq.add("First");
        seq.add("Second");
        System.out.println(seq.getFirst() + ", " + seq.getLast());
    }
}
