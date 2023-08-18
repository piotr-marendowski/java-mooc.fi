import java.util.ArrayList;

class Message {
    private String sender;
    private String content;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return this.sender + ": " + this.content;
    }
}

public class MessagingService {
    private ArrayList<Message> messages;

    public MessagingService() {
        this.messages = new ArrayList<>();
    }

    public void add(Message message) {
        if (message.getContent().length() <= 280)
            this.messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public static void main(String[] args) {
        MessagingService ms = new MessagingService(); 
        
        Message ms1 = new Message("Bill", "Hello, world!");
        Message ms2 = new Message("Chris", "I love java!");
        /* 281 chars */
        Message ms3 = new Message("TEST", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In placerat lectus sed faucibus aliquam. Ut malesuada dolor erat, at tempor turpis lobortis nec. Pellentesque ipsum mi, pellentesque eget elit et, egestas vestibulum ligula. Vestibulum vitae pharetra eros, sit amet placerat.");
        
        ms.add(ms1);
        ms.add(ms2);
        ms.add(ms3);

        System.out.println(ms.getMessages());
    }
}
