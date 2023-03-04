package ir.dotin.deposit;

import java.math.BigDecimal;

public class DepositFactory {

    public static Deposit createDeposit(String number, String type, BigDecimal balance, int days) {
        if (type.equals("Qarz")) {
            return new Qarz(number, type, balance, days);
        } else if (type.equals("ShortTerm")) {
            return new ShortTerm(number, type, balance, days);
        } else if (type.equals("LongTerm")) {
            return new LongTerm(number, type, balance, days);
        }

        return null;
    }
}
