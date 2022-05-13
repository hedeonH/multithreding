package task5;

import task5.dao.User;
import task5.service.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        User user = new User("John", "Smith", UUID.randomUUID(), BigDecimal.valueOf(1200000), BigDecimal.valueOf(1200000), BigDecimal.valueOf(1200000));
        User user2 = new User("Anna", "Black", UUID.randomUUID(), BigDecimal.valueOf(1600000), BigDecimal.valueOf(120000), BigDecimal.valueOf(1200000));
        User user3 = new User("Dana", "Spring", UUID.randomUUID(), BigDecimal.valueOf(1200000), BigDecimal.valueOf(120000), BigDecimal.valueOf(1200000));
        User user4 = new User("Nick", "Cole", UUID.randomUUID(), BigDecimal.valueOf(1280000), BigDecimal.valueOf(1500000), BigDecimal.valueOf(1200000));
        User user5 = new User("Sam", "White", UUID.randomUUID(), BigDecimal.valueOf(1400000), BigDecimal.valueOf(1209000), BigDecimal.valueOf(7200000));


        UserService userService = new UserService();
        CurrencyService currencyService = new CurrencyService();
        ExchangeService exchangeService = new ExchangeService(currencyService);
        setUpUsers(user, user2, user3, user4, user5, userService);

        Broker broker1 = new Broker(List.of(user, user2, user3, user4), exchangeService, userService);
        Broker broker2 = new Broker(List.of(user5, user2), exchangeService, userService);
        Broker broker3 = new Broker(List.of(user2, user3, user4), exchangeService, userService);
        Broker broker4 = new Broker(List.of(user, user2, user3, user4, user5), exchangeService, userService);
        var bank = new InternationalBank(new StockExchange());

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(bank);
        executorService.execute(broker1);
        executorService.execute(broker2);
        executorService.execute(broker3);
        executorService.execute(broker4);


    }

    private static void setUpUsers(User user, User user2, User user3, User user4, User user5, UserService userService) {
        Lock lock = new ReentrantLock();
        lock.lock();
        userService.createUsers(user, user2, user3, user4, user5);
        lock.unlock();
    }
}
