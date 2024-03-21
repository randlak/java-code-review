
import javax.naming.NamingException;

import static org.junit.jupiter.api.Assertions.*;

class UglyMessageHandlerTest {

    @org.junit.jupiter.api.Test
    void test() {
        UglyMessageHandler handler = new UglyMessageHandler();
        AppContext context = new AppContext();
        UglyMessage message = new UglyMessage();

        String subscription = "sub1";
        context.setName("context1");
        message.status = "status_test";
        message.type = "type1";

        String status = handler.process(context, message, subscription);
        assertNotNull(status);
        assertNotEquals("", status);
        assertEquals("status_test", status);
    }

    @org.junit.jupiter.api.Test
    void testEmptyContext() {
        UglyMessageHandler handler = new UglyMessageHandler();
        AppContext context = new AppContext();
        UglyMessage message = new UglyMessage();

        String subscription = "sub1";
        context.setName("");
        message.status = "status_test";
        message.type = "type1";

        String status = handler.process(context, message, subscription);
        assertNotNull(status);
        assertEquals("status0", status);
    }

}