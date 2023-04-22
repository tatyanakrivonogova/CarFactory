package controller;

import pubsub.Publisher;

public class SoldCarController extends Publisher {
    private int soldCarsNumber = 0;
    public void update() {
        ++soldCarsNumber;
        notifySubscribers();
    }
    public int getSoldCarsNumber() {
        return soldCarsNumber;
    }
}
