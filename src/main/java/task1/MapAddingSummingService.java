package task1;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.time.StopWatch;

public class MapAddingSummingService {

    public void test() {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();
        Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        testMapConcurrency(hashMap);
        //testMapConcurrency(concurrentMap);
        //testMapConcurrency(synchronizedMap);
        stopWatch.stop();
        System.out.println("Elapsed Time in minutes: " + stopWatch.getNanoTime());


    }

    private void testMapConcurrency(Map<Integer, Integer> map) {
        Thread addThread = new Thread(new AddingRunnable(map));
        Thread sumThread = new Thread(new SumRunnable(map));
        sumThread.start();
        addThread.start();
    }

}
