package com.javastreams.examples;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {

	public static boolean isGreaterThan3(int number) {
		return  number >3;
	}

	public static boolean isEven(int number) {
		return  number%2==0;
	}

	public static int doubleIt(int number) {
		return  number*2;
	}
	public static void main(String[] args) {
		//find the double of first even number greater than 3
		List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
		System.out.println(
				values.stream()
						.filter(MethodReferences::isGreaterThan3)
						.filter(MethodReferences::isEven)
						.map(MethodReferences::doubleIt)
						.findFirst()
						.get()
		);
	}
}
