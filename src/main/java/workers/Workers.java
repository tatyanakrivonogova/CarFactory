package workers;

import components.Car;
import controller.ComponentController;
import inventorymanager.InventoryManager;
import storage.CommonStorage;

import java.util.ArrayList;

public class Workers {
    private final ArrayList<Worker> workers;
    public Workers(int numberOfWorkers, CommonStorage commonStorage, ComponentController<Car> readyCarController) {
        workers = new ArrayList<>();
        InventoryManager carInventoryManager = new InventoryManager();
        for (int i = 0; i < numberOfWorkers;++i) {
            workers.add(new Worker(carInventoryManager, commonStorage, 5000, readyCarController));
        }
    }
    public void setDelay(int delay) {
        for (Worker w : workers) w.setDelay(delay);
    }
    public ArrayList<Worker> getWorkers() {
        return workers;
    }
}
