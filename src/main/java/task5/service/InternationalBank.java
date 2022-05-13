package task5.service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;
import static java.text.MessageFormat.format;
import static task5.dao.Currency.*;

public class InternationalBank implements Runnable {

    private final Logger logger = Logger.getLogger(InternationalBank.class.getName());
    public static final Random random = new Random();

    private final StockExchange stockExchange;

    public InternationalBank(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            var currency = values()[random.nextInt(values().length)];
            var rate = BigDecimal.valueOf(random.nextDouble(10));
            stockExchange.changeCurrencyRate(
                    currency,
                    rate);
            logger.info(format("Changing currency {0} to rate {1}", currency, rate));
            try {
                sleep(100);
            } catch (InterruptedException e) {
                Logger.getAnonymousLogger().warning(e.getMessage()) ;
            }
        }
    }
}
