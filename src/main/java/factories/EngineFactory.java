package factories;

import components.Engine;
import inventorymanager.InventoryManager;

public class EngineFactory implements ComponentFactory<Engine> {
    InventoryManager EngineInventoryManager = new InventoryManager();
    @Override
    public Engine createComponent() {
        return new Engine(EngineInventoryManager.giveId());
    }
}
