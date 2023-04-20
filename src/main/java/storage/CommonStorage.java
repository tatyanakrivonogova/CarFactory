package storage;

import components.Accessories;
import components.Body;
import components.Car;
import components.Engine;
import configuration.Configuration;

public class CommonStorage {
    private final CarStorage<Body> bodyStorage;
    private final CarStorage<Engine> engineStorage;
    private final CarStorage<Accessories> accessoriesStorage;
    private final CarStorage<Car> carStorage;
    public CommonStorage(Configuration configuration) {
        bodyStorage = new CarStorage<>(configuration.getBodyStorageCapacity());
        engineStorage = new CarStorage<>(configuration.getEngineStorageCapacity());
        accessoriesStorage = new CarStorage<>(configuration.getAccessoriesStorageCapacity());
        carStorage = new CarStorage<>(configuration.getCarStorageCapacity());
    }
    public CarStorage<Body> getBodyStorage() {
        return bodyStorage;
    }
    public CarStorage<Engine> getEngineStorage() {
        return engineStorage;
    }
    public CarStorage<Accessories> getAccessoriesStorage() {
        return accessoriesStorage;
    }
    public CarStorage<Car> getCarStorage() {
        return carStorage;
    }
}
