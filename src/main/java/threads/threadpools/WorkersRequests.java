package threads.threadpools;

import threads.Task;
import workers.Worker;
import workers.Workers;

import java.util.ArrayList;

public class WorkersRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public WorkersRequests(Workers workers) {
        for (Worker w : workers.getWorkers()) requests.add(w);
    }
    public ArrayList<Task> getWorkersRequests() {
        return requests;
    }
}
