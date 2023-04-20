package view;

import components.Engine;
import dealers.Dealers;
import suppliers.Supplier;
import components.Body;
import suppliers.Suppliers;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    final int WINDOW_WIDTH = 400;
    final int WINDOW_HEIGHT = 450;
    final int START_LOCATION = 180;

    public GUI(Supplier<Body> bodySupplier, Supplier<Engine> engineSupplier, Suppliers accessoriesSuppliers, Dealers dealers) {
        super();

        setTitle("Car factory settings");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        this.setFocusable(true);
        getContentPane().setBackground(Color.BLACK);

        SliderSettingsPanel settingsPanel = new SliderSettingsPanel(bodySupplier, engineSupplier, accessoriesSuppliers, dealers);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(settingsPanel);

        pack();
        setVisible(true);
    }
}