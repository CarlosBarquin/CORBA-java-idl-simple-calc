package CalcApp;

/**
* CalcApp/ComplexHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calc.idl
* mi�rcoles 1 de marzo de 2023 19H02' CET
*/

public final class ComplexHolder implements org.omg.CORBA.portable.Streamable
{
  public CalcApp.Complex value = null;

  public ComplexHolder ()
  {
  }

  public ComplexHolder (CalcApp.Complex initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalcApp.ComplexHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalcApp.ComplexHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalcApp.ComplexHelper.type ();
  }

}
