package view;

import components.Engine;
import controller.Controller;
import dealers.Dealers;
import storage.CommonStorage;
import suppliers.AccessoriesSuppliers;
import suppliers.Supplier;
import components.Body;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    final int WINDOW_WIDTH = 400;
    final int WINDOW_HEIGHT = 500;
    final int START_LOCATION = 180;

    public GUI(CommonStorage commonStorage, Controller controller, Supplier<Body> bodySupplier, Supplier<Engine> engineSupplier, AccessoriesSuppliers accessoriesSuppliers, Dealers dealers) {
        super();

        setTitle("Car factory settings");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        this.setFocusable(true);
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setForeground(Color.BLACK);

        SliderSettingsPanel settingsPanel = new SliderSettingsPanel(bodySupplier, engineSupplier, accessoriesSuppliers, dealers);

        StatisticPanel statisticPanel = new StatisticPanel(commonStorage, controller);
        commonStorage.addSubscriber(statisticPanel);
        controller.addSubscriber(statisticPanel);


        //this.setLayout(new GridBagLayout());
        this.setLayout(new GridLayout(5, 2, 20, 20));
        getContentPane().add(settingsPanel);
        getContentPane().add(statisticPanel);

        pack();
        setVisible(true);
    }
}