package factories;

import components.CarComponent;

public interface ComponentFactory<T extends CarComponent> {
    T createComponent();
}
