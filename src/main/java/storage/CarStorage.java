package storage;

import components.CarComponent;

import java.util.LinkedList;
import java.util.Queue;

public class CarStorage<T extends CarComponent> implements Storage<T> {
    private final int capacity;
    private final Queue<T> componentQueue;
    private int sizeUsed;

    public CarStorage(int _capacity) {
        capacity = _capacity;
        componentQueue = new LinkedList<>();
        sizeUsed = 0;
    }

    @Override
    public synchronized void putComponent(T component) {
        if (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            componentQueue.add(component);
            notify();
            ++sizeUsed;
        }
    }

    @Override
    public synchronized T getComponent() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        T current = componentQueue.remove();
        notify();
        --sizeUsed;
        return current;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getSizeUsed() {
        return sizeUsed;
    }

    @Override
    public boolean isEmpty() {
        return sizeUsed == 0;
    }

    @Override
    public boolean isFull() {
        return sizeUsed == capacity;
    }
}
