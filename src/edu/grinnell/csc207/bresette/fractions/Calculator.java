package edu.grinnell.csc207.bresette.fractions;

import java.io.PrintWriter;

public class Calculator
{

  public static boolean isFraction(String frac)
  {
    return frac.contains("/");
  }

  public static String store( String expression)
    throws Exception
  {
    String[] splitArray = new String[2];
    splitArray = expression.split(" = ");
    return evaluate(splitArray[1]);
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
    Fraction frac1;
    Fraction frac2;
    
    int intResult;
    String result = "";
    //r[1]="5";
    if (expression.contains(" = "))
      {
        r[Character.getNumericValue(expression.charAt(1))] = store(expression);
        result = r[Character.getNumericValue(expression.charAt(1))];
      }
    else if (expression.contains(" + "))
      {
        splitArray = expression.split(" \\+ ");
        if (splitArray[0].contains("r"))
          {
            if (isFraction(splitArray[1]))
              {
                frac2 = new Fraction(splitArray[1]);
                frac2 = frac2.add(Integer.parseInt(r[splitArray[0].indexOf("r") + 1]));
                result = frac2.toString();
              }
            else
              {
                //string that is stored in r[]
                //then convert to an int
                //splitArray[0]
                intResult = Integer.parseInt(splitArray[1]) + Integer.parseInt(r[Character.getNumericValue(splitArray[0].charAt(1))]);
                result = Integer.toString(intResult);
              }
          }

        else if (isFraction(splitArray[0]))
          {
            frac1 = new Fraction(splitArray[0]);

            if (isFraction(splitArray[1]))
              {
                frac2 = new Fraction(splitArray[1]);
                frac1 = frac1.add(frac2);
              }
            else
              {
                frac1 = frac1.add(Integer.parseInt(splitArray[1]));
              }
            result = frac1.toString();
          }
        else if (splitArray[1].contains("/"))
          {
            frac2 = new Fraction(splitArray[1]);
            frac2 = frac2.add(Integer.parseInt(splitArray[0]));
            result = frac2.toString();
          }
        else
          {
            intResult =
                Integer.parseInt(splitArray[0])
                    + Integer.parseInt(splitArray[1]);
            result = Integer.toString(intResult);
          }
      }

    else if (expression.contains(" - "))
      {
        splitArray = expression.split(" - ");
        if (splitArray[0].contains("/"))
          {
            frac1 = new Fraction(splitArray[0]);

            if (splitArray[1].contains("/"))
              {
                frac2 = new Fraction(splitArray[1]);
                frac1 = frac1.minus(frac2);
              }
            else
              {
                frac1 = frac1.minus(Integer.parseInt(splitArray[1]));
              }
            result = frac1.toString();
          }
        else if (splitArray[1].contains("/"))
          {
            frac2 = new Fraction(splitArray[1]);
            frac2 = frac2.subtractFrom(Integer.parseInt(splitArray[0]));
            result = frac2.toString();
          }
        else
          {
            intResult =
                Integer.parseInt(splitArray[0])
                    - Integer.parseInt(splitArray[1]);
            result = Integer.toString(intResult);
          }
      }
    else if (expression.contains(" * "))
      {
        splitArray = expression.split(" \\* ");
        if (splitArray[0].contains("/"))
          {
            frac1 = new Fraction(splitArray[0]);

            if (splitArray[1].contains("/"))
              {
                frac2 = new Fraction(splitArray[1]);
                frac1 = frac1.multiply(frac2);
              }
            else
              {
                frac1 = frac1.multiply(Integer.parseInt(splitArray[1]));
              }
            result = frac1.toString();
          }
        else if (splitArray[1].contains("/"))
          {
            frac2 = new Fraction(splitArray[1]);
            frac2 = frac2.multiply(Integer.parseInt(splitArray[0]));
            result = frac2.toString();
          }
        else
          {
            intResult =
                Integer.parseInt(splitArray[0])
                    * Integer.parseInt(splitArray[1]);
            result = Integer.toString(intResult);
          }
      }
    else if (expression.contains(" / "))
      {
        splitArray = expression.split(" / ");
        if (isFraction(splitArray[0]))
          {
            frac1 = new Fraction(splitArray[0]);
            if (isFraction(splitArray[1]))
              {
                frac2 = new Fraction(splitArray[1]);
                frac1 = frac1.divideBy(frac2);
              }
            else
              {
                frac1 = frac1.divideBy(Integer.parseInt(splitArray[1]));
              }
            result = frac1.toString();
          }
        else if (isFraction(splitArray[1]))
          {
            frac2 = new Fraction(splitArray[1]);
            frac2 = frac2.divideFrom(Integer.parseInt(splitArray[0]));
            result = frac2.toString();
          }
        else
          {
            intResult =
                Integer.parseInt(splitArray[0])
                    / Integer.parseInt(splitArray[1]);
            result = Integer.toString(intResult);
          }

      }

    else if (expression.contains("-"))
      {
        if (expression.contains("/"))
          {
            Fraction frac = new Fraction(expression.replaceFirst("-", ""));
            frac.negate();
            result = frac.toString();
          }
        else
          {
            intResult = 0 - Integer.parseInt(expression.replaceFirst("-", ""));
            result = Integer.toString(intResult);
          }
      }
    else
      {
        result = "Invalid input";
      }
    return result;
  }

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
    System.out.println(evaluate("r1 + 2"));
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
