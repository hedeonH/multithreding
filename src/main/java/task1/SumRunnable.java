package task1;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class SumRunnable implements Runnable {

    private Map<Integer, Integer> map;

    public SumRunnable(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            int acc = 0;
            try {
               // synchronized (map) {  // hashmap and synchronized hashmap CME solution
                    for (Integer integer : map.values()) {
                        acc = acc + integer;
                    }
              //  }
            } catch (ConcurrentModificationException e) {
                System.out.println("Concurrent Modification Exception in summing thread with map of type:" + map.getClass());
            }
        }
    }
}
