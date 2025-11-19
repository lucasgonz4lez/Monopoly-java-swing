package game.events;

public class GameEventListener {
    private String type;
    private String message;

    public GameEventListener(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
