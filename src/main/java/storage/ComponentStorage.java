package storage;

import components.CarComponent;
import pubsub.Publisher;

import java.util.LinkedList;
import java.util.Queue;

public class ComponentStorage<T extends CarComponent> extends Publisher implements Storage<T> {
    String name;
    private final int capacity;
    private final Queue<T> componentQueue;
    private int sizeUsed;

    public ComponentStorage(String _name, int _capacity) {
        name = _name;
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
                Thread.currentThread().interrupt();
            }
        } else {
            componentQueue.add(component);
            ++sizeUsed;
            System.out.println(name + " storage++");
            System.out.println(sizeUsed);
            notify();
            notifySubscribers();
        }
    }

    @Override
    public synchronized T getComponent() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        T current = componentQueue.remove();
        notify();
        notifySubscribers();
        --sizeUsed;
        System.out.println(name + " storage--");
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
