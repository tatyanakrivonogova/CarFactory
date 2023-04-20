package dealers;

import storage.CommonStorage;
import dealers.Dealer;

import java.util.ArrayList;

public class Dealers {
    private final ArrayList<Dealer> dealers;
    public Dealers(int numberOfDealers, CommonStorage commonStorage) {
        dealers = new ArrayList<>();
        for (int i = 0; i < numberOfDealers;++i) {
            dealers.add(new Dealer(commonStorage.getCarStorage(), 1000));
        }
    }
    public void setDelay(int delay) {
        for (Dealer d : dealers) d.setDelay(delay);
    }
    public ArrayList<Dealer> getDealers() {
        return dealers;
    }
}
