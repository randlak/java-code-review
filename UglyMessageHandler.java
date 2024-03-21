import javax.naming.NamingException;

public class UglyMessageHandler {

    //Process each subscription type and return message status
    public String process(AppContext ctx, UglyMessage msg, String s) {
        String st = ""; //inspection says no initialization needed, but might make code easier to read

        if (s.equals("sub1")) {
            if (ctx.getName().equals("context1") && msg.type.equals("type1")) {
                st = msg.status;
                st = "status " + st;
                msg.text = "Message: " + st;
            } else {
                st = "status0";
            }

        } else if (s.equals("sub2")) {
            if (ctx.getName().equals("context2") && msg.type.equals("type2")) {
                st = msg.status;
                st = "status " + st;
                msg.text = "Message: " + st;
            } else {
                st = "status0";
            }

        } else if (s.equals("sub3")) {
            if (ctx.getName().equals("context3") && msg.type.equals("type3")) {
                st = msg.status;
                st = "status " + st;
                msg.text = "Message: " + st;
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
