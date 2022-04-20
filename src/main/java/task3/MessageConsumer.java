package task3;

import java.util.ArrayDeque;

public class MessageConsumer extends Thread {

    private final MessageQueue<Message> messageMessageQueue;
    private final String requiredTopic ;

    public MessageConsumer(MessageQueue<Message> messageMessageQueue, String topic) {
        this.messageMessageQueue = messageMessageQueue;
        this.requiredTopic = topic;
    }

    @Override
    public void run(){
        if (messageMessageQueue.isTopicMessagePresent(requiredTopic)){
            System.out.println(messageMessageQueue.consumeMessageWithTopic(requiredTopic).toString());
        }
    }

}
