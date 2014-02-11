package edu.grinnell.csc207.bresette.fractions;

import java.math.BigInteger;

/**
 * Using Fraction class from Laboratory: Designing your own classes
 * 
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
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
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom) throws Exception
  {
    if (denom.equals(0))
      {
        throw new DivideByZeroException("Denominator cannot be zero");
      }
    else
      {
        this.num = num;
        this.denom = denom;
      }
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(int num, int denom) throws Exception
  {
    if (denom == 0)
      {
        throw new DivideByZeroException("Denominator cannot be zero");
      }
    else
      {
        this.num = BigInteger.valueOf(num);
        this.denom = BigInteger.valueOf(denom);
      }
  } // Fraction(int, int)

  /**
   * Build a new Fraction from String values for the numerator and the
   * denominator
   * 
   * @throws DivideByZeroException
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
        this.num = BigInteger.valueOf(numerator);
        this.denom = BigInteger.valueOf(denominator);
      } // else
  } // Fraction(String, String)

  /**
   * Build a new Fraction from a single String
   * @param frac
   * @throws DivideByZeroException
   */
  public Fraction(String frac) throws DivideByZeroException
  {
    String[] fracArray = frac.split("/");
    int numerator = Integer.parseInt(fracArray[0]);
    int denominator = Integer.parseInt(fracArray[1]);
    if(denominator == 0)
      {
        throw new DivideByZeroException("Denominator cannot be zero");
      }
    else
      {
        this.num = BigInteger.valueOf(numerator);
        this.denom = BigInteger.valueOf(denominator);
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
   * @throws Exception
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

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Add an integer to this fraction.
   * 
   * @throws Exception
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
   * @throws Exception
   */
  public Fraction multiply(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = this.num.multiply(frac.num);
    resultDenominator = this.denom.multiply(frac.denom);

    return new Fraction(resultNumerator, resultDenominator);
  } // multiply(Fraction)

  /**
   * Multiply the fraction with an integer
   * 
   * @throws Exception
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
   * @throws Exception
   */
  public Fraction minus(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(frac.denom);
    resultNumerator =
        (this.num.multiply(frac.denom)).subtract(frac.num.multiply(this.denom));
    return new Fraction(resultNumerator, resultDenominator);
  } // minus(Fraction)

  /**
   * Subtract an integer from this fraction
   * 
   * @throws Exception
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
   * @throws Exception
   */
  public Fraction subtractFrom(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(frac.denom);
    resultNumerator =
        (frac.num.multiply(this.denom)).subtract(this.num.multiply(frac.denom));
    return new Fraction(resultNumerator, resultDenominator);
  } // subtractFrom(Fraction)

  /**
   * Subtract this fraction from an integer
   * 
   * @throws Exception
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
   * @throws Exception
   */
  public Fraction divideBy(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(frac.num);
    resultNumerator = this.num.multiply(frac.denom);
    return new Fraction(resultNumerator, resultDenominator);
  }// divideBy(Fraction)

  /**
   * Divide this fraction by an integer.
   * 
   * @throws Exception
   */
  public Fraction divideBy(int val)
    throws Exception
  {
    if(val == 0)
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
   * @throws Exception
   */
  public Fraction divideFrom(Fraction frac)
    throws Exception
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.num.multiply(frac.denom);
    resultNumerator = this.denom.multiply(frac.num);
    return new Fraction(resultNumerator, resultDenominator);
  } // divideFrom(Fraction)

  /**
   * Divide an integer by this fraction.
   * 
   * @throws Exception
   */
  public Fraction divideFrom(int val)
    throws Exception
  {
    BigInteger resultNumerator;
    resultNumerator = BigInteger.valueOf(val).multiply(this.denom);
    return new Fraction(resultNumerator, this.num);
  }// divideFrom(int)

  /**
   * Square this fraction
   * 
   * @throws Exception
   */
  public Fraction square()
    throws Exception
  {
    return new Fraction(this.num.multiply(this.num),
                        this.denom.multiply(this.denom));
  }

  public void simplify()
  {
    BigInteger gcd = this.num.gcd(denom);

    this.num = this.num.divide(gcd);
    this.denom = this.denom.divide(gcd);

  }
  
  /**
   * Convert this fraction to a string for ease of printing.
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
   * @throws Exception 
   */
  public boolean equals(Fraction other)
  {
    this.simplify();
    other.simplify();
    return(this.num.equals(other.num) && this.denom.equals(other.denom));

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
} // class Fraction
