package threads.threadpools;

import threads.Task;

import java.util.Queue;

public class PooledThread extends Thread {
    private final Queue<Task> taskQueue;

    public PooledThread(String name, Queue<Task> _requestsQueue) {
        super(name);
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
                        System.out.println("----------------------------------------------");
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
