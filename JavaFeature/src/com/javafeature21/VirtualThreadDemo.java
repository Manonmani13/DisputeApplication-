package com.javafeature21;

import java.util.concurrent.Executors;

public class VirtualThreadDemo {
	public static void main(String[] args) {
		try(var executor =Executors.newVirtualThreadPerTaskExecutor()){
			for(int i=0;i<1000;i++) {
				int id=1;
				executor.submit(()->
				{
                    System.out.println("Task " + id + " on " + Thread.currentThread());
				});
			}
		}
	}

}
