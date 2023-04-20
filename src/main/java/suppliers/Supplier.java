package suppliers;

import components.CarComponent;
import factories.ComponentFactory;
import storage.CarStorage;

import static java.lang.Thread.sleep;

public class Supplier<T extends CarComponent> {
    private final ComponentFactory<T> factory;
    private final CarStorage<T> storage;
    private int delay;

    public Supplier(ComponentFactory<T> _factory, CarStorage<T> _storage, int _delay) {
        factory = _factory;
        storage = _storage;
        delay = _delay;
    }
    public void setDelay(int newDelay) {
        delay = newDelay;
    }
    public void work() {
        while (true) {
            storage.putComponent(factory.createComponent());
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
