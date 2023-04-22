package suppliers;

import components.Accessories;
import controller.ComponentController;
import factories.AccessoriesFactory;
import storage.CommonStorage;

import java.util.ArrayList;

public class AccessoriesSuppliers {
    private final ArrayList<Supplier> suppliers;
    public AccessoriesSuppliers(int numberOfSuppliers, CommonStorage commonStorage, AccessoriesFactory accessoriesFactory, ComponentController<Accessories> _controller) {
        suppliers = new ArrayList<>();
        for (int i = 0; i < numberOfSuppliers;++i) {
            suppliers.add(new Supplier(accessoriesFactory, commonStorage.getAccessoriesStorage(), 5000, _controller));
        }
    }
    public void setDelay(int delay) {
        for (Supplier s : suppliers) s.setDelay(delay);
    }
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
}
