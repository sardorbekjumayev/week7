package Payment;

import Enums.PaymentStatus;

public class Payment {

    private int paymentID;
    private double amount;
    private PaymentStatus status;

    public Payment(int paymentID, double amount, PaymentStatus status) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.status = status;
    }

    public boolean makeTransaction() {
        if (amount > 0) {
            status = PaymentStatus.COMPLETED;
            return true;
        }
        status = PaymentStatus.FILLED;
        return false;
    }

    public boolean refundPayment() {
        if (status == PaymentStatus.COMPLETED) {
            status = PaymentStatus.REFUNDED;
            return true;
        }
        return false;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}