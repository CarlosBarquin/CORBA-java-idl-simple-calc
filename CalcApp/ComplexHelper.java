package CalcApp;


/**
* CalcApp/ComplexHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calc.idl
* mi�rcoles 1 de marzo de 2023 19H02' CET
*/

abstract public class ComplexHelper
{
  private static String  _id = "IDL:CalcApp/Complex:1.0";

  public static void insert (org.omg.CORBA.Any a, CalcApp.Complex that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CalcApp.Complex extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[0] = new org.omg.CORBA.StructMember (
            "real",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[1] = new org.omg.CORBA.StructMember (
            "imaginary",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (CalcApp.ComplexHelper.id (), "Complex", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CalcApp.Complex read (org.omg.CORBA.portable.InputStream istream)
  {
    CalcApp.Complex value = new CalcApp.Complex ();
    value.real = istream.read_float ();
    value.imaginary = istream.read_float ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CalcApp.Complex value)
  {
    ostream.write_float (value.real);
    ostream.write_float (value.imaginary);
  }

}
