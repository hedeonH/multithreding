package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class CollectionService {

    public void test() {
        Collection<Integer> collection = new ArrayList<>();
        Function<Collection<Integer>, Integer> sumCollection = a ->
                a.stream().reduce(0, Integer::sum);
        Function<Collection<Integer>, Integer> squareSum = integerCollection ->
                (int) Math.sqrt(integerCollection.stream().map(a -> a * a).reduce(0, Integer::sum).doubleValue());

        CollectionWritingThread collectionWritingThread = new CollectionWritingThread(collection);
        CollectionCalculatingThread summingThread = new CollectionCalculatingThread(collection, sumCollection, "Sum is ");
        CollectionCalculatingThread squareSumThread = new CollectionCalculatingThread(collection, squareSum, "Root square of sums is ");

        collectionWritingThread.start();
        summingThread.start();
        squareSumThread.start();
    }
}
