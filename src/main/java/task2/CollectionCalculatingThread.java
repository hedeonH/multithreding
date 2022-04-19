package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class CollectionCalculatingThread extends Thread {

    private Collection<Integer> collection;
    private Function<Collection<Integer>, Integer> function;
    private String message;

    public CollectionCalculatingThread(Collection<Integer> collection, Function<Collection<Integer>, Integer> supplier, String message) {
        this.function = supplier;
        this.collection = collection;
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (collection) {
                System.out.println(message + function.apply(collection));
            }
        }
    }
}
