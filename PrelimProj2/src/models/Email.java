package models;

public class Email {

    // Attributes of the Email class
    private String sender;
    private String receiver;
    private String subject;
    private String body;

    // Default constructor
    public Email() {
        sender = null;
        receiver = null;
        subject = null;
        body = null;
    }

    // Constructor with specified fields
    public Email(String sender, String receiver, String subject, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
    }

    // Setter method for the email subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Getter method for the email subject
    public String getSubject() {
        return subject;
    }

    // Setter method for the email body.
    public void setBody(String body) {
        this.body = body;
    }

    // Getter method for the email body
    public String getBody() {
        return body;
    }

    // Getter method for the email sender email address.
    public String getSender(){
        return sender;
    }

    // Getter method for the email receiver email address
    public String getReceiver(){
        return receiver;
    }

    // Returns a string representation of the email
    @Override
    public String toString() {
        return "Sender: " + sender + "\n" +
                "Receiver: " + receiver + "\n" +
                "Subject: " + subject + "\n" +
                "Body: " + body;
    } // End of toString method
} // End of class

