package threads;

import components.Body;
import suppliers.Supplier;

import java.util.ArrayList;

public class BodySupplierRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public BodySupplierRequests(Supplier<Body> supplier) {
        requests.add(supplier);
    }
    public ArrayList<Task> getBodySupplierRequests() {
        return requests;
    }
}
