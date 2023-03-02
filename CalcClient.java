import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CalcApp.*;
import CalcApp.CalcPackage.DivisionByZero;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import static java.lang.System.out;

public class CalcClient {

    static Calc calcImpl;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {

        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Calc";
            calcImpl = CalcHelper.narrow(ncRef.resolve_str(name));

            while (true) {
                out.println("1. Sum");
                out.println("2. Sub");
                out.println("3. Mul");
                out.println("4. Div");
                out.println("5. Complex Sum");
                out.println("6. Complex Sub");
                out.println("7. exit");
                out.println("--");
                out.println("choice: ");

                try {
                    String opt = br.readLine();
                    if (opt.equals("7")) {
                        break;
                    } else if (opt.equals("1")) {
                        out.println("a+b= " + calcImpl.sum(getFloat("a"), getFloat("b")));
                    } else if (opt.equals("2")) {
                        out.println("a-b= " + calcImpl.sub(getFloat("a"), getFloat("b")));
                    } else if (opt.equals("3")) {
                        out.println("a*b= " + calcImpl.mul(getFloat("a"), getFloat("b")));
                    } else if (opt.equals("4")) {
                        try {
                            out.println("a/b= " + calcImpl.div(getFloat("a"), getFloat("b")));
                        } catch (DivisionByZero de) {
                            out.println("Division by zero!!!");
                        }
                    } else if (opt.equals("5")) {
                        Complex a = new Complex();
                        Complex b = new Complex();
                        a.real = getFloat("a.real");
                        a.imaginary = getFloat("a.imaginary");
                        b.real = getFloat("b.real");
                        b.imaginary = getFloat("b.imaginary");
                        Complex result = calcImpl.complexSum(a, b);
                        out.println("a + b = " + result.real + " + " + result.imaginary + "i");
                    } else if (opt.equals("6")) {
                        Complex a = new Complex();
                        Complex b = new Complex();
                        a.real = getFloat("a.real");
                        a.imaginary = getFloat("a.imaginary");
                        b.real = getFloat("b.real");
                        b.imaginary = getFloat("b.imaginary");
                        Complex result = calcImpl.complexSub(a, b);
                        out.println("a - b = " + result.real + " + " + result.imaginary + "i");
                    }
                } catch (IOException ex) {
                    out.println("IO Exception");
                }
            }

        } catch (Exception e) {
            out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

    static float getFloat(String number) throws Exception {
        out.print(number + ": ");
        return Float.parseFloat(br.readLine());
    }
}







