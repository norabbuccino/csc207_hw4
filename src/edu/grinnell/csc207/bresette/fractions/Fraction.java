package edu.grinnell.csc207.bresette.fractions;

import java.math.BigInteger;

/**
 * Using Fraction class from Laboratory: Designing your own classes
 * 
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Nora Bresette Buccino and Erin Callaway
 * @author CSC152 2005S
 * @version 1.0 of February 2005
 */
public class Fraction
{

  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a negative numerator. Similarly, if a fraction has a
   * negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction in simplified form, one must call the simplify method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom. Where num
   * and denom are BigIntegers
   * 
   * @param num
   *          a BigInteger
   * @param a
   *          BigInteger
   * @throws DivideByZeroException
   * @pre num and denom must be BigIntegers
   * @post returns a Fraction with numerator num and denominator denom
   */
  public Fraction(BigInteger num, BigInteger denom)
                                                   throws DivideByZeroException
  {
    if (denom.equals(0))
      {
        throw new DivideByZeroException("Denominator cannot be zero");
      } // if (denom.equals(0)) testing if the denominator is 0
    else
      {
        if (denom.signum() == -1)
          {
            this.num = num.negate();
            this.denom = denom.negate();
          } // if (denom.signum() == -1) testing if the denominator is negative
        else
          {
            this.num = num;
            this.denom = denom;
          }// else
      } // else
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom. Where num
   * and denom are ints
   * 
   * @param num
   *          an int
   * @param denom
   *          an int
   * @throws DivideByZeroException
   * @pre both num and denom must be ints
   * @post returns a Fraction with numerator num and denominator denom
   */
  public Fraction(int num, int denom) throws DivideByZeroException
  {
    if (denom == 0)
      {
        throw new DivideByZeroException("Denominator cannot be zero");
      } // if (denom == 0) testing if the denominator is zero
    else
      {
        if (denom < 0)
          {
            this.num = BigInteger.valueOf(0 - num);
            this.denom = BigInteger.valueOf(0 - denom);
          } // if (denom < 0) testing if the denominator is negative
        else
          {
            this.num = BigInteger.valueOf(num);
            this.denom = BigInteger.valueOf(denom);
          } // else
      }
  } // Fraction(int, int)

  /**
   * Build a new Fraction from String values for the numerator and the
   * denominator
   * 
   * @param num
   *          a String
   * @param denom
   *          a String
   * @throws DivideByZeroException
   * @pre num and denom must be Strings that contain integers
   * @post returns a new Fraction with numerator num and denominator denom
   */
  public Fraction(String num, String denom) throws DivideByZeroException
  {
    int numerator = Integer.parseInt(num);
    int denominator = Integer.parseInt(denom);
    if (denominator == 0)
      {
        throw new DivideByZeroException("Denominator cannot be zero");
      } // if (denominator == 0)
    else
      {
        if (denominator < 0)
          {
            this.num = BigInteger.valueOf(0 - numerator);
            this.denom = BigInteger.valueOf(0 - denominator);
          } // if (denominator < 0) testing if the denominator is negative
        else
          {
            this.num = BigInteger.valueOf(numerator);
            this.denom = BigInteger.valueOf(denominator);
          } // else
      } // else
  } // Fraction(String, String)

  /**
   * Build a new Fraction from a single String
   * 
   * @param frac
   *          a String
   * @throws DivideByZeroException
   * @pre frac must be a String that contains an integer followed by a /
   *      followed by another integer. There should not be any spaces between
   *      the numbers and the slash.
   * @post returns a Fraction with numerator as the integer before the slash and
   *       the denominator as the integer after the slash.
   */
  public Fraction(String frac) throws DivideByZeroException
  {
    String[] fracArray = frac.split("/");
    int numerator = Integer.parseInt(fracArray[0]);
    int denominator = Integer.parseInt(fracArray[1]);
    if (denominator == 0)
      {
        throw new DivideByZeroException("Denominator cannot be zero");
      } // if (denominator == 0)
    else
      {
        if (denominator < 0)
          {
            this.num = BigInteger.valueOf(0 - numerator);
            this.denom = BigInteger.valueOf(0 - denominator);
          } // if (denominator < 0)
        else
          {
            this.num = BigInteger.valueOf(numerator);
            this.denom = BigInteger.valueOf(denominator);
          } // else
      }
  } // Fraction(String)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue()
  {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction other to this fraction.
   * 
   * @param addMe
   *          a Fraction
   * @return a new Fraction
   * @throws Exception
   * @pre addMe must be a fraction
   * @post returns a new Fraction of the sum of the two fractions
   */
  public Fraction add(Fraction addMe)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));
    Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
    resultFrac.simplify();
    return resultFrac;
  }// add(Fraction)

  /**
   * Add an integer to this fraction.
   * 
   * @param val
   *          an int
   * @return a new Fraction
   * @throws Exception
   * @pre val must be an int
   * @post returns a new Fraction of the sum of the fraction and the int
   */
  public Fraction add(int val)
    throws Exception
  {
    BigInteger resultNumerator;
    resultNumerator =
        this.num.add(BigInteger.valueOf(val).multiply(this.denom));
    return new Fraction(resultNumerator, this.denom);
  }// add(int)

  /**
   * Multiply the fraction with another fraction
   * 
   * @param frac
   *          a Fraction
   * @return a new Fraction
   * @throws Exception
   * @pre frac must be a fraction
   * @post returns the product of the two fractions
   */
  public Fraction multiply(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = this.num.multiply(frac.num);
    resultDenominator = this.denom.multiply(frac.denom);
    Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
    resultFrac.simplify();
    return resultFrac;
  } // multiply(Fraction)

  /**
   * Multiply the fraction with an integer
   * 
   * @param val
   *          an int
   * @return a new Fraction
   * @throws Exception
   * @pre val must be an int
   * @post returns a new Fraction of the product of the fraction and val
   */
  public Fraction multiply(int val)
    throws Exception
  {
    BigInteger resultNumerator;
    resultNumerator = this.num.multiply(BigInteger.valueOf(val));
    return new Fraction(resultNumerator, this.denom);
  }// multiply(int)

  /**
   * Subtract a fraction from this fraction
   * 
   * @param frac
   *          a Fraction
   * @return a new Fraction
   * @throws Exception
   * @pre frac must be a fraction and it must be the value that is being
   *      subtracted.
   * @post returns the difference between the two fractions
   */
  public Fraction minus(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(frac.denom);
    resultNumerator =
        (this.num.multiply(frac.denom)).subtract(frac.num.multiply(this.denom));
    Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
    resultFrac.simplify();
    return resultFrac;
  } // minus(Fraction)

  /**
   * Subtract an integer from this fraction
   * 
   * @param val
   *          an int
   * @return a new Fraction
   * @throws Exception
   * @pre val must be an int. it also must be the value that is being
   *      subtracted.
   * @post returns a new Fraction with the difference between the fraction and
   *       the value
   */
  public Fraction minus(int val)
    throws Exception
  {
    BigInteger resultNumerator;
    resultNumerator =
        this.num.subtract(BigInteger.valueOf(val).multiply(this.denom));
    return new Fraction(resultNumerator, this.denom);
  }// minus(int)

  /**
   * Subtract this fraction from a fraction
   * 
   * @param frac
   *          a Fraction
   * @return a new Fraction
   * @throws Exception
   * @pre frac must be a fraction and it must be the value that is being
   *      subtracted from.
   * @post returns a new fraction of the difference between a fraction and this
   *       fraction
   */
  public Fraction subtractFrom(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(frac.denom);
    resultNumerator =
        (frac.num.multiply(this.denom)).subtract(this.num.multiply(frac.denom));
    Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
    resultFrac.simplify();
    return resultFrac;
  } // subtractFrom(Fraction)

  /**
   * Subtract this fraction from an integer
   * 
   * @param val
   *          an int
   * @return a new Fraction
   * @throws Exception
   * @pre val must be an int and it must be the value that is being subtracted
   *      from.
   * @post returns a new Fraction of the difference between val and the
   *       fraction.
   */
  public Fraction subtractFrom(int val)
    throws Exception
  {
    BigInteger resultNumerator;
    resultNumerator =
        BigInteger.valueOf(val).multiply(this.denom).subtract(this.num);
    return new Fraction(resultNumerator, this.denom);
  }// subtractFrom(int)

  /**
   * Divide this fraction by a fraction.
   * 
   * @param frac
   *          a Fraction
   * @return a new Fraction
   * @throws Exception
   * @pre frac must be a fraction and it must be the divisor
   * @post returns a new fraction of the quotient of the fractions
   */
  public Fraction divideBy(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(frac.num);
    resultNumerator = this.num.multiply(frac.denom);
    Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
    resultFrac.simplify();
    return resultFrac;
  }// divideBy(Fraction)

  /**
   * Divide this fraction by an integer.
   * 
   * @param val
   *          an int
   * @return a new Fraction
   * @throws Exception
   * @pre val must be an int and it must be the divisor
   * @post returns a new Fraction of the quotient of the fraction divided by the
   *       int
   */
  public Fraction divideBy(int val)
    throws Exception
  {
    if (val == 0)
      {
        throw new DivideByZeroException("Cannot divide by 0");
      }
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(BigInteger.valueOf(val));
    return new Fraction(this.num, resultDenominator);
  }// divideBy(int)

  /**
   * Divide a fraction by this fraction.
   * 
   * @param frac
   *          a Fraction
   * @return a new Fraction
   * @throws Exception
   * @pre frac must be a Fraction and must be the dividend
   * @post returns a new Fraction of the quotient of the two fractions
   */
  public Fraction divideFrom(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.num.multiply(frac.denom);
    resultNumerator = this.denom.multiply(frac.num);
    Fraction resultFrac = new Fraction(resultNumerator, resultDenominator);
    resultFrac.simplify();
    return resultFrac;
  } // divideFrom(Fraction)

  /**
   * Divide an integer by this fraction.
   * 
   * @param val
   *          an int
   * @return a new Fraction
   * @throws Exception
   * @pre val must be an int and it must be the dividend
   * @post returns a new Fraction of the quotient of val divided by the
   *       fractions
   */
  public Fraction divideFrom(int val)
    throws Exception
  {
    BigInteger resultNumerator;
    resultNumerator = BigInteger.valueOf(val).multiply(this.denom);
    Fraction resultFrac = new Fraction(resultNumerator, this.num);
    resultFrac.simplify();
    return resultFrac;
  }// divideFrom(int)

  /**
   * Square this fraction
   * 
   * @return a new Fraction
   * @throws Exception
   */
  public Fraction square()
    throws Exception
  {
    return new Fraction(this.num.multiply(this.num),
                        this.denom.multiply(this.denom));
  }

  /**
   * Convert this fraction to a string for ease of printing.
   * 
   * @return a String with the fraction written as the numerator, a slash, and
   *         the denominator
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0";
      } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  // The following equals methods were taken from the reading on standard object
  // methods
  /**
   * Compare this fraction to another object. The two are only equal if they are
   * both fractions and have the same numerator and denominator.
   */
  public boolean equals(Object other)
  {
    if (other instanceof Fraction)
      {
        return this.equals((Fraction) other);
      }
    else
      {
        return false;
      }
  } // equals(Object)

  /**
   * Compare this fraction to another fraction. They are the same if they have
   * the same numerator and denominator.
   * 
   * @throws Exception
   */
  public boolean equals(Fraction other)
  {
    this.simplify();
    other.simplify();
    return (this.num.equals(other.num) && this.denom.equals(other.denom));

  } // equals(Fraction)

  // hashCode() method adapted from reading on standard object methods

  /**
   * define the hashCode for Fractions as the product of the numerator and
   * denominator
   */
  public int hashCode()
  {
    return this.num.multiply(this.denom).intValue();
  } // hashCode()

  // +----------+------------------------------------------------------
  // | Mutators |
  // +----------+

  /**
   * Simplifies a fraction
   */
  public void simplify()
  {
    BigInteger gcd = this.num.gcd(denom);

    this.num = this.num.divide(gcd);
    this.denom = this.denom.divide(gcd);

  } // simplify()

  /**
   * negates a fraction
   */
  public void negate()
  {
    this.num = this.num.negate();
  } // negate()

} // class Fraction
