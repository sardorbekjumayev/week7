package Payment;

import Enums.PaymentStatus;

public class CheckTransaction extends Payment {
    private String bankName;
    private String checkNumber;

    public CheckTransaction(int paymentID, double amount, PaymentStatus status, String bankName, String checkNumber) {
        super(paymentID, amount, status);
        this.bankName = bankName;
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean makeTransaction() {
        if (bankName != null && !bankName.isEmpty() &&
                checkNumber != null && !checkNumber.isEmpty() &&
                getAmount() > 0) {
            setStatus(PaymentStatus.COMPLETED);
            return true;
        }
        setStatus(PaymentStatus.FAILED);
        return false;
    }
}
