package functional;

import static testutils.TestUtils.businessTestFile;
import static testutils.TestUtils.currentTest;
import static testutils.TestUtils.testReport;
import static testutils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import testutils.AutoGrader;

public class FunctionalTest {

	// Provide the path to the LogicalOperatorsAssignment class file
	String filePath = "src/main/java/com/yaksha/assignment/LogicalOperatorsAssignment.java";

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testLogicalOperations() throws Exception {
		AutoGrader autoGrader = new AutoGrader();
		boolean result = autoGrader.testLogicalOperations(filePath);
		yakshaAssert(currentTest(), result, businessTestFile);
	}
}
