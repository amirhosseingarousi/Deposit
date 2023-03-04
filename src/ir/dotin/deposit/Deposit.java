package ir.dotin.deposit;

import java.math.BigDecimal;

public abstract class Deposit {

    private String customerNumber;
    private String depositType;
    private BigDecimal depositBalance;
    private int durationInDays;

    public abstract double calcPayedInterest();

    public Deposit(String customerNumber, String depositType, BigDecimal depositBalance, int durationInDays) {
        this.customerNumber = customerNumber;
        this.depositType = depositType;
        this.depositBalance = depositBalance;
        this.durationInDays = durationInDays;
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
