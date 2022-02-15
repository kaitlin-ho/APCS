/*
Team AK: Ariella Katz, Kaitlin Ho, Tom, Apple
APCS
HW64: Revisitation
2022-02-14
time spent: 0.5 hrs
*/

public class Recursion1 {

/*
Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
factorial(1) → 1
factorial(2) → 2
factorial(3) → 6
*/
	public int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return (n * factorial(n-1));
		}
	}

/*
We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
bunnyEars(0) → 0
bunnyEars(1) → 2
bunnyEars(2) → 4
*/
	public int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}
		else {
			return (2 + bunnyEars(bunnies-1));
		}
	}

/*
The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
fibonacci(0) → 0
fibonacci(1) → 1
fibonacci(2) → 1
*/
	public int fibonacci(int n) {
		if (n == 0) { return 0; }
		else if (n == 1) { return 1; }
		else { return fibonacci(n-1) + (fibonacci(n-2)); }
	}

/*
We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5
*/
	public int bunnyEars2(int bunnies) {
		if (bunnies == 0) { return 0; }
		else if (bunnies == 1) { return 2; }
		else {
			if (bunnies % 2 == 0) { return (3 + bunnyEars2(bunnies-1)); }
			else { return (2 + bunnyEars2(bunnies-1)); }
		}
	}

/*
We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
triangle(0) → 0
triangle(1) → 1
triangle(2) → 3
*/
	public int triangle(int rows) {
		if (rows == 0) { return 0; }
		else { return (rows + triangle(rows-1)); }
	}

	public static void main(String[] args) {
		Recursion1 recurse = new Recursion1();
		System.out.println("Expecting 1...");
		System.out.println(recurse.factorial(1));
    System.out.println("Expecting 2...");
    System.out.println(recurse.factorial(2));
    System.out.println("Expecting 6...");
    System.out.println(recurse.factorial(3));
    System.out.println("Expecting 24...");
    System.out.println(recurse.factorial(4));
    System.out.println("Expecting 120...");
    System.out.println(recurse.factorial(5));
    System.out.println("Expecting 720...");
    System.out.println(recurse.factorial(6));
    System.out.println("Expecting 40320...");
    System.out.println(recurse.factorial(8));
    System.out.println("Expecting 479001600...");
    System.out.println(recurse.factorial(12));

		System.out.println("-------------------------");

		System.out.println("Expecting 0...");
		System.out.println(recurse.bunnyEars(0));
    System.out.println("Expecting 2...");
    System.out.println(recurse.bunnyEars(1));
    System.out.println("Expecting 4...");
    System.out.println(recurse.bunnyEars(2));
    System.out.println("Expecting 6...");
    System.out.println(recurse.bunnyEars(3));
    System.out.println("Expecting 8...");
    System.out.println(recurse.bunnyEars(4));
    System.out.println("Expecting 10...");
    System.out.println(recurse.bunnyEars(5));
    System.out.println("Expecting 24...");
    System.out.println(recurse.bunnyEars(12));
    System.out.println("Expecting 100...");
    System.out.println(recurse.bunnyEars(50));
    System.out.println("Expecting 468...");
    System.out.println(recurse.bunnyEars(234));

    System.out.println("-------------------------");

		System.out.println("Expecting 0...");
		System.out.println(recurse.fibonacci(0));
    System.out.println("Expecting 1...");
    System.out.println(recurse.fibonacci(1));
    System.out.println("Expecting 1...");
    System.out.println(recurse.fibonacci(2));
    System.out.println("Expecting 2...");
    System.out.println(recurse.fibonacci(3));
    System.out.println("Expecting 3...");
    System.out.println(recurse.fibonacci(4));
    System.out.println("Expecting 5...");
  	System.out.println(recurse.fibonacci(5));
    System.out.println("Expecting 8...");
    System.out.println(recurse.fibonacci(6));
    System.out.println("Expecting 13...");
    System.out.println(recurse.fibonacci(7));

    System.out.println("-------------------------");

		System.out.println("Expecting 0...");
		System.out.println(recurse.bunnyEars2(0));
		System.out.println("Expecting 2...");
		System.out.println(recurse.bunnyEars2(1));
		System.out.println("Expecting 5...");
		System.out.println(recurse.bunnyEars2(2));
		System.out.println("Expecting 7...");
		System.out.println(recurse.bunnyEars2(3));
		System.out.println("Expecting 10...");
		System.out.println(recurse.bunnyEars2(4));
		System.out.println("Expecting 15...");
		System.out.println(recurse.bunnyEars2(6));
		System.out.println("Expecting 25...");
		System.out.println(recurse.bunnyEars2(10));

    System.out.println("-------------------------");

		System.out.println("Expecting 0...");
		System.out.println(recurse.triangle(0));
		System.out.println("Expecting 1...");
		System.out.println(recurse.triangle(1));
		System.out.println("Expecting 3...");
		System.out.println(recurse.triangle(2));
		System.out.println("Expecting 6...");
		System.out.println(recurse.triangle(3));
		System.out.println("Expecting 10...");
		System.out.println(recurse.triangle(4));
		System.out.println("Expecting 15...");
		System.out.println(recurse.triangle(5));
		System.out.println("Expecting 21...");
		System.out.println(recurse.triangle(6));
		System.out.println("Expecting 28...");
		System.out.println(recurse.triangle(7));
	}

}
