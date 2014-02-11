package edu.grinnell.csc207.bresette.fractions;

public class Calculator
{

  public static String evaluate(String expression)
    throws Exception
  {
    String[] splitArray = new String[2];
    String[] dividingArray = new String[4];
    int intResult;
    String result = "";
    if (expression.contains("+"))
      {
        splitArray = expression.split("+");
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
            result =  frac1.toString();
          }
        else if (splitArray[1].contains("/"))
          {
            Fraction frac2 = new Fraction(splitArray[1]);
            frac2 = frac2.add(Integer.parseInt(splitArray[0]));
            result =  frac2.toString();
          }
        else
          {
            intResult =
                Integer.parseInt(splitArray[0])
                    + Integer.parseInt(splitArray[1]);
            result =  Integer.toString(intResult);
          }
      }

    else if (expression.contains("-"))
      {
        splitArray = expression.split("-");
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
            result =  frac1.toString();
          }
        else if (splitArray[1].contains("/"))
          {
            Fraction frac2 = new Fraction(splitArray[1]);
            frac2 = frac2.subtractFrom(Integer.parseInt(splitArray[0]));
            result =  frac2.toString();
          }
        else
          {
            intResult =
                Integer.parseInt(splitArray[0])
                    - Integer.parseInt(splitArray[1]);
            result = Integer.toString(intResult);
          }
      }
    else if (expression.contains("*"))
      {
        splitArray = expression.split("*");
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
    else if (expression.contains("/"))
      {
        int numberOfSlashes = 0;
        for (int i = 0; i < expression.length(); i++)
          {
            if (expression.charAt(i) == '/')
              {
                numberOfSlashes++;
              }
          }
        if (numberOfSlashes == 1)
          {
            splitArray = expression.split("/");
            intResult =
                Integer.parseInt(splitArray[0])
                    / Integer.parseInt(splitArray[1]);
            result = Integer.toString(intResult);
          }
        // Assuming that the fraction is the second value
        else if (numberOfSlashes == 2)
          {
            splitArray = expression.split("/", 1);
            Fraction frac2 = new Fraction(splitArray[1]);
            frac2 = frac2.divideFrom(Integer.parseInt(splitArray[0]));
            result = frac2.toString();
          }
        else if (numberOfSlashes == 3)
          {
            dividingArray = expression.split("/");
            Fraction frac1 = new Fraction(dividingArray[0], dividingArray[1]);
            Fraction frac2 = new Fraction(dividingArray[2], dividingArray[3]);

            frac1 = frac1.divideBy(frac2);
            result = frac1.toString();
          }
      }
    else
      {
        result = "Invalid input";
      }
    return result;
  }
/*
  public static String[] evaluate(String[] expression)
  {

  }
  */
}
