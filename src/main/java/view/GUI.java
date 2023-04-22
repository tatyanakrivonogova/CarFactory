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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI extends JFrame {
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 500;
    final int START_LOCATION = 180;

    public GUI(CommonStorage commonStorage, Controller controller, Supplier<Body> bodySupplier, Supplier<Engine> engineSupplier, AccessoriesSuppliers accessoriesSuppliers, Dealers dealers) {
        super();

        setTitle("Car factory settings");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        this.setFocusable(true);
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setForeground(Color.BLACK);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            public void windowClosing(WindowEvent event) {
                for (Frame frame : getFrames()) frame.dispose();
                dispose();
            }
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        SliderSettingsPanel settingsPanel = new SliderSettingsPanel(bodySupplier, engineSupplier, accessoriesSuppliers, dealers);

        StatisticPanel statisticPanel = new StatisticPanel(commonStorage, controller);
        commonStorage.addSubscriber(statisticPanel);
        controller.addSubscriber(statisticPanel);


        GridLayout layout = new GridLayout(0, 2, 0, 20);
        this.setLayout(layout);
        getContentPane().add(statisticPanel);
        getContentPane().add(settingsPanel);

        pack();
        setVisible(true);
    }
}