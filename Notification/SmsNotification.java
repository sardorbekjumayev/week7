package Notification;

public class SmsNotification extends Notification {

    private String email;

    @Override
    public boolean send() {
        System.out.println("Sending SMS notification...");
        return true;
    }
}