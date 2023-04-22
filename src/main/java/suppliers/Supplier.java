package suppliers;

import components.CarComponent;
import controller.ComponentController;
import factories.ComponentFactory;
import storage.ComponentStorage;
import threads.Task;

import static java.lang.Thread.sleep;

public class Supplier<T extends CarComponent> implements Task {
    private final ComponentFactory<T> factory;
    private final ComponentStorage<T> storage;
    private int delay;
    ComponentController<T> controller;
    public Supplier(ComponentFactory<T> _factory, ComponentStorage<T> _storage, int _delay, ComponentController<T> _controller) {
        factory = _factory;
        storage = _storage;
        delay = _delay;
        controller = _controller;
    }
    public void setDelay(int newDelay) {
        delay = newDelay;
    }
    public void work() {
        while (true) {
            storage.putComponent(factory.createComponent());
            controller.update();
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
