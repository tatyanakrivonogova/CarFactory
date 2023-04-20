package view;

import components.CarComponent;
import suppliers.Supplier;

import javax.swing.*;
import java.util.Hashtable;

public class SupplierSliderPanel<T extends CarComponent> extends JPanel {
    public SupplierSliderPanel(String type, Supplier<T> supplier) {
        super();
        JSlider slider = new JSlider(0, 30, 1);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);


        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(5, new JLabel("5"));
        position.put(10, new JLabel("10"));
        position.put(15, new JLabel("15"));
        position.put(20, new JLabel("20"));
        position.put(25, new JLabel("25"));
        position.put(30, new JLabel("30"));
        slider.setLabelTable(position);

        JLabel status = new JLabel("Delay of " + type + " : 1", JLabel.CENTER);
        slider.addChangeListener(e -> {
            status.setText("Delay of " + type + " : " + ((JSlider)e.getSource()).getValue());
            supplier.setDelay(((JSlider)e.getSource()).getValue() * 1000);
        });

        this.add(status);
        this.add(slider);
    }
}
