package threads;

import components.Engine;
import suppliers.Supplier;

import java.util.ArrayList;

public class EngineSupplierRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public EngineSupplierRequests(Supplier<Engine> supplier) {
        requests.add(supplier);
    }
    public ArrayList<Task> getEngineSupplierRequests() {
        return requests;
    }
}
