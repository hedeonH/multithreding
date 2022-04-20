package task3;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MessageProducer extends Thread {

    public final ArrayDeque<Message> messageMessageQueue;

    public final String[] topics = {"topic1", "topic2", "topic3"};

    public MessageProducer(ArrayDeque<Message> messageMessageQueue) {
        this.messageMessageQueue = messageMessageQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String topic = topics[random.nextInt(topics.length)];
            messageMessageQueue.add(new Message(topic, "Test message", Instant.now()));
            System.out.println("adding a new Message " + topic);
        }
    }
}
