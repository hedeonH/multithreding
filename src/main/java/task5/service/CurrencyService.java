package task5.service;

import task5.dao.Currency;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyService {

    public Map<Currency, BigDecimal> getCurrencyRates(){
       return StockExchange.getCurrencyRates();
    }
}
