package workers;

import components.Accessories;
import components.Body;
import components.Car;
import components.Engine;
import inventorymanager.InventoryManager;
import storage.CarStorage;
import storage.CommonStorage;

import static java.lang.Thread.sleep;

public class Worker {
    InventoryManager carInventoryManager;
    private final CarStorage<Car> carStorage;
    private final CarStorage<Body> bodyStorage;
    private final CarStorage<Engine> engineStorage;
    private final CarStorage<Accessories> accessoriesStorage;
    private int delay;

    public Worker(InventoryManager _carInventoryManager, CommonStorage commonStorage, int _delay) {
        carInventoryManager = _carInventoryManager;
        carStorage = commonStorage.getCarStorage();
        bodyStorage = commonStorage.getBodyStorage();
        engineStorage = commonStorage.getEngineStorage();
        accessoriesStorage = commonStorage.getAccessoriesStorage();
        delay = _delay;
    }

    public void setDelay(int newDelay) {
        delay = newDelay;
    }
    public void work() {
        while (true) {
            Body body = bodyStorage.getComponent();
            Engine engine = engineStorage.getComponent();
            Accessories accessories = accessoriesStorage.getComponent();
            Car car = new Car(carInventoryManager.giveId(), body, engine, accessories);
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
