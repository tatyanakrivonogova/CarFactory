package view;

import dealers.Dealers;

import javax.swing.*;

public class DealersSliderPanel extends JPanel {
    public DealersSliderPanel(Dealers dealers, int startDelay) {
        super();
        JSlider slider = new JSlider(0, 5000, startDelay);
        slider.setMajorTickSpacing(1000);
        slider.setMinorTickSpacing(500);
        slider.setPaintTicks(true);

        JLabel status = new JLabel("Delay of dealers: " + startDelay + " ms", JLabel.CENTER);
        slider.addChangeListener(e -> {
            status.setText("Delay of dealers: " + ((JSlider)e.getSource()).getValue() + " ms");
            dealers.setDelay(((JSlider)e.getSource()).getValue());
        });

        this.add(status);
        this.add(slider);
    }
}
