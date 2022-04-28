package task3;

public class MessagingService {

    public void test() {
        MessageQueue<Message> messageQueue = new MessageQueue<>();
        QueueManager queueManager = new QueueManager(messageQueue);

        MessageProducer messageProducer = new MessageProducer(messageQueue);
        MessageProducer messageProducer2 = new MessageProducer(messageQueue);
        MessageConsumer messageConsumer = new MessageConsumer(queueManager, "topic1");
        MessageConsumer messageConsumer2 = new MessageConsumer(queueManager, "topic2");
        MessageConsumer messageConsumer3 = new MessageConsumer(queueManager, "topic3");
        queueManager.addNewConsumer(messageConsumer);
        queueManager.addNewConsumer(messageConsumer2);
        queueManager.addNewConsumer(messageConsumer3);

        messageProducer.start();
        messageConsumer.start();
        messageProducer2.start();
        messageConsumer2.start();
        messageConsumer3.start();
    }
}
