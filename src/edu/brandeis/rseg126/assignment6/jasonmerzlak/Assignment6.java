package edu.brandeis.rseg126.assignment6.jasonmerzlak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Assignment 6
 * This will use a sieve of Eratosthenes to display all primes up to the given
 * number.
 */
public class Assignment6 {
	/**
	 * prime_sieve
	 * Return a stream of primes up to the given number.
	 * 
	 * Using a cheaty method as we build up a list of primes, we only need to
	 * check against primes up to the sqrt of a value.
	 * @param number the value we are displaying primes up to
	 * @return A stream of primes
	 */
	public static IntStream prime_sieve(Integer number) {
		List<Integer> primes = new ArrayList<Integer>();
		return IntStream.rangeClosed(2, number)
			.filter((v) -> {
				Integer sqrt = (int) Math.sqrt(v);
				boolean prime = true;
				for (Integer i : primes) {
					if ( i > sqrt ) { break; }
					if ( v % i == 0 ) { prime = false; break; }
				}
				if ( prime ) { primes.add(v); }
				return prime;
			});
	}
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.printf("Enter a positive number:\n");
			
			int number = input.nextInt();
			
			if ( number < 0 ) {
				System.out.println("Number must be positive.");
				return;
			}
			 
			System.out.printf("Prime numbers up to %d:\n", number);
			var prime_count = new Object() {
			    int value = 0;
			};
			prime_sieve(number).forEach((prime) -> {
				++prime_count.value;
				System.out.println(prime);
			});
			System.out.printf("%d %s.\n", prime_count.value
					                    , prime_count.value == 1 ? 
					                    		"prime" : 
					                    		"primes");
		}
	}
}
