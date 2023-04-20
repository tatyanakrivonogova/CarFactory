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
    private final ComponentController<Car> carController;
    public Controller() {
        bodyController = new ComponentController<>();
        engineController = new ComponentController<>();
        accessoriesController = new ComponentController<>();
        carController = new ComponentController<>();

        bodyController.addSubscriber(this);
        engineController.addSubscriber(this);
        accessoriesController.addSubscriber(this);
        carController.addSubscriber(this);
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
    public ComponentController<Car> getCarController() {
        return carController;
    }
    @Override
    public void update() {
        notifySubscribers();
    }
}
