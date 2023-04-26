package threads.threadpools;

import suppliers.AccessoriesSuppliers;
import threads.Task;

import java.util.ArrayList;

public class AccessoriesSuppliersRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public AccessoriesSuppliersRequests(AccessoriesSuppliers suppliers) {
        requests.addAll(suppliers.getSuppliers());
    }
    public ArrayList<Task> getAccessoriesSuppliersRequests() {
        return requests;
    }
}
