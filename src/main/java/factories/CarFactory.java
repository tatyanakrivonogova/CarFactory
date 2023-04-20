package factories;

import components.Accessories;
import components.Body;
import components.Car;
import components.Engine;
import inventorymanager.InventoryManager;

public class CarFactory {
    InventoryManager CarInventoryManager = new InventoryManager();
    public Car createCar(Body _body, Engine _engine, Accessories _accessories) {
        return new Car(CarInventoryManager.giveId(), _body, _engine, _accessories);
    }
}
