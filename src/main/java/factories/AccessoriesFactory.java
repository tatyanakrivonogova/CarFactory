package factories;

import components.Accessories;
import inventorymanager.InventoryManager;

public class AccessoriesFactory implements ComponentFactory<Accessories> {
    InventoryManager AccessoriesInventoryManager = new InventoryManager();
    @Override
    public Accessories createComponent() {
        return new Accessories(AccessoriesInventoryManager.giveId());
    }
}
