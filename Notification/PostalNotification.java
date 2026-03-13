package Notification;

import Enums.Address;

public class PostalNotification extends Notification {

    private Address address;

    @Override
    public boolean send() {
        System.out.println("Sending postal notification...");
        return true;
    }
}
