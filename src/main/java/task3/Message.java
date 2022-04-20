package task3;

import java.text.MessageFormat;
import java.time.Instant;

public class Message {

    private String topic;
    private String message;
    private Instant time;

    public Message(String topic, String message, Instant time) {
        this.topic = topic;
        this.message = message;
        this.time = time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Message with topic: {0}, \n {1} , at time: {2}", topic, message, time);
    }
}
