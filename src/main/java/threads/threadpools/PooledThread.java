package threads.threadpools;

import threads.Task;

import java.util.Queue;

public class PooledThread extends Thread {
    private final Queue<Task> taskQueue;

    public PooledThread(Queue<Task> _requestsQueue) {
        super();
        taskQueue = _requestsQueue;
    }
    public void run() {
        Task runningTask = null;
        while (true) {
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    }
                    catch (InterruptedException e) {
                        System.out.println("interrupted");
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
