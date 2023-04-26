package threads.threadpools;

import threads.Task;
import workers.Workers;

import java.util.ArrayList;

public class WorkersRequests {
    ArrayList<Task> requests = new ArrayList<>();
    public WorkersRequests(Workers workers) {
        requests.addAll(workers.getWorkers());
    }
    public ArrayList<Task> getWorkersRequests() {
        return requests;
    }
}
