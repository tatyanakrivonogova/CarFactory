package storage;

import components.CarComponent;

public interface Storage<T extends CarComponent> {
    public void putComponent(T component);
    public T getComponent();
    public int getCapacity();
    public int getSizeUsed();
    public boolean isEmpty();
    public boolean isFull();
}
