package task5.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class User implements Serializable {

    public User() {
    }

    public User(String name, String surname, UUID id, BigDecimal dollarBalance, BigDecimal euroBalance, BigDecimal hryvniaBalance) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dollarBalance = dollarBalance;
        this.euroBalance = euroBalance;
        this.hryvniaBalance = hryvniaBalance;
    }

    private String name;

    private String surname;

    private UUID id;

    private BigDecimal dollarBalance;

    private BigDecimal euroBalance;

    private BigDecimal hryvniaBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getDollarBalance() {
        return dollarBalance;
    }

    public void setDollarBalance(BigDecimal dollarBalance) {
        this.dollarBalance = dollarBalance;
    }

    public BigDecimal getEuroBalance() {
        return euroBalance;
    }

    public void setEuroBalance(BigDecimal euroBalance) {
        this.euroBalance = euroBalance;
    }

    public BigDecimal getHryvniaBalance() {
        return hryvniaBalance;
    }

    public void setHryvniaBalance(BigDecimal hryvniaBalance) {
        this.hryvniaBalance = hryvniaBalance;
    }

    public BigDecimal getCurrencyAmount(Currency currency) {
        switch (currency) {
            case EURO -> {
                return getEuroBalance();
            }
            case DOLLAR -> {
                return getDollarBalance();
            }
            case HRYVNIA -> {
                return getHryvniaBalance();
            }
            default -> throw new UnsupportedOperationException();
        }
    }

    public void setCurrencyAmount(Currency currency, BigDecimal amount) {
        switch (currency) {
            case EURO -> setEuroBalance(amount);
            case DOLLAR -> setDollarBalance(amount);
            case HRYVNIA -> setHryvniaBalance(amount);
            default -> throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", dollarBalance=" + dollarBalance +
                ", euroBalance=" + euroBalance +
                ", hryvniaBalance=" + hryvniaBalance +
                '}';
    }
}
