package threads.threadpools;

import dealers.Dealer;
import dealers.Dealers;
import threads.Task;

import java.util.ArrayList;

public class DealersRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public DealersRequests(Dealers dealers) {
        for (Dealer d : dealers.getDealers()) requests.add(d);
    }
    public ArrayList<Task> getDealersRequests() {
        return requests;
    }
}
