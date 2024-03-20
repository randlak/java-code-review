public class Activity {
    private String shortDescription;
    private String objectId;
    private String subject;
    private String description;
    private ActivityType activityType;

    public String getShortDescription() {
        if (shortDescription == null) {
            if (subject != null && !subject.trim().isEmpty()) {
                shortDescription = ((activityType.equals(ActivityType.Type1) || activityType.equals(ActivityType.Type2)) && !subject.contains(objectId)) ? (subject + " - " + objectId) : subject;
            } else {
                shortDescription = description;
            }

            if (shortDescription != null && shortDescription.length() >= 25) {
                shortDescription = shortDescription.substring(0, 25) + "..";
            }
        }
        return shortDescription;
    }
}

enum ActivityType {
    Type1,
    Type2;
}
