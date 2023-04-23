package dealers;

import components.Car;
import controller.SoldCarController;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import storage.ComponentStorage;
import threads.Task;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Dealer implements Task {
    int id;
    private final ComponentStorage<Car> storage;
    private int delay;
    SoldCarController soldCarController;
    Logger logger;

    public Dealer(int _id, ComponentStorage<Car> _storage, int _delay, SoldCarController _soldCarController, Logger _logger) {
        id = _id;
        storage = _storage;
        delay = _delay;
        soldCarController = _soldCarController;
        logger = _logger;
    }

    public void setDelay(int newDelay) {
        delay = newDelay;
    }
    public void work() {
        while (!currentThread().isInterrupted()) {
            Car car = storage.getComponent();
            if (car == null) return;
            soldCarController.update();
            logger.log(Level.INFO, "Dealer : " + id + " Auto : " + car.getId() + " (Body : " +
                    car.getBody().getId() + " , Engine : " + car.getEngine().getId() + " , Accessories : " +
                    car.getAccessories().getId() + " ) ");
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
