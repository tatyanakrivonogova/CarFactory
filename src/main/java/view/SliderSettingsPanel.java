package view;

import components.Body;
import components.Engine;
import dealers.Dealers;
import suppliers.AccessoriesSuppliers;
import suppliers.Supplier;
import workers.Workers;

import javax.swing.*;
import java.awt.*;

public class SliderSettingsPanel extends JPanel {
    public SliderSettingsPanel(Supplier<Body> bodySupplier, Supplier<Engine> engineSupplier, AccessoriesSuppliers accessoriesSuppliers, Dealers dealers, Workers workers, int startDelay) {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridLayout(5, 0, 15, 15));
        JPanel bodySupplierPanel = new SupplierSliderPanel<>("Body supplier", bodySupplier, startDelay);
        JPanel engineSupplierPanel = new SupplierSliderPanel<>("Engine supplier", engineSupplier, startDelay);
        JPanel accessoriesSuppliersPanel = new AccessoriesSuppliersSliderPanel(accessoriesSuppliers, startDelay);
        JPanel dealersPanel = new DealersSliderPanel(dealers, startDelay);
        JPanel workersPanel = new WorkersSliderPanel(workers, startDelay);

        bodySupplierPanel.setBackground(Color.PINK);
        engineSupplierPanel.setBackground(Color.BLUE);
        accessoriesSuppliersPanel.setBackground(Color.ORANGE);
        dealersPanel.setBackground(Color.GREEN);
        workersPanel.setBackground(Color.CYAN);

        this.add(bodySupplierPanel);
        this.add(engineSupplierPanel);
        this.add(accessoriesSuppliersPanel);
        this.add(dealersPanel);
        this.add(workersPanel);
    }
}