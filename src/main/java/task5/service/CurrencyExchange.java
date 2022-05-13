package task5.service;

import task5.dao.Currency;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class CurrencyExchange {

    private static class CurrencyExchangeHolder {
        static final CurrencyExchange INSTANCE = new CurrencyExchange();
    }

    public static CurrencyExchange getInstance() {
        return CurrencyExchangeHolder.INSTANCE;
    }
    private Map<Currency, BigDecimal> currencyRates= new EnumMap<>(Currency.class);

    private CurrencyExchange(){
        currencyRates.put(Currency.EURO, BigDecimal.ONE);
        currencyRates.put(Currency.HRYVNIA, BigDecimal.ONE);
        currencyRates.put(Currency.DOLLAR, BigDecimal.ONE);
    }


    public synchronized void changeCurrencyRate(Currency currency, BigDecimal newRate){
        currencyRates.put(currency, newRate);
    }

    public Map<Currency, BigDecimal> getCurrencyRates() {
        return currencyRates;
    }
}
