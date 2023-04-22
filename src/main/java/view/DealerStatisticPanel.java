package view;

import controller.SoldCarController;
import pubsub.Subscriber;

import javax.swing.*;

public class DealerStatisticPanel extends JPanel implements Subscriber {
    SoldCarController controller;
    private final JLabel soldCarNumberLabel = new JLabel("Cars sold: 0");

    public DealerStatisticPanel(SoldCarController _controller) {
        super();
        controller = _controller;
        this.add(soldCarNumberLabel);
    }
    @Override
    public void update() {
        soldCarNumberLabel.setText("Cars sold: " + controller.getSoldCarsNumber());
    }
}
