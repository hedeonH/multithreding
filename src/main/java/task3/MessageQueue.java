package task3;

import java.util.ArrayDeque;

public class MessageQueue<T extends Message> extends ArrayDeque<T> {

    public synchronized  boolean isTopicMessagePresent(String topic) {
        return this.stream().anyMatch(a -> a.getTopic().equals(topic));
    }

    public synchronized Message consumeMessageWithTopic(String topic) {
        var messages = this.iterator();
        while (messages.hasNext()) {
            var message = iterator().next();
            if (message.getTopic().equals(topic)) {
                    this.remove(message);
                    return message;
            }
        }
        return null;
    }

}
