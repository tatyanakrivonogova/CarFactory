package threads;

import java.util.Queue;

public class EngineSupplierThread extends Thread {
    private final Queue<Task> requestsQueue;

    public EngineSupplierThread(Queue<Task> _requestsQueue) {
        super();
        requestsQueue = _requestsQueue;
    }
    public void addRequest(Task request) {
        synchronized (requestsQueue) {
            requestsQueue.add(request);
            requestsQueue.notify();
        }
    }
    public void run() {
        Task runningTask = null;
        while (true) {
            synchronized (requestsQueue) {
                if (requestsQueue.isEmpty()) {
                    try {
                        requestsQueue.wait();
                    }
                    catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                }
                else {
                    runningTask = requestsQueue.remove();
                }
            }
            if (runningTask != null) runningTask.work();
        }
    }

}
