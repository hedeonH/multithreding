package task5.service;

import task5.dao.Currency;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class StockExchange {

    private static volatile Map<Currency, BigDecimal> currencyRates= new EnumMap<>(Currency.class);

    public StockExchange(){
        currencyRates.put(Currency.EURO, BigDecimal.ONE);
        currencyRates.put(Currency.HRYVNIA, BigDecimal.ONE);
        currencyRates.put(Currency.DOLLAR, BigDecimal.ONE);
    }

    public synchronized  void changeCurrencyRate(Currency currency, BigDecimal newRate){
        currencyRates.put(currency, newRate);
    }

    public static Map<Currency, BigDecimal> getCurrencyRates() {
        return currencyRates;
    }
}
