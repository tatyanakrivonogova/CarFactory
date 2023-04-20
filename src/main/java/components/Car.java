package components;

public class Car extends CarComponent {
    Body body;
    Engine engine;
    Accessories accessories;
    public Car(int _id, Body _body, Engine _engine, Accessories _accessories) {
        super(_id);
        body = _body;
        engine = _engine;
        accessories = _accessories;
    }
}
