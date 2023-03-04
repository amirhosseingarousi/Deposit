package ir.dotin.deposit;

import ir.dotin.deposit.exceptions.InvalidTypeException;

import java.math.BigDecimal;

public class DepositFactory {

    public static Deposit createDeposit(String number, String type, BigDecimal balance, int days) {
        if ("Qarz".equals(type)) {
            return new Qarz(number, type, balance, days);
        } else if (type.equals("ShortTerm")) {
            return new ShortTerm(number, type, balance, days);
        } else if (type.equals("LongTerm")) {
            return new LongTerm(number, type, balance, days);
        }

        return new Qarz(null, null, null, 0);
//        throw new InvalidTypeException("Invalid deposit type");
    }
}
