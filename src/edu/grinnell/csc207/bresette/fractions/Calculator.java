package edu.grinnell.csc207.bresette.fractions;

public class Calculator
{

  public static boolean isFraction(String frac)
  {
    return frac.contains("/");
  } // isFraction(String frac)

  public static String store(String expression)
    throws Exception
  {
    String[] splitArray = new String[2];
    splitArray = expression.split(" = ");
    if (!splitArray[1].contains(" "))
      {
        return splitArray[1];
      } // if (!splitArray[1].contains(" "))
    else
      {
        return evaluate(splitArray[1]);
      } // else
  } // store(String)

  public static String operateFraction(Fraction frac2, String[] array,
                                       char operator)
    throws Exception
  {
    if (isFraction(array[0]))
      {
        Fraction frac1 = new Fraction(array[0]);
        if (isFraction(array[1]))
          {
            frac2 = new Fraction(array[1]);
            if (operator == '+')
              frac1 = frac1.add(frac2);
            else if (operator == '-')
              frac1 = frac1.minus(frac2);
            else if (operator == '*')
              frac1 = frac1.multiply(frac2);
            else if (operator == '/')
              frac1 = frac1.divideBy(frac2);
          } // (isFraction(splitArray[1]))
        else
          {
            if (operator == '+')
              frac1 = frac1.add(Integer.parseInt(array[1]));
            else if (operator == '-')
              frac1 = frac1.minus(Integer.parseInt(array[1]));
            else if (operator == '*')
              frac1 = frac1.multiply(Integer.parseInt(array[1]));
            else if (operator == '/')
              frac1 = frac1.divideBy(Integer.parseInt(array[1]));
          } // else
        return frac1.toString();
      } // else if (isFraction(splitArray[0]))
    else if (isFraction(array[1]))
      {
        frac2 = new Fraction(array[1]);
        if (operator == '+')
          frac2 = frac2.add(Integer.parseInt(array[0]));
        else if (operator == '-')
          frac2 = frac2.subtractFrom(Integer.parseInt(array[0]));
        else if (operator == '*')
          frac2 = frac2.multiply(Integer.parseInt(array[0]));
        else if (operator == '/')
          frac2 = frac2.divideFrom(Integer.parseInt(array[0]));

        return frac2.toString();
      } // else if (isFraction(splitArray[1]))
    else
      {
        int intResult = 0;
        if (operator == '+')
          intResult = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
        else if (operator == '-')
          intResult = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
        else if (operator == '*')
          intResult = Integer.parseInt(array[0]) * Integer.parseInt(array[1]);
        else if (operator == '/')
          intResult = Integer.parseInt(array[0]) / Integer.parseInt(array[1]);

        return Integer.toString(intResult);
      } // else
  } // operateFraction(Fraction frac2, String[] array, char operator)

