package com.javastreams.examples;

import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {

		System.out.println(isPrime(7));
		System.out.println(isPrime(8));
		System.out.println(isPrime(9));
		System.out.println(isPrime(10));
		System.out.println(isPrime(11));

		System.out.println(isPrimeDeclaritive(7));
		System.out.println(isPrimeDeclaritive(8));
		System.out.println(isPrimeDeclaritive(9));
		System.out.println(isPrimeDeclaritive(10));
		System.out.println(isPrimeDeclaritive(11));
	}

	public static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return number > 1;
	}

	public static boolean isPrimeDeclaritive(int number) {
		return number > 1 && IntStream.range(2, number)
				.noneMatch(e -> number % e == 0);
	}

}
