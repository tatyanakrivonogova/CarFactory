package view;

import components.Body;
import components.Engine;
import dealers.Dealers;
import suppliers.Supplier;
import suppliers.Suppliers;

import javax.swing.*;

public class SliderSettingsPanel extends JPanel {
    public SliderSettingsPanel(Supplier<Body> bodySupplier, Supplier<Engine> engineSupplier, Suppliers accessoriesSuppliers, Dealers dealers) {
        super();
        JPanel bodySupplierPanel = new SupplierSliderPanel<>("Body supplier", bodySupplier);
        JPanel motorSupplierPanel = new SupplierSliderPanel<>("Engine supplier", engineSupplier);
        JPanel accessoriesSuppliersPanel = new AccessoriesSuppliersSliderPanel(accessoriesSuppliers);
        JPanel dealerPanel = new DealersSliderPanel(dealers);

        this.add(bodySupplierPanel);
        this.add(motorSupplierPanel);
        this.add(accessoriesSuppliersPanel);
        this.add(dealerPanel);
    }
}