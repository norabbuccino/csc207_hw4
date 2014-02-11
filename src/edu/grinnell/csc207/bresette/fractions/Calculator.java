package edu.grinnell.csc207.bresette.fractions;

import java.io.PrintWriter;

public class Calculator
{

  public static boolean isFraction(String frac)
  {
    return frac.contains("/");
  }

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
    Fraction[] r = new Fraction[8];
    
    String[] splitArray = new String[2];

    int intResult;
    String result = "";
    if (expression.contains(" + "))
      {
        splitArray = expression.split(" \\+ ");
        if (splitArray[0].contains("/"))
          {
            Fraction frac1 = new Fraction(splitArray[0]);

            if (splitArray[1].contains("/"))
              {
                Fraction frac2 = new Fraction(splitArray[1]);
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
            Fraction frac2 = new Fraction(splitArray[1]);
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
            Fraction frac1 = new Fraction(splitArray[0]);

            if (splitArray[1].contains("/"))
              {
                Fraction frac2 = new Fraction(splitArray[1]);
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
            Fraction frac2 = new Fraction(splitArray[1]);
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
            Fraction frac1 = new Fraction(splitArray[0]);

            if (splitArray[1].contains("/"))
              {
                Fraction frac2 = new Fraction(splitArray[1]);
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
            Fraction frac2 = new Fraction(splitArray[1]);
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
            Fraction frac1 = new Fraction(splitArray[0]);
            if (isFraction(splitArray[1]))
              {
                Fraction frac2 = new Fraction(splitArray[1]);
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
            Fraction frac2 = new Fraction(splitArray[1]);
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

  public static String[] evaluate(String[] expression) throws Exception
  {
    String[] result = new String[expression.length];
    for(int i = 0; i<expression.length; i++)
      {
        result[i] = evaluate(expression[i]);
      }
    return result;
  }

  public static void main(String[] args)
    throws Exception
  {
    String input = "";
    PrintWriter pen = new PrintWriter (System.out, true);
    java.io.BufferedReader eyes;
    java.io.InputStreamReader istream;
    istream = new java.io.InputStreamReader (System.in);
    eyes = new java.io.BufferedReader (istream);
    // ask user for input
    pen.println("Please input an expression, or a list of expressions separated by a comma.");
    // store input as string
    input = eyes.readLine();
    
    
    if(input.contains(", "))
      {
        int numberOfCommas = 0;
        for(int i = 0; i<input.length(); i++)
          {
            if(input.charAt(i) == ',')
              {
                numberOfCommas ++;
              }
          }
        String[] inputArray = new String[numberOfCommas + 1];
        String[] resultsArray = new String[numberOfCommas + 1];
        inputArray = input.split(", ");
        resultsArray = Calculator.evaluate(inputArray);
        for(int i = 0; i<resultsArray.length-1; i++)
          {
            pen.print(resultsArray[i] + ", ");
          }
        pen.print(resultsArray[resultsArray.length-1]);
        pen.flush();
      }
    else
      {
        pen.println(Calculator.evaluate(input));
      }
    
    pen.close();
  }
}
