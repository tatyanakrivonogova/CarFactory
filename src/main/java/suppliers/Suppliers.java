package suppliers;

import factories.FactoriesCreator;
import storage.CommonStorage;

import java.util.ArrayList;

public class Suppliers {
    private final ArrayList<Supplier> suppliers;
    public Suppliers(int numberOfDealers, CommonStorage commonStorage, FactoriesCreator creator) {
        suppliers = new ArrayList<>();
        for (int i = 0; i < numberOfDealers;++i) {
            suppliers.add(new Supplier(creator.getAccessoriesFactory(), commonStorage.getAccessoriesStorage(), 1000));
        }
    }
    public void setDelay(int delay) {
        for (Supplier s : suppliers) s.setDelay(delay);
    }
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
}
