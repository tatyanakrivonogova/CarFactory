package threads.threadpools;


import threads.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class ThreadPool {
    private final Queue<Task> requestsQueue = new LinkedList<>();

    public void addRequest(Task request) {
        synchronized (requestsQueue) {
            requestsQueue.add(request);
            requestsQueue.notify();
        }
    }

    public ThreadPool(int numberOfThreads) {
        Set<PooledThread> availableThreads = new HashSet<>();
        for (int i = 0; i < numberOfThreads; ++i) {
            availableThreads.add(new PooledThread(requestsQueue));
        }
        for (PooledThread availableThread : availableThreads) {
            availableThread.start();
        }
    }
}