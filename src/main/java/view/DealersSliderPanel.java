package view;

import dealers.Dealers;

import javax.swing.*;
import java.util.Hashtable;

public class DealersSliderPanel extends JPanel {
    public DealersSliderPanel(Dealers dealers) {
        super();
        JSlider slider = new JSlider(0, 30, 0);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);

        JLabel status = new JLabel("Delay of dealers: 1", JLabel.CENTER);
        slider.addChangeListener(e -> {
            status.setText("Delay of dealers: " + ((JSlider)e.getSource()).getValue());
            dealers.setDelay(((JSlider)e.getSource()).getValue() * 1000);
        });

        this.add(status);
        this.add(slider);
    }
}
