package models;

public class Email {
    private String sender;
    private String receiver;
    private String subject;
    private String body;

    public Email() {
        // Default constructor
    }

    public Email(String sender, String receiver,String subject, String body) {
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

    @Override
    public String toString() {
        return "Sender: " + sender + "\n" +
                "Receiver: " + receiver + "\n" +
                "Subject: " + subject + "\n" +
                "Body: " + body;
    }
}

