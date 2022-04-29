package task3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue<T extends Message> extends LinkedTransferQueue<T> {

    private final Lock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    @Override
    public T remove() {
        try {
            lock.lock();
            while (this.size()==0){
                notEmpty.await();
            }
            return super.remove();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
