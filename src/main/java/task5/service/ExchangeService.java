package task5.service;

import task5.dao.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeService {

    private final CurrencyService currencyService;

    public ExchangeService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public BigDecimal exchangeCurrency(Currency exchangeFrom, Currency exchangeTo , BigDecimal amount){
        var rates = currencyService.getCurrencyRates();
       return convertCurrencies(rates.get(exchangeFrom), rates.get(exchangeTo), amount);
    }

    private BigDecimal convertCurrencies(BigDecimal exchangeFromRate, BigDecimal exchangeToRate, BigDecimal amount) {
        var exchangeRate = exchangeFromRate.divide(exchangeToRate, 10, RoundingMode.CEILING);
        return amount.multiply(exchangeRate);
    }
}
