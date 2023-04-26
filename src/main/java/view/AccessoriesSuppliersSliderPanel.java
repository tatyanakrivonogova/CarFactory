package view;

import suppliers.AccessoriesSuppliers;

import javax.swing.*;

public class AccessoriesSuppliersSliderPanel extends JPanel {
    public AccessoriesSuppliersSliderPanel(AccessoriesSuppliers suppliers, int startDelay) {
        super();
        JSlider slider = new JSlider(0, 5000, startDelay);
        slider.setMajorTickSpacing(1000);
        slider.setMinorTickSpacing(500);
        slider.setPaintTicks(true);

        JLabel status = new JLabel("Delay of accessories suppliers: " + startDelay + " ms", JLabel.CENTER);
        slider.addChangeListener(e -> {
            status.setText("Delay of accessories suppliers: " + ((JSlider)e.getSource()).getValue() + " ms");
            suppliers.setDelay(((JSlider)e.getSource()).getValue());
        });

        this.add(status);
        this.add(slider);
    }
}
