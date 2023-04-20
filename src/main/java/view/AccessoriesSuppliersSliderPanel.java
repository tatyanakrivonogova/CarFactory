package view;

import suppliers.Suppliers;

import javax.swing.*;
import java.util.Hashtable;

public class AccessoriesSuppliersSliderPanel extends JPanel {
    public AccessoriesSuppliersSliderPanel(Suppliers suppliers) {
        super();
        JSlider slider = new JSlider(0, 30, 0);
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

        JLabel status = new JLabel("Delay of accessories suppliers: 1", JLabel.CENTER);
        slider.addChangeListener(e -> {
            status.setText("Delay of accessories suppliers: " + ((JSlider)e.getSource()).getValue());
            suppliers.setDelay(((JSlider)e.getSource()).getValue() * 1000);
        });

        this.add(status);
        this.add(slider);
    }
}
