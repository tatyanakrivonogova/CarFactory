package view;

import controller.ComponentController;
import pubsub.Subscriber;
import storage.ComponentStorage;
import storage.Storage;

import javax.swing.*;

public class ComponentStatisticPanel extends JPanel implements Subscriber {
    private final String name;
    private final JLabel storageSize;
    private final JLabel readyComponentsNumber;
    private final Storage<?> storage;
    private final ComponentController<?> controller;

    public ComponentStatisticPanel(String name, ComponentStorage<?> _storage, ComponentController<?> _controller) {
        super();
        this.name = name;
        storageSize = new JLabel(name + " storage size: 0  ");
        readyComponentsNumber = new JLabel(name + " ready components number: 0");
        storage = _storage;
        controller = _controller;
        this.add(storageSize);
        this.add(readyComponentsNumber);

        _storage.addSubscriber(this);
    }
    @Override
    public void update() {
        storageSize.setText(name + " storage size: " + storage.getSizeUsed() + "  ");
        readyComponentsNumber.setText(name + " ready components number: " + controller.getComponentsNumber());
    }
}
