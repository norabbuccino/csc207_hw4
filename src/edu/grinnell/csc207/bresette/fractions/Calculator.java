package edu.grinnell.csc207.bresette.fractions;

import java.io.PrintWriter;

public class Calculator
{

  public static boolean isFraction(String frac)
  {
    return frac.contains("/");
  }

  public static String store(String expression)
    throws Exception
  {
    String[] splitArray = new String[2];
    splitArray = expression.split(" = ");
    return evaluate(splitArray[1]);
  }

  public static String operateFraction(Fraction frac2, String[] array, char operator) throws Exception
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
        int intResult=0;
        if (operator == '+')
          intResult =
            Integer.parseInt(array[0])
                + Integer.parseInt(array[1]);
        else if (operator == '-')
          intResult =
            Integer.parseInt(array[0])
                - Integer.parseInt(array[1]);
        else if (operator == '*')
          intResult =
            Integer.parseInt(array[0])
                * Integer.parseInt(array[1]);
        else if (operator == '/')
          intResult =
            Integer.parseInt(array[0])
                / Integer.parseInt(array[1]);
        
        return Integer.toString(intResult);
      } // else
  }
  
  public static String findR(String[] array, char operator, Fraction frac) throws Exception
  {
    int intResult=0;
        if (isFraction(array[1]))
          {
            frac = new Fraction(array[1]);  //what if r is a fraction and you add something to it?
            if (operator == '+')
              frac =
                  frac.add(Integer.parseInt(r[array[0].indexOf("r") + 1]));
            else if (operator == '-')
              frac =
                  frac.minus(Integer.parseInt(r[array[0].indexOf("r") + 1]));
            else if (operator == '*')
              frac =
                  frac.multiply(Integer.parseInt(r[array[0].indexOf("r") + 1]));
            else if (operator == '/')
              frac =
                  frac.divideBy(Integer.parseInt(r[array[0].indexOf("r") + 1]));
            return frac.toString();
            
          } // (isFraction(splitArray[1]))
        else
          {
            if (operator == '+')
             intResult =
                Integer.parseInt(array[1])
                    + Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]);
            else if (operator == '-')
              intResult =
              Integer.parseInt(array[1])
                  - Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]);
            else if (operator == '*')
              intResult =
              Integer.parseInt(array[1])
                  * Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]);
            else if (operator == '/')
              intResult =
              Integer.parseInt(array[1])
                  / Integer.parseInt(r[Character.getNumericValue(array[0].charAt(1))]);
            return Integer.toString(intResult);
          } // else
  }
  
  static String[] r = new String[8];

  /**
   * preconditions: expression must have a space between the values and the
   * operators
   * 
   * @param expression
   * @return
   * @throws Exception
   */

  public static String evaluate(String expression)
    throws Exception
  {

    String[] splitArray = new String[2];
    Fraction frac2 = new Fraction(1,1);

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
        if (splitArray[0].contains("r"))
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
    else
      {
        result = "Invalid input";
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
      }
    return result;
  }

  public static void main(String[] args)
    throws Exception
  {

    System.out.println(evaluate("r1 = 1 + 2"));
    System.out.println(r[1]);
    System.out.println(evaluate("r2 = r1 * 3"));
    System.out.println(r[2]);
    /*
     * String input = ""; PrintWriter pen = new PrintWriter (System.out, true);
     * java.io.BufferedReader eyes; java.io.InputStreamReader istream; istream =
     * new java.io.InputStreamReader (System.in); eyes = new
     * java.io.BufferedReader (istream); // ask user for input pen.println(
     * "Please input an expression, or a list of expressions separated by a comma."
     * ); // store input as string input = eyes.readLine();
     * 
     * 
     * if(input.contains(", ")) { int numberOfCommas = 0; for(int i = 0;
     * i<input.length(); i++) { if(input.charAt(i) == ',') { numberOfCommas ++;
     * } } String[] inputArray = new String[numberOfCommas + 1]; String[]
     * resultsArray = new String[numberOfCommas + 1]; inputArray =
     * input.split(", "); resultsArray = Calculator.evaluate(inputArray);
     * for(int i = 0; i<resultsArray.length-1; i++) { pen.print(resultsArray[i]
     * + ", "); } pen.print(resultsArray[resultsArray.length-1]); pen.flush(); }
     * else { pen.println(Calculator.evaluate(input)); }
     * 
     * pen.close();
     */
  }

}
