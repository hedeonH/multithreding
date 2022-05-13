package task5.service;

import task5.dao.Currency;
import task5.dao.User;
import task5.utility.ValidationUtils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Broker implements Runnable {

    private static Logger logger = Logger.getLogger(Broker.class.getName());
    private final Random random = new Random();
    private final List<User> userList;
    private final UserService userService;
    private final ExchangeService exchangeService;

    public Broker(List<User> userList, ExchangeService exchangeService, UserService userService) {
        this.userList = userList;
        this.exchangeService = exchangeService;
        this.userService = userService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            var currencyFrom = Currency.values()[random.nextInt(Currency.values().length)];
            var currencyTo = Currency.values()[random.nextInt(Currency.values().length)];
            var amount = BigDecimal.valueOf(random.nextFloat(10));
            var user = userList.get(random.nextInt(userList.size()));
            exchangeUserCurrency(currencyFrom, currencyTo, amount, user);
        }
    }

    private void exchangeUserCurrency(Currency currencyFrom, Currency currencyTo, BigDecimal amount, User user) {
        var exchangedAmount = exchangeService.exchangeCurrency(currencyFrom, currencyTo, amount);
        var resultStart = user.getCurrencyAmount(currencyFrom).subtract(amount);
        var resultEnd = user.getCurrencyAmount(currencyTo).add(exchangedAmount);
        ValidationUtils.validateAccount(user, amount, currencyFrom);
        user.setCurrencyAmount(currencyFrom, resultStart);
        user.setCurrencyAmount(currencyTo, resultEnd);
        logger.info(MessageFormat.format(" Exchange amount {0} From currency{1} To currency {2} For user {3} {4}",
                        amount,
                        currencyFrom,
                        currencyTo,
                        user.getName(),
                        user.getSurname()));
        userService.writeUser(user);
    }
}
