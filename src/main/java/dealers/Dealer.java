package dealers;

import components.Car;
import storage.CarStorage;

import static java.lang.Thread.sleep;

public class Dealer {
    private final CarStorage<Car> storage;
    private int delay;

    public Dealer(CarStorage<Car> _storage, int _delay) {
        storage = _storage;
        delay = _delay;
    }

    public void setDelay(int newDelay) {
        delay = newDelay;
    }
    public void work() {
        while (true) {
            storage.getComponent();
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
