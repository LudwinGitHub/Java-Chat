package pl.supra.javaChat;

public class Message {

    private String userName;
    private String userMessage;

    public Message(String userName, String userMessage) {
        this.userName = userName;
        this.userMessage = userMessage;
    }

    @Override
    public String toString() {
        return userName + "" + userMessage;
    }
}
