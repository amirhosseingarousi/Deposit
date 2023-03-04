package ir.dotin.deposit;

import java.math.BigDecimal;

public class ShortTerm extends Deposit {
    private final double INTEREST_RATE = 0.1;

    public ShortTerm(String customerNumber, String depositType, BigDecimal depositBalance, int durationInDays) {
        super(customerNumber, depositType, depositBalance, durationInDays);
    }

    @Override
    public double calcPayedInterest() {
        return (INTEREST_RATE * getDepositBalance().doubleValue() * getDurationInDays()) / 36500;
    }
}
