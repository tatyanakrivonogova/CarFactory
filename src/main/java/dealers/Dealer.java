package dealers;

import components.Car;
import controller.ComponentController;
import storage.CarStorage;

import static java.lang.Thread.sleep;

public class Dealer {
    private final CarStorage<Car> storage;
    private int delay;
    ComponentController<Car> soldCarController;

    public Dealer(CarStorage<Car> _storage, int _delay, ComponentController<Car> _soldCarController) {
        storage = _storage;
        delay = _delay;
        soldCarController = _soldCarController;
    }

    public void setDelay(int newDelay) {
        delay = newDelay;
    }
    public void work() {
        while (true) {
            storage.getComponent();
            soldCarController.update();
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
