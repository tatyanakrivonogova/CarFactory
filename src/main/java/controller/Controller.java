package controller;

import components.Accessories;
import components.Body;
import components.Car;
import components.Engine;
import pubsub.Publisher;
import pubsub.Subscriber;

public class Controller extends Publisher implements Subscriber {
    private final ComponentController<Body> bodyController;
    private final ComponentController<Engine> engineController;
    private final ComponentController<Accessories> accessoriesController;
    private final ComponentController<Car> readyCarController;
    private final SoldCarController soldCarController;

    public Controller() {
        bodyController = new ComponentController<>();
        engineController = new ComponentController<>();
        accessoriesController = new ComponentController<>();
        readyCarController = new ComponentController<>();
        soldCarController = new SoldCarController();

        bodyController.addSubscriber(this);
        engineController.addSubscriber(this);
        accessoriesController.addSubscriber(this);
        readyCarController.addSubscriber(this);
        soldCarController.addSubscriber(this);
    }

    public ComponentController<Body> getBodyController() {
        return bodyController;
    }
    public ComponentController<Engine> getEngineController() {
        return engineController;
    }
    public ComponentController<Accessories> getAccessoriesController() {
        return accessoriesController;
    }
    public ComponentController<Car> getReadyCarController() {
        return readyCarController;
    }
    public SoldCarController getSoldCarController() {
        return soldCarController;
    }
    @Override
    public void update() {
        notifySubscribers();
    }
}
