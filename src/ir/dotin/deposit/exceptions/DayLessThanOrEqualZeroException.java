package ir.dotin.deposit.exceptions;

public class DayLessThanOrEqualZeroException extends IllegalArgumentException {

    public DayLessThanOrEqualZeroException(String message) {
        super(message);
    }
}
