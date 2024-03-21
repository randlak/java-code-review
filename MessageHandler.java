import static java.lang.System.Logger;

public class MessageHandler {

    // Context names
    public static final String CONTEXT_NAME_INTERNAL = "context1";
    public static final String CONTEXT_NAME_QUEST = "context2";
    public static final String CONTEXT_NAME_PUBLIC = "context3";

    // Message types
    public static final String MESSAGE_TYPE_EMAIL = "type1";
    public static final String MESSAGE_TYPE_SMS = "type2";
    public static final String MESSAGE_TYPE_MAIL = "type3";

    // Private fields
    private static final String STATUS_UNKNOWN = "status0";

    private static final String VALIDATION_ERROR = "validation error when getting message status: context or message is null";

    private static final String UNIMPLEMENTED_SUBSCRIPTION_ERROR = "subscription not implemented: ";
    private static final String GENERAL_ERROR = "system error when getting message status: ";
    private static final Logger logger = System.getLogger("MessageHandler");

    private AppContext context;
    private Message message;

    public String getMessageStatusForSubscription(AppContext context, Message message, String subscription) {
        if (context == null || message == null) {
            logger.log(Logger.Level.ERROR, VALIDATION_ERROR);
            return "";
        }

        this.context = context;
        this.message = message;

        return switch (subscription) {
            case "sub1" -> getStatusForContextAndMessageType(CONTEXT_NAME_INTERNAL, MESSAGE_TYPE_EMAIL);
            case "sub2" -> getStatusForContextAndMessageType(CONTEXT_NAME_QUEST, MESSAGE_TYPE_SMS);
            case "sub3" -> getStatusForContextAndMessageType(CONTEXT_NAME_PUBLIC, MESSAGE_TYPE_MAIL);
            default -> {
                logger.log(Logger.Level.WARNING, UNIMPLEMENTED_SUBSCRIPTION_ERROR + subscription);
                yield "";
            }
        };
    }

    private String getStatusForContextAndMessageType(String contextName, String messageType) {
        try {
            if (this.context.getName().equals(contextName) &&
                    this.message.getType().equals(messageType)) {
                return this.message.getStatus();
            }
        } catch (IllegalStateException e) {
            logger.log(Logger.Level.ERROR, GENERAL_ERROR, e);
        }

        return STATUS_UNKNOWN;
    }

}
