package view;

import controller.Controller;
import pubsub.Subscriber;
import storage.CommonStorage;

import javax.swing.*;
import java.awt.*;

public class StatisticPanel extends JPanel implements Subscriber {
    private final ComponentStatisticPanel bodyStatisticPanel;
    private final ComponentStatisticPanel engineStatisticPanel;
    private final ComponentStatisticPanel accessoriesStatisticPanel;
    private final ComponentStatisticPanel carStatisticPanel;
    private final DealerStatisticPanel dealerStatisticPanel;

    public StatisticPanel(CommonStorage commonStorage, Controller controller) {
        super();
        this.setLayout(new GridLayout(8, 0, 10, 10));
        bodyStatisticPanel = new ComponentStatisticPanel("Body", commonStorage.getBodyStorage(), controller.getBodyController());
        engineStatisticPanel = new ComponentStatisticPanel("Engine", commonStorage.getEngineStorage(), controller.getEngineController());
        accessoriesStatisticPanel = new ComponentStatisticPanel("Accessories", commonStorage.getAccessoriesStorage(), controller.getAccessoriesController());
        carStatisticPanel = new ComponentStatisticPanel("Car", commonStorage.getCarStorage(), controller.getReadyCarController());
        dealerStatisticPanel = new DealerStatisticPanel(controller.getSoldCarController());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(bodyStatisticPanel);
        this.add(engineStatisticPanel);
        this.add(accessoriesStatisticPanel);
        this.add(carStatisticPanel);
        this.add(dealerStatisticPanel);
    }
    @Override
    public void update() {
        bodyStatisticPanel.update();
        engineStatisticPanel.update();
        accessoriesStatisticPanel.update();
        carStatisticPanel.update();
        dealerStatisticPanel.update();
    }
}
