package dealers;

import components.Car;
import controller.SoldCarController;
import storage.ComponentStorage;
import threads.Task;

import static java.lang.Thread.sleep;

public class Dealer implements Task {
    private final ComponentStorage<Car> storage;
    private int delay;
    SoldCarController soldCarController;

    public Dealer(ComponentStorage<Car> _storage, int _delay, SoldCarController _soldCarController) {
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
            System.out.println("dealer");
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
