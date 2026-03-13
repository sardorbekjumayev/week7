package Notification;

public class EmailNotification extends Notification {

    private String email;

    public EmailNotification() {
    }

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public boolean send() {
        System.out.println("Sending email notification...");
        return true;
    }
}