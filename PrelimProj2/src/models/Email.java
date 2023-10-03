package models;

public class Email {
    private String sender;
    private String receiver;
    private String subject;
    private String body;

    public Email() {
        // Default constructor
        sender = null;
        receiver = null;
        subject = null;
        body = null;
    }

    public Email(String sender, String receiver, String subject, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getSender(){
        return sender;
    }
    public String getReceiver(){
        return receiver;
    }

    @Override
    public String toString() {
        return sender+","+receiver+","+subject+","+body;
    }
}

