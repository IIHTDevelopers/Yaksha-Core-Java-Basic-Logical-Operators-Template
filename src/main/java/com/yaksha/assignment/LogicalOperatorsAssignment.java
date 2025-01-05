package com.yaksha.assignment;

public class LogicalOperatorsAssignment {

	public static void main(String[] args) {

		// Declare boolean variables
		boolean a = true;
		boolean b = false;

		// 1. Perform logical operations: &&, ||, !
		boolean andResult = a && b; // Bitwise AND
		boolean orResult = a || b; // Bitwise OR
		boolean notResultA = !a; // Bitwise NOT
		boolean notResultB = !b; // Bitwise NOT

		// Print the results of logical operations
		System.out.println("AND (a && b): " + andResult);
		System.out.println("OR (a || b): " + orResult);
		System.out.println("NOT (a): " + notResultA);
		System.out.println("NOT (b): " + notResultB);

		// Declare variables
		int x = 10;
		int y = 20;

		// 2. Combine logical operators in more complex conditions
		boolean complexCondition = (x > 5 && x < 15) || (y > 10 && y < 25);
		boolean negationCondition = !(x == 10);

		// Print the results of the combined logical operations
		System.out.println("Complex Condition ((x > 5 && x < 15) || (y > 10 && y < 25)): " + complexCondition);
		System.out.println("Negation Condition (!(x == 10)): " + negationCondition);
	}
}
