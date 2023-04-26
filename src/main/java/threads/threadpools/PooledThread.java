package threads.threadpools;

import threads.Task;

import java.util.Queue;

public class PooledThread extends Thread {
    private final Queue<Task> taskQueue;

    public PooledThread(String name, int index, Queue<Task> _requestsQueue) {
        super(name + " " + index);
        taskQueue = _requestsQueue;
    }
    public void run() {
        Task runningTask = null;
        while (!currentThread().isInterrupted()) {
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                else {
                    runningTask = taskQueue.remove();
                }
            }
            if (runningTask != null) runningTask.work();
        }
    }

}
