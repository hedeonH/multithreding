package task2;

import java.util.Collection;
import java.util.Random;

public class CollectionWritingThread extends Thread {

    private final Collection<Integer> collection;

    public CollectionWritingThread(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
           // synchronized (collection) {
                Integer i = random.nextInt();
                System.out.println("Adding integer " + i);
                collection.add(i);
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
          //  }
        }
    }
}
