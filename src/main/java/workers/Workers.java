package workers;

import inventorymanager.InventoryManager;
import storage.CommonStorage;

import java.util.ArrayList;

public class Workers {
    private final ArrayList<Worker> workers;
    public Workers(int numberOfWorkers, CommonStorage commonStorage) {
        workers = new ArrayList<>();
        InventoryManager carInventoryManager = new InventoryManager();
        for (int i = 0; i < numberOfWorkers;++i) {
            workers.add(new Worker(carInventoryManager, commonStorage, 1000));
        }
    }
    public void setDelay(int delay) {
        for (Worker w : workers) w.setDelay(delay);
    }
    public ArrayList<Worker> getDealers() {
        return workers;
    }
}
