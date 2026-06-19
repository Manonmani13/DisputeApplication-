package com.stream.programs;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenList {
public static void main(String[] args) {
	  List<List<Integer>> list =
              Arrays.asList(
                      Arrays.asList(1,2),
                      Arrays.asList(3,4),
                      Arrays.asList(5,6)
              );
	  List<Integer> flat=list.stream().flatMap(Collection:: stream)
	  .collect(Collectors.toList());
	  System.out.println(flat);
}
}
