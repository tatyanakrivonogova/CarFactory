package threads.threadpools;

import threads.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class ThreadPool {
    private final Queue<Task> requestsQueue = new LinkedList<>();
    Set<PooledThread> availableThreads;

    public void addRequest(Task request) {
        synchronized (requestsQueue) {
            requestsQueue.add(request);
            requestsQueue.notify();
        }
    }

    public ThreadPool(String name, int numberOfThreads) {
        availableThreads = new HashSet<>();
        for (int i = 0; i < numberOfThreads; ++i) {
            availableThreads.add(new PooledThread(name, requestsQueue));
        }
        for (PooledThread availableThread : availableThreads) {
            availableThread.start();
        }
    }

    public void shutdown() {
        for (PooledThread t : availableThreads) {
            t.interrupt();
        }
    }
}