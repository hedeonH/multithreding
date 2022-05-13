package task5.dao;

import java.math.BigDecimal;

public class CurrencyRate {

    private  Currency currency;

    private BigDecimal rate;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
