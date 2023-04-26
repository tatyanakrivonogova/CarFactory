package threads.threadpools;

import dealers.Dealers;
import threads.Task;

import java.util.ArrayList;

public class DealersRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public DealersRequests(Dealers dealers) {
        requests.addAll(dealers.getDealers());
    }
    public ArrayList<Task> getDealersRequests() {
        return requests;
    }
}
