package edu.grinnell.csc207.bresette.fractions;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest
{
  @Test
  public void conversionTest()
  throws Exception
  {
    Fraction frac = new Fraction(2, -3);
    Fraction frac2 = new Fraction("2/-3");
    Fraction frac3 = new Fraction("2", "-3");
    Fraction frac4 = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(-3));
    
    assertEquals("Checking that numerator is now negative", new Fraction(-2, 3), frac);
    assertEquals("Checking that numerator is now negative", new Fraction(-2, 3), frac2);
    assertEquals("Checking that numerator is now negative", new Fraction(-2, 3), frac3);
    assertEquals("Checking that numerator is now negative", new Fraction(-2, 3), frac4);
  }
  
  @Test
  public void addTest()
    throws Exception
  {
    Fraction frac = new Fraction(2, 3);
    assertEquals("Adding 3/2 to 2/3: ", new Fraction(13, 6),
                 frac.add(new Fraction(3, 2)));

    assertEquals("Adding 6 to 2/3", new Fraction(20, 3), frac.add(6));

    assertEquals("Adding 0 to 2/3", frac, frac.add(0));
  } // addTest()

  @Test
  public void multiplyTest()
    throws Exception
  {
    Fraction frac = new Fraction(3, 7);
    assertEquals("Multiplying 3/7 by 2/5: ", new Fraction(6, 35),
                 frac.multiply(new Fraction(2, 5)));

    assertEquals("Multiplying 3/7 by 9: ", new Fraction(27, 7),
                 frac.multiply(9));

    assertEquals("Multiplying 3/7 by 0: ", new Fraction(0, 4), frac.multiply(0));
  } // multiplyTest()

  @Test
  public void minusTest()
    throws Exception
  {
    Fraction frac = new Fraction(2, 9);
    assertEquals("Subtracting 1/4 from 2/9", new Fraction(-1, 36),
                 frac.minus(new Fraction(1, 4)));

    assertEquals("Subtracting 1 from 2/9", new Fraction(-7, 9), frac.minus(1));

    assertEquals("Subtracting 0 from 2/9", frac, frac.minus(0));

  } // minusTest()

  @Test
  public void subtractFromTest()
    throws Exception
  {
    Fraction frac = new Fraction(4, 15);
    assertEquals("Subtracting 4/15 from 16/20", new Fraction(8, 15),
                 frac.subtractFrom(new Fraction(16, 20)));
    assertEquals("Subtracting 4/15 from 2", new Fraction(26, 15),
                 frac.subtractFrom(2));
    assertEquals("Subtracting 4/15 from 0", new Fraction(-4, 15),
                 frac.subtractFrom(0));
  } // subtractFromTest()

  @Test
  public void divideByTest()
    throws Exception
  {
    Fraction frac = new Fraction(9, 17);
    assertEquals("Divide 9/17 by 3/7", new Fraction(21, 17),
                 frac.divideBy(new Fraction(3, 7)));
    assertEquals("Divide 9/17 by 4", new Fraction(9, 68), frac.divideBy(4));
    // assertEquals("Divide 9/17 by 0", new Fraction(1, 2), frac.divideBy(0));
    // this throws an exception as expected!
  } // divideByTest()

  @Test
  public void divideFromTest()
    throws Exception
  {
    Fraction frac = new Fraction(21, 74);
    assertEquals("Divide 4/5 by 21/74", new Fraction(296, 105),
                 frac.divideFrom(new Fraction(4, 5)));
    assertEquals("Divide 6 by 21/74", new Fraction(148, 7), frac.divideFrom(6));
    assertEquals("Divide 0 by 21/74", new Fraction(0, 8), frac.divideFrom(0));
  } // divideFromTest()

  @Test
  public void squareTest()
    throws Exception
  {
    Fraction frac = new Fraction(1, 2);
    assertEquals("Squaring 1/2", new Fraction(1, 4), frac.square());
    Fraction frac2 = new Fraction(0, 10);
    assertEquals("Squaring 0/10", new Fraction(0, 100), frac2.square());
  } // squareTest()

} // class FractionTest
