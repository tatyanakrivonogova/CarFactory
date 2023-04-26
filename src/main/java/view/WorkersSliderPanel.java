package view;

import workers.Workers;

import javax.swing.*;

public class WorkersSliderPanel extends JPanel {
    public WorkersSliderPanel(Workers workers, int startDelay) {
        super();
        JSlider slider = new JSlider(0, 5000, startDelay);
        slider.setMajorTickSpacing(1000);
        slider.setMinorTickSpacing(500);
        slider.setPaintTicks(true);

        JLabel status = new JLabel("Delay of workers: " + startDelay + " ms", JLabel.CENTER);
        slider.addChangeListener(e -> {
            status.setText("Delay of workers: " + ((JSlider)e.getSource()).getValue() + " ms");
            workers.setDelay(((JSlider)e.getSource()).getValue());
        });

        this.add(status);
        this.add(slider);
    }
}
