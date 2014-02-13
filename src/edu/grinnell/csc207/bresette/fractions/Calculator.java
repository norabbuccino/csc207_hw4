package edu.grinnell.csc207.bresette.fractions;

public class Calculator
{
<<<<<<< HEAD

  /**
   * Given a String, test if the String is a fraction
   * 
   * @param frac
   *          a String
   * @return either true or false depending on if frac contains a /
   * @pre frac must be a string
   * @post returns a boolean
=======
  /**
   * Determines whether a given string can be made into a fraction.
   * 
   * @param frac
>>>>>>> 8ad02fd16a7657ff3256cc2979d675cf738c2882
   */
  public static boolean isFraction(String frac)
  {
    return frac.contains("/");
  } // isFraction(String frac)

  /**
   * A method to help store the value of the expression that is evaluated in the
   * evaluate method.
   * 
   * @param expression
   * @throws Exception
   */
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

  /**
<<<<<<< HEAD
   * Does all of the operations required by the calculator using fractions
   * 
   * @param frac2
   *          a Fraction
   * @param array
   *          a String Array
   * @param operator
   *          a char
   * @return a String
   * @throws Exception
   * @pre frac must be a fraction, array must be a string array, and operator
   *      must be one of the following chars: +, -, *, /
   * @post the result is a String which is the result of the given operation on
   *       the fraction.
   */
  public static String operateFraction(Fraction frac2, String[] array,
                                       char operator)
=======
   * Determines the value of the expression if it does not contain a storage
   * variable.
   * 
   * @param frac2
   * @param array
   * @param operator
   * @throws Exception
   */
  public static String operate(Fraction frac2, String[] array, char operator)
>>>>>>> 8ad02fd16a7657ff3256cc2979d675cf738c2882
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
  } // operation(Fraction frac2, String[] array, char operator)

  /**
<<<<<<< HEAD
   * This method does all of the calculator operations when using storage units
   * of r
   * 
   * @param array
   *          a String array
   * @param operator
   *          a char
   * @param frac
   *          a Fraction
   * @return a String
   * @throws Exception
   * @pre array must be an array of strings, operator must be one of the
   *      following chars: +, -, *, /. Frac must be a fraction
   * 
   */
  public static String findR(String[] array, char operator, Fraction frac)
=======
   * Computes the value produced from the operation between the storage variable
   * 'r' and another element.
   * 
   * @param array
   * @param operator
   * @param frac
   * @throws Exception
   */
  public static String computeR(String[] array, char operator, Fraction frac)
>>>>>>> 8ad02fd16a7657ff3256cc2979d675cf738c2882
    throws Exception
  {
    int intResult = 0;
    if (isFraction(array[1]))
      {
        frac = new Fraction(array[1]);
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
   * Evaluates the given mathematical expression. Supports the operators '=',
   * '+', '-', '*', and '/'. It also supports storage of up to 8 numbers.
   * 
   * @Preconditions The expression must contain only Fractions or integers. The
   *                expression must have a space between the values and the
   *                operators (ex. "1 + 2"). Stored variables must consist of
   *                'r' and the desired storage number between 0 and 7 (ex.
   *                "r3"). If a stored variable is used in an equation, it must
   *                not be in the position after any operator other than '='
   *                (ex. "r1 = r0 + 1") not "r1 = 1 + r0").
   * 
   * @Postconditions The given expression will be evaluated and if a storage
   *                 variable is given, it will store the evaluation at that
   *                 location.
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
            result = computeR(splitArray, '+', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operate(frac2, splitArray, '+');
          } // else
      } // else if (expression.contains(" + "))

    else if (expression.contains(" - "))
      {
        splitArray = expression.split(" - ");
        if (splitArray[0].contains("r"))
          {
            result = computeR(splitArray, '-', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operate(frac2, splitArray, '-');
          } // else
      } // else if (expression.contains(" - "))

    else if (expression.contains(" * "))
      {
        splitArray = expression.split(" \\* ");
        if (splitArray[0].contains("r"))
          {
            result = computeR(splitArray, '*', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operate(frac2, splitArray, '*');
          } // else
      } // else if (expression.contains(" * "))

    else if (expression.contains(" / "))
      {
        splitArray = expression.split(" / ");
        if (splitArray[0].contains("r"))
          {
            result = computeR(splitArray, '/', frac2);
          } // if (splitArray[0].contains("r"))
        else
          {
            result = operate(frac2, splitArray, '/');
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
