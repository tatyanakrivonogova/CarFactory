package threads.threadpools;

import suppliers.AccessoriesSuppliers;
import suppliers.Supplier;
import threads.Task;

import java.util.ArrayList;

public class AccessoriesSuppliersRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public AccessoriesSuppliersRequests(AccessoriesSuppliers suppliers) {
        for (Supplier s : suppliers.getSuppliers()) requests.add(s);
    }
    public ArrayList<Task> getAccessoriesSuppliersRequests() {
        return requests;
    }
}
