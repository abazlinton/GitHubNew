public class Commit {

    private String message;
    private String uniqueId;

    public Commit(String message, String uniqueId) {
        this.message = message;
        this.uniqueId = uniqueId;
    }

    public String getMessage() {
        return message;
    }

    public String getUniqueId() {
        return uniqueId;
    }
}
