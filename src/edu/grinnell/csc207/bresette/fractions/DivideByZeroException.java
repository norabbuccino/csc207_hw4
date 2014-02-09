package edu.grinnell.csc207.bresette.fractions;

public class DivideByZeroException extends Exception
{
  public DivideByZeroException()
  {
    super();
  } // DivideByZeroException()
  public DivideByZeroException(String reason) 
  {
    super(reason);
  } // DivideByZeroException(String)
} // class DivideByZeroException 
