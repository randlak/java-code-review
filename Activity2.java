public class Activity2 {
    private String shortDescription;
    private String objectId;
    private String subject;
    private String description;
    private ActivityType activityType;

    public String getShortDescription() {
        if (shortDescription != null) {
            return shortDescription;
        }

        if (subject == null || subject.trim().isEmpty()) {
            shortDescription = description;

        } else if (subject.contains(objectId)) {
            shortDescription = subject;

        } else if (ActivityType.Type1.equals(activityType) || ActivityType.Type2.equals(activityType)) {
            shortDescription = String.format("%s - %s", subject, objectId);
        }

        if (shortDescription != null && shortDescription.length() >= 25) {
            shortDescription = shortDescription.substring(0, 25) + "..";
        }
        return shortDescription;
    }
}
