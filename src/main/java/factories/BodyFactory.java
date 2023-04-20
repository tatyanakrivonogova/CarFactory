package factories;

import components.Body;
import inventorymanager.InventoryManager;

public class BodyFactory implements ComponentFactory<Body> {
    InventoryManager BodyInventoryManager;
    public BodyFactory() {
        BodyInventoryManager = new InventoryManager();
    }
    @Override
    public Body createComponent() {
        return new Body(BodyInventoryManager.giveId());
    }
}
