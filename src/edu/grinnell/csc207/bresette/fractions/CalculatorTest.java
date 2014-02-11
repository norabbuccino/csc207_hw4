package edu.grinnell.csc207.bresette.fractions;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest
{

  @Test
  public void testEvaluate()
    throws Exception
  {
    assertEquals("Testing 1 + -2", "-1", Calculator.evaluate("1 + -2"));
    assertEquals("Testing 1/2 + 2", "5/2", Calculator.evaluate("1/2 + 2"));
    assertEquals("Testing 3 + 2/3", "11/3", Calculator.evaluate("3 + 2/3"));
    assertEquals("Testing 1/2 + 3/2", "2/1", Calculator.evaluate("1/2 + 3/2"));

    assertEquals("Testing 1 - 2", "-1", Calculator.evaluate("1 - 2"));
    assertEquals("Testing 1/2 - 2", "-3/2", Calculator.evaluate("1/2 - 2"));
    assertEquals("Testing 3 - 2/3", "7/3", Calculator.evaluate("3 - 2/3"));
    assertEquals("Testing 1/2 - 3/2", "-1/1", Calculator.evaluate("1/2 - 3/2"));

    assertEquals("Testing 1 * 3", "3", Calculator.evaluate("1 * 3"));
    assertEquals("Testing 1/4 * 3", "3/4", Calculator.evaluate("1/4 * 3"));
    assertEquals("Testing 5 * 3/2", "15/2", Calculator.evaluate("5 * 3/2"));
    assertEquals("Testing 1/2 * 3/7", "3/14", Calculator.evaluate("1/2 * 3/7"));

    assertEquals("Testing 4 / 2", "2", Calculator.evaluate("4 / 2"));
    assertEquals("Testing 1/2 / 2", "1/4", Calculator.evaluate("1/2 / 2"));
    assertEquals("Testing 4 / 2/3", "6/1", Calculator.evaluate("4 / 2/3"));
    assertEquals("Testing 4/2 / 6/3", "1/1", Calculator.evaluate("4/2 / 6/3"));

    assertEquals("Testing -2", "-2", Calculator.evaluate("-2"));
    assertEquals("Testing --2", "2", Calculator.evaluate("--2"));
    assertEquals("Testing -1/2", "-1/2", Calculator.evaluate("-1/2"));
    assertEquals("Testing --2/3", "2/3", Calculator.evaluate("--2/3"));

    String[] expression = new String[5];
    expression[0] = "1 + 2";
    expression[1] = "2 * 3";
    expression[2] = "8 / 4";
    expression[3] = "1/2 + 3";
    expression[4] = "1/2 * 2/3";

    String[] results = new String[5];
    results[0] = "3";
    results[1] = "6";
    results[2] = "2";
    results[3] = "7/2";
    results[4] = "1/3";
    
    assertArrayEquals("Testing expression with results", results, Calculator.evaluate(expression));
  }

}