  public static String findR(String[] array, char operator, Fraction frac)
    throws Exception
  {
    int intResult = 0;
    if (isFraction(array[1]))
      {
        frac = new Fraction(array[1]); // what if r is a fraction and you add
                                       // something to it?
        Fraction returnFrac = new Fraction("1/1");

        if (isFraction(r[Character.getNumericValue(array[0].charAt(1))]))
          {
            Fraction rFrac =
                new Fraction(r[Character.getNumericValue(array[0].charAt(1))]);
            if (operator == '+')
              returnFrac = rFrac.add(frac);
            else if (operator == '-')
              returnFrac = rFrac.minus(frac);
            else if (operator == '*')
              returnFrac = rFrac.multiply(frac);
            else if (operator == '/')
              returnFrac = rFrac.divideBy(frac);
          } // if (isFraction(r[Character.getNumericValue(array[0].charAt(1))]))
        else
          {
            if (operator == '+')
              returnFrac =
                  frac.add(Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]));
            else if (operator == '-')
              returnFrac =
                  frac.subtractFrom(Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]));
            else if (operator == '*')
              returnFrac =
                  frac.multiply(Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]));
            else if (operator == '/')
              returnFrac =
                  frac.divideFrom(Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]));
          } // else
        return returnFrac.toString();
      } // if (isFraction(array[1]))
    else
      {
        String result = "";
        if (isFraction(r[Character.getNumericValue(array[0].charAt(1))]))
          {
            Fraction rFrac =
                new Fraction(r[Character.getNumericValue(array[0].charAt(1))]);
            if (operator == '+')
              rFrac = rFrac.add(Integer.parseInt(array[1]));
            else if (operator == '-')
              rFrac = rFrac.minus(Integer.parseInt(array[1]));
            else if (operator == '*')
              rFrac = rFrac.multiply(Integer.parseInt(array[1]));
            else if (operator == '/')
              rFrac = rFrac.divideBy(Integer.parseInt(array[1]));
            result = rFrac.toString();
          } // if (isFraction(r[Character.getNumericValue(array[0].charAt(1))]))
        else
          {
            if (operator == '+')
              intResult =
                  Integer.parseInt(array[1])
                      + Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]);
            else if (operator == '-')
              intResult =
                  Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))])
                      - Integer.parseInt(array[1]);
            else if (operator == '*')
              intResult =
                  Integer.parseInt(array[1])
                      * Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]);
            else if (operator == '/')
              intResult =
                  Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))])
                      / Integer.parseInt(array[1]);
            result = Integer.toString(intResult);
          } // else
        return result;
      } // else
  }

  static String[] r = new String[8];

  /**
   * 
   * Evaluates the given mathematical expression. Supports the operators '=',
   * '+', '-', '*', and '/'. It also supports storage of up to 8 numbers.
   * 
   * preconditions: The expression must contain only Fractions or integers. The
   * expression must have a space between the values and the operators (ex.
   * "1 + 2"). Stored variables must consist of 'r' and the desired storage
   * number between 0 and 7 (ex. "r3"). If a stored variable is used in an
   * equation, it must not be in the position after any operator other than '='
   * (ex. "r1 = r0 + 1").
   * 
   * @param expression
   * @return
   * @throws Exception
   */

  public static String evaluate(String expression)
    throws Exception
  {

    String[] splitArray = new String[2];
    Fraction frac2 = new Fraction(1, 1);

    int intResult;
    String result = "";
    if (expression.contains(" = "))
      {
        r[Character.getNumericValue(expression.charAt(1))] = store(expression);
        result = r[Character.getNumericValue(expression.charAt(1))];
      } // if (expression.contains(" = "))

    else if (expression.contains(" + "))
      {
        splitArray = expression.split(" \\+ ");
        if (splitArray[0].contains("r") || splitArray[1].contains("r"))
          {
            result = findR(splitArray, '+', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operateFraction(frac2, splitArray, '+');
          } // else
      } // else if (expression.contains(" + "))

    else if (expression.contains(" - "))
      {
        splitArray = expression.split(" - ");
        if (splitArray[0].contains("r"))
          {
            result = findR(splitArray, '-', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operateFraction(frac2, splitArray, '-');
          } // else
      } // else if (expression.contains(" - "))

    else if (expression.contains(" * "))
      {
        splitArray = expression.split(" \\* ");
        if (splitArray[0].contains("r"))
          {
            result = findR(splitArray, '*', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operateFraction(frac2, splitArray, '*');
          } // else
      } // else if (expression.contains(" * "))

    else if (expression.contains(" / "))
      {
        splitArray = expression.split(" / ");
        if (splitArray[0].contains("r"))
          {
            result = findR(splitArray, '/', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operateFraction(frac2, splitArray, '/');
          } // else
      } // else if (expression.contains(" / "))

    else if (expression.contains("-"))
      {
        if (isFraction(expression))
          {
            Fraction frac = new Fraction(expression.replaceFirst("-", ""));
            frac.negate();
            result = frac.toString();
          } // if (isFraction(expression))
        else
          {
            intResult = 0 - Integer.parseInt(expression.replaceFirst("-", ""));
            result = Integer.toString(intResult);
          } // else
      } // else if (expression.contains("-"))
    else if (expression.equalsIgnoreCase("q"))
      {
        result = "Program terminated";
      } // else if (expression.equalsIgnoreCase("q"))
    else
      {
        result = "Invalid expression, please try again";
      } // else
    return result;
  } // evaluate(String)

  public static String[] evaluate(String[] expression)
    throws Exception
  {
    String[] result = new String[expression.length];
    for (int i = 0; i < expression.length; i++)
      {
        result[i] = evaluate(expression[i]);
      } // for (i)
    return result;
  } // evaluate(String[])

} // class Calculator
