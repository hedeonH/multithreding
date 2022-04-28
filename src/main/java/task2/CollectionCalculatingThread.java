package task2;

import java.util.Collection;
import java.util.function.Function;

public class CollectionCalculatingThread extends Thread {

    private final Collection<Integer> collection;
    private final Function<Collection<Integer>, Integer> function;
    private final String message;

    public CollectionCalculatingThread(Collection<Integer> collection,
                                       Function<Collection<Integer>, Integer> supplier,
                                       String message) {
        this.function = supplier;
        this.collection = collection;
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            //  synchronized (collection) {
            Integer apply = function.apply(collection);
            System.out.println(message + apply);
            // }
        }
    }
}
