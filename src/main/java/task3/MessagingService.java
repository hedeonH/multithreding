package task3;

public class MessagingService {

    public void test() {
        MessageQueue<Message> messageQueue = new MessageQueue<>();

        MessageProducer messageProducer = new MessageProducer(messageQueue);
        MessageConsumer messageConsumer = new MessageConsumer(messageQueue, "topic1");

        messageProducer.start();
        messageConsumer.start();
    }
}
