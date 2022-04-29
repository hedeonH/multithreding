package task4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Pool that block when it has not any items or it full
 */
public class BlockingObjectPool {

    private final int size;

    private final BlockingQueue<Object> poolObjects;

    private final Lock lock = new ReentrantLock();

    private final Condition full = lock.newCondition();

    private final Condition empty = lock.newCondition();

    /**
     * Creates filled pool of passed size * * @param size of pool
     */
    public BlockingObjectPool(int size) {
        this.size = size;
        poolObjects = new ArrayBlockingQueue<>(size);
    }

    /**
     * Gets object from pool or blocks if pool is empty
     * * @return object from pool
     */
    public Object get() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (poolObjects.size() == 0) {
                empty.await();
            }
            full.signal();
            return poolObjects.poll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Puts object to pool or blocks if pool is full * *
     *
     * @param object to be taken back to pool
     */
    public void take(Object object) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (poolObjects.size() == size) {
                full.await();
            }
            empty.signal();
            poolObjects.add(object);
            System.out.println("An object was added to the pool"
                    + poolObjects);
        } finally {
            lock.unlock();
        }
    }
}
