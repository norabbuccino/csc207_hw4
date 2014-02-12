package edu.grinnell.csc207.bresette.fractions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CalculatorInterface
{

  public static void main(String[] args)
      throws Exception
    {
      String input = "";
      PrintWriter pen = new PrintWriter(System.out, true);
      BufferedReader eyes;
      InputStreamReader istream;
      istream = new InputStreamReader(System.in);
      eyes = new BufferedReader(istream);

      while (!input.equalsIgnoreCase("q"))
        {
          pen.println("Please input an expression with spaces betweeen values and operators, \na list of expressions separated by a comma, or q to quit.");
          input = eyes.readLine();
          if (input.contains(", "))
            {
              int numberOfCommas = 0;
              for (int i = 0; i < input.length(); i++)
                {
                  if (input.charAt(i) == ',')
                    {
                      numberOfCommas++;
                    } // if (input.charAt(i) == ',') locating commas
                } // for (int i = 0; i < input.length(); i++) counting the number of commas
              String[] inputArray = new String[numberOfCommas + 1];
              String[] resultsArray = new String[numberOfCommas + 1];
              inputArray = input.split(", ");
              resultsArray = Calculator.evaluate(inputArray);
              for (int i = 0; i < resultsArray.length - 1; i++)
                {
                  pen.print(resultsArray[i] + ", ");
                } // for (int i = 0; i < resultsArray.length - 1; i++) printing out the values
              pen.print(resultsArray[resultsArray.length - 1]);
              pen.flush();
            } // if (input.contains(", ")) input is a list of expressions
          else
            {
              pen.println(Calculator.evaluate(input));
            } // else input is not a list of expressions
        } // while (!input.equalsIgnoreCase("q")) infinite loop until user chooses to quit
      pen.close();

    } // main()

} // class CalculatorInterface()
