package task5.utility;

import task5.dao.Currency;
import task5.dao.User;
import task5.exeption.AccountException;
import task5.exeption.UserValidationException;

import java.math.BigDecimal;

public class ValidationUtils {

    private ValidationUtils() {
    }

    public static void validateUser(boolean fileExists, boolean userShouldExists, String message) {
        if (!fileExists && userShouldExists) {
            throw new UserValidationException(message);
        }
    }

    public static void validateAccount(User user, BigDecimal amount, Currency currency) {
        if (user.getCurrencyAmount(currency).compareTo(amount) < 0) {
            throw new AccountException("Your balance is not enough for exchanging %s with amount %s%s".formatted(currency, amount, user.toString()));
        }
    }
}
