package ir.dotin.deposit.exceptions;

public class BalanceNegativeException extends IllegalArgumentException {

    public BalanceNegativeException(String message) {
        super(message);
    }
}
