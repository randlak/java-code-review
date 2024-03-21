public class AppContext {
    private String name;

    public String getName() {
        if (name.equals("")) {
            throw new IllegalStateException("Name is not set");
        }
        return name;
    }
    public void setName(String type) {
        this.name = type;
    }
}