package view;

import components.Body;
import components.Engine;
import dealers.Dealers;
import suppliers.AccessoriesSuppliers;
import suppliers.Supplier;

import javax.swing.*;
import java.awt.*;

public class SliderSettingsPanel extends JPanel {
    public SliderSettingsPanel(Supplier<Body> bodySupplier, Supplier<Engine> engineSupplier, AccessoriesSuppliers accessoriesSuppliers, Dealers dealers) {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridLayout(5, 0, 15, 15));
        JPanel bodySupplierPanel = new SupplierSliderPanel<>("Body supplier", bodySupplier);
        JPanel engineSupplierPanel = new SupplierSliderPanel<>("Engine supplier", engineSupplier);
        JPanel accessoriesSuppliersPanel = new AccessoriesSuppliersSliderPanel(accessoriesSuppliers);
        JPanel dealerPanel = new DealersSliderPanel(dealers);

        bodySupplierPanel.setBackground(Color.PINK);
        engineSupplierPanel.setBackground(Color.BLUE);
        accessoriesSuppliersPanel.setBackground(Color.ORANGE);
        dealerPanel.setBackground(Color.GREEN);

        this.add(bodySupplierPanel);
        this.add(engineSupplierPanel);
        this.add(accessoriesSuppliersPanel);
        this.add(dealerPanel);
    }
}