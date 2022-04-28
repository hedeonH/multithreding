package task3;

public class MessageConsumer extends Thread {

    private final QueueManager queueManager;
    private final String requiredTopic;

    boolean consumedMessage = false;

    public MessageConsumer(QueueManager queueManager, String topic) {
        this.queueManager = queueManager;
        this.requiredTopic = topic;
    }

    public String getRequiredTopic() {
        return requiredTopic;
    }

    public void consumeMessage(Message message) {
        System.out.println("Message in thread " + currentThread().getName() + " With message " + message.getMessage() + " with topic " + message.getTopic());
        consumedMessage = true;
    }

    @Override
    public void run() {
        while (!consumedMessage)
            queueManager.getMessage();
    }
}
