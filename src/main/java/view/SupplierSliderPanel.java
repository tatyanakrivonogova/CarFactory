package view;

import components.CarComponent;
import suppliers.Supplier;

import javax.swing.*;

public class SupplierSliderPanel<T extends CarComponent> extends JPanel {
    public SupplierSliderPanel(String type, Supplier<T> supplier, int startDelay) {
        super();
        JSlider slider = new JSlider(0, 5000, startDelay);
        slider.setMajorTickSpacing(1000);
        slider.setMinorTickSpacing(500);
        slider.setPaintTicks(true);

        JLabel status = new JLabel("Delay of " + type + " : " + startDelay + " ms", JLabel.CENTER);
        slider.addChangeListener(e -> {
            status.setText("Delay of " + type + " : " + ((JSlider)e.getSource()).getValue() + " ms");
            supplier.setDelay(((JSlider)e.getSource()).getValue());
        });

        this.add(status);
        this.add(slider);
    }
}
