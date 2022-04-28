package task3;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue<T extends Message> extends ArrayDeque<T> {

    private final Lock lock = new ReentrantLock(false);

    @Override
    public T remove() {
        return super.remove();
    }
}
