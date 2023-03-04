package ir.dotin.deposit;

import ir.dotin.deposit.exceptions.BalanceNegativeException;
import ir.dotin.deposit.exceptions.DayLessThanOrEqualZeroException;
import ir.dotin.deposit.exceptions.InvalidTypeException;

import java.math.BigDecimal;

public abstract class Deposit implements Comparable<Deposit> {

    private String customerNumber;
    private String depositType;
    private BigDecimal depositBalance;
    private int durationInDays;
    private double payedInterest;

    public abstract double calcPayedInterest();

    public Deposit(String customerNumber, String depositType, BigDecimal depositBalance, int durationInDays) {
        this.customerNumber = customerNumber;
        try {
            validateDepositType(depositType);
            validateBalance(depositBalance);
            validateDays(durationInDays);
        } catch (BalanceNegativeException | DayLessThanOrEqualZeroException | InvalidTypeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateDepositType(String type) {
        if (type == null) {
            throw new InvalidTypeException("Invalid deposit type");
        }
        this.depositType = type;
    }

    private void validateDays(int days) {
        if (days <= 0) {
            throw new DayLessThanOrEqualZeroException("Day cannot be equal or less than zero");
        }
        this.durationInDays = days;
    }

    private void validateBalance(BigDecimal balance) {
        if (balance.doubleValue() < 0) {
            throw new BalanceNegativeException("Balance cannot be negative");
        }
        this.depositBalance = balance;
    }

    @Override
    public int compareTo(Deposit o) {
        if (payedInterest == o.payedInterest) {
            return 0;
        } else if (payedInterest < o.payedInterest) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getDepositType() {
        return depositType;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setPayedInterest(double payedInterest) {
        this.payedInterest = payedInterest;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "customerNumber='" + customerNumber + '\'' +
                ", depositType='" + depositType + '\'' +
                ", depositBalance=" + depositBalance +
                ", durationInDays=" + durationInDays +
                '}';
    }
}
