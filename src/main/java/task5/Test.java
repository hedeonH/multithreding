package task5;

import task5.dao.User;
import task5.service.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        User user = new User("John", "Smith", UUID.randomUUID(), BigDecimal.valueOf(1200000), BigDecimal.valueOf(1200000), BigDecimal.valueOf(1200000));
        User user2 = new User("Anna", "Black", UUID.randomUUID(), BigDecimal.valueOf(1600000), BigDecimal.valueOf(120000), BigDecimal.valueOf(1200000));
        User user3 = new User("Dana", "Spring", UUID.randomUUID(), BigDecimal.valueOf(1200000), BigDecimal.valueOf(120000), BigDecimal.valueOf(1200000));
        User user4 = new User("Nick", "Cole", UUID.randomUUID(), BigDecimal.valueOf(1280000), BigDecimal.valueOf(1500000), BigDecimal.valueOf(1200000));
        User user5 = new User("Sam", "White", UUID.randomUUID(), BigDecimal.valueOf(1400000), BigDecimal.valueOf(1209000), BigDecimal.valueOf(7200000));

        UserService userService = new UserService();
        ExchangeService exchangeService = new ExchangeService(CurrencyExchange.getInstance());
        userService.createUsers(user, user2, user3, user4, user5);

        Broker broker1 = new Broker(List.of(user, user2, user3, user4), exchangeService, userService);
        Broker broker2 = new Broker(List.of(user5, user2), exchangeService, userService);
        Broker broker3 = new Broker(List.of(user2, user3, user4), exchangeService, userService);
        Broker broker4 = new Broker(List.of(user, user2, user3, user4, user5), exchangeService, userService);
        var bank = new InternationalBank(CurrencyExchange.getInstance());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(bank);
        executorService.execute(broker1);
        executorService.execute(broker2);
        executorService.execute(broker3);
        executorService.execute(broker4);
    }
}
