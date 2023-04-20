package controller;

import components.CarComponent;
import pubsub.Publisher;

public class ComponentController<T extends CarComponent> extends Publisher {
    private int componentsNumber = 0;
    public void update() {
        ++componentsNumber;
        notifySubscribers();
    }
    public int getComponentsNumber() {
        return componentsNumber;
    }
}
