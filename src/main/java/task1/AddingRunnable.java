package task1;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class AddingRunnable implements Runnable {

    private Map<Integer, Integer> map;

    public AddingRunnable(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
               // synchronized (map) {   // hashmap concurrent modification exception solution
                    map.put(i, i);
             //   }
            } catch (ConcurrentModificationException e) {
                System.out.println("Concurrent Modification Exception in adding thread with map of type:" + map.getClass());
            }
        }
    }
}
