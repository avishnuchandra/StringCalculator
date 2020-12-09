package org.sample;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest {

	private  StringCalculator stringCalculator;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public  void setup() {
		 stringCalculator = new StringCalculator();
	}
	

	@Test
	public void add_emptyStringTest() throws Exception{
		int sum = stringCalculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void add_nullStringTest() throws Exception{
		int sum = stringCalculator.add(null);
		assertEquals(0, sum);
	}
	
	@Test
	public void add_singleNumberTest() throws Exception{
		int sum = stringCalculator.add("1");
		assertEquals(1, sum);
	}
	@Test
	public void add_TwoNumberTest() throws Exception{
		int sum = stringCalculator.add("1,2");
		assertEquals(3, sum);
	}
	@Test
	public void add_TwoNumberTest1() throws Exception{
		int sum = stringCalculator.add("1,3");
		assertEquals(4, sum);
	}
	@Test
	public void add_unKnownNumbersTest() throws Exception{
		int sum = stringCalculator.add("40,50");
		assertEquals(90, sum);
	}
	@Test
	public void add_newLineTest() throws Exception{
		int sum = stringCalculator.add("1\n,2");
		assertEquals(3, sum);
	}
	@Test
	public void add_differentDelimiterTest() throws Exception {
		int sum = stringCalculator.add("//;\\n1;2");
		assertEquals(3, sum);
	}
	
	@Test
	public void add_negativeNumberTest() throws Exception {
		    exceptionRule.expectMessage("Numbers cannot be negative");
		    exceptionRule.expectMessage("Numbers cannot be negative [-1]");
		    int sum = stringCalculator.add("//;\\n-1;2");
	}
	@Test
	public void add_multipleNegativeTest() throws Exception{
        exceptionRule.expectMessage("Numbers cannot be negative");
	    exceptionRule.expectMessage("Numbers cannot be negative [-1, -2]");
	    int sum = stringCalculator.add("-1,-2");
    }
	@Test
	public void add_numbersbiggerthan1000_ignoredTest() throws Exception {
		int sum = stringCalculator.add("2,1001");
		assertEquals(2, sum);
	}
	@Test
	public void add_delimiterslongerthanonechar_stillacceptedTest() throws Exception {
		int sum = stringCalculator.add("//[***]\\n1***2***3");
		assertEquals(6, sum);
    }
	
	@Test
	public void multipleDelimitersTest() throws Exception {
		int sum = stringCalculator.add("//[*][%]\\n1*2%3");
		assertEquals(6, sum);
    }
	
	@Test
	public void add_multipledelimiters_allusedTest() throws Exception {
		int sum = stringCalculator.add("//[AB][bc]\\n1AB2bc3");
		assertEquals(6, sum);
    }
}
