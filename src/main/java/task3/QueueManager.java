package task3;

import java.util.*;

public class QueueManager {

    private final Map<String, List<MessageConsumer>> topicConsumers;
    private final MessageQueue<Message> messageMessageQueue;

    public QueueManager(MessageQueue<Message> messageMessageQueue){
        this.messageMessageQueue = messageMessageQueue;
        this.topicConsumers = new HashMap<>();
    }

    public void addNewConsumer(MessageConsumer messageConsumer){
        if (topicConsumers.containsKey(messageConsumer.getRequiredTopic())){
            topicConsumers.get(messageConsumer.getRequiredTopic()).add(messageConsumer);
        }else {
            topicConsumers.put(messageConsumer.getRequiredTopic(), Arrays.asList(messageConsumer));
        }
    }

    public void publishMessage(Message message) {
        topicConsumers.getOrDefault(message.getTopic(), List.of())
                .forEach(messageConsumer -> messageConsumer.consumeMessage(message));
    }

    public void getMessage(){
        synchronized (messageMessageQueue) {
            if (messageMessageQueue.size() != 0) {
                publishMessage(messageMessageQueue.remove());
            }
        }
    }
}
