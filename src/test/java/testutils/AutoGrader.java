package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.UnaryExpr;

public class AutoGrader {

	// Test for logical operations (e.g., &&, ||, !)
	public boolean testLogicalOperations(String filePath) throws IOException {
		System.out.println("Starting testLogicalOperations with file: " + filePath);

		// Load participant's file
		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		// Parse the file using JavaParser
		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		// Variables to check conditions
		boolean hasLogicalOperations = false;

		// 1. Checking Logical Operations (&&, ||, !)
		System.out.println("------ Checking Logical Operations ------");
		// Check for logical AND (&&) and OR (||)
		for (BinaryExpr expr : cu.findAll(BinaryExpr.class)) {
			if (expr.getOperator() == BinaryExpr.Operator.AND || expr.getOperator() == BinaryExpr.Operator.OR) {
				hasLogicalOperations = true;
				System.out.println("✓ Found logical operation: " + expr.getOperator());
			}
		}

		// Check for NOT (!) operator
		for (UnaryExpr expr : cu.findAll(UnaryExpr.class)) {
			if (expr.getOperator() == UnaryExpr.Operator.LOGICAL_COMPLEMENT) {
				hasLogicalOperations = true;
				System.out.println("✓ Found logical NOT operation: !");
			}
		}

		// Output the result
		if (hasLogicalOperations) {
			System.out.println("✓ Logical operations (&&, ||, !) are present.");
		} else {
			System.out.println("✘ Missing logical operations.");
		}

		// Test result
		boolean result = hasLogicalOperations;
		System.out.println("Test result: " + result);

		return result;
	}
}
