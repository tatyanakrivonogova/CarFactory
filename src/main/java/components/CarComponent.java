package components;

public class CarComponent implements Component {
    private final int id;
    CarComponent(int _id) {
        this.id = _id;
    }
    @Override
    public int getId() {
        return id;
    }
}
