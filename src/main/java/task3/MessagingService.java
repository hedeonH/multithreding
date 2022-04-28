package task3;

public class MessagingService {

    public void test() {
        MessageQueue<Message> messageQueue = new MessageQueue<>();
        QueueManager queueManager = new QueueManager(messageQueue);

        MessageProducer messageProducer = new MessageProducer(messageQueue);
        MessageConsumer messageConsumer = new MessageConsumer(queueManager, "topic1");
        queueManager.addNewConsumer(messageConsumer);


        messageProducer.start();
        messageConsumer.start();

    }
}
