import javax.naming.Context;
import javax.naming.NamingException;

public class UglyMessageHandler {

    //Process each subscription type and return message status
    public String process(Context ctx, Message msg, String s) throws NamingException {
        String st = ""; //inspection says no initialization needed, but might make code easier to read

        if (s.equals("sub1")) {
            if (ctx.getNameInNamespace().equals("context1") && msg.getType().equals("type1")) {
                st = msg.getStatus();
            } else {
                st = "status0";
            }

        } else if (s.equals("sub2")) {
            if (ctx.getNameInNamespace().equals("context2") && msg.getType().equals("type2")) {
                st = msg.getStatus();
            } else {
                st = "status0";
            }

        } else if (s.equals("sub3")) {
            if (ctx.getNameInNamespace().equals("context3") && msg.getType().equals("type3")) {
                st = msg.getStatus();
            } else {
                st = "status0";
            }

        } else {
            System.out.println("unimplemented subscription type");
            st = "unimplemented subscription type";
        }

        return st;
    }
}
