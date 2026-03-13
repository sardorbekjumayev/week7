package Payment;

import Enums.PaymentStatus;

public class CreditCardTransaction extends Payment {

    private String nameOnCard;

    public CreditCardTransaction(int paymentID, double amount, PaymentStatus status, String nameOnCard) {
        super(paymentID, amount, status);
        this.nameOnCard = nameOnCard;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    @Override
    public boolean makeTransaction() {
        if (nameOnCard !=null && !nameOnCard.isEmpty() && getAmount()>0){

            setStatus(PaymentStatus.COMPLETED);
            return true;
        }
        setStatus(PaymentStatus.FILLED);
        return false;
    }
}