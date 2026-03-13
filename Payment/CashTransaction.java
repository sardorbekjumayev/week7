package Payment;

import Enums.PaymentStatus;

public class CashTransaction extends Payment {
    private double cashTendered;

    public CashTransaction(int paymentID, double amount, PaymentStatus status, double cashTendered) {
        super(paymentID, amount, status);
        this.cashTendered = cashTendered;
    }

    @Override
    public boolean makeTransaction() {
        if (cashTendered >= getAmount()) {
            setStatus(PaymentStatus.COMPLETED);
            return true;
        }
        setStatus(PaymentStatus.FAILED);
        return false;
    }
}
