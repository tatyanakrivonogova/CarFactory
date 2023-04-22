package storage;

import components.Accessories;
import components.Body;
import components.Car;
import components.Engine;
import configuration.Configuration;
import pubsub.Publisher;
import pubsub.Subscriber;

public class CommonStorage extends Publisher implements Subscriber {
    private final ComponentStorage<Body> bodyStorage;
    private final ComponentStorage<Engine> engineStorage;
    private final ComponentStorage<Accessories> accessoriesStorage;
    private final ComponentStorage<Car> carStorage;
    public CommonStorage(Configuration configuration) {
        bodyStorage = new ComponentStorage<>("body", configuration.getBodyStorageCapacity());
        engineStorage = new ComponentStorage<>("engine", configuration.getEngineStorageCapacity());
        accessoriesStorage = new ComponentStorage<>("accessories", configuration.getAccessoriesStorageCapacity());
        carStorage = new ComponentStorage<>("car", configuration.getCarStorageCapacity());

        bodyStorage.addSubscriber(this);
        engineStorage.addSubscriber(this);
        accessoriesStorage.addSubscriber(this);
        carStorage.addSubscriber(this);
    }
    public ComponentStorage<Body> getBodyStorage() {
        return bodyStorage;
    }
    public ComponentStorage<Engine> getEngineStorage() {
        return engineStorage;
    }
    public ComponentStorage<Accessories> getAccessoriesStorage() {
        return accessoriesStorage;
    }
    public ComponentStorage<Car> getCarStorage() {
        return carStorage;
    }

    @Override
    public void update() {
        notifySubscribers();
    }
}
