package dealers;

import components.Car;
import controller.ComponentController;
import storage.CommonStorage;

import java.util.ArrayList;

public class Dealers {
    private final ArrayList<Dealer> dealers;
    public Dealers(int numberOfDealers, CommonStorage commonStorage, ComponentController<Car> soldCarController) {
        dealers = new ArrayList<>();
        for (int i = 0; i < numberOfDealers;++i) {
            dealers.add(new Dealer(commonStorage.getCarStorage(), 1000, soldCarController));
        }
    }
    public void setDelay(int delay) {
        for (Dealer d : dealers) d.setDelay(delay);
    }
    public ArrayList<Dealer> getDealers() {
        return dealers;
    }
}
