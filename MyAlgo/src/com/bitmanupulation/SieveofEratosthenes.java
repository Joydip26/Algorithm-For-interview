package com.bitmanupulation;

public class SieveofEratosthenes {
	static void sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int i = 1; i < prime.length; i++) {
			if (i == 1) {
				prime[i] = true;
			} else if (prime[i] == true) {
				if (isPrime(i)) {
					for (int j = i+1; j <= n; j++) {
						if (j % i == 0)
							prime[j] = false;
					}
				}
			}
		}

		for (int i = 0; i < prime.length; i++) {
			if (prime[i] == true)
				System.out.println(i);
		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 30;
		System.out.print("Following are the prime numbers ");
		sieveOfEratosthenes(n);
	}

}
