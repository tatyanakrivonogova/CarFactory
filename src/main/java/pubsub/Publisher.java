package pubsub;

import java.util.ArrayList;

public class Publisher {
    ArrayList<Subscriber> subscribers;
    public Publisher() {
        subscribers = new ArrayList<>();
    }
    public void notifySubscribers() {
        for (Subscriber s: subscribers) s.update();
    }
    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }
    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }
}
