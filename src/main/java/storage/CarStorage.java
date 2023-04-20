package storage;

import components.CarComponent;

public class CarStorage<T extends CarComponent> implements Storage<T> {
    @Override
    public void putComponent(T component) {

    }

    @Override
    public T getComponent() {
        return null;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
