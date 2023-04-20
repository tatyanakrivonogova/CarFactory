package factories;

public class FactoriesCreator {
    private final BodyFactory bodyFactory = new BodyFactory();
    private final EngineFactory engineFactory = new EngineFactory();
    private final AccessoriesFactory accessoriesFactory = new AccessoriesFactory();

    public BodyFactory getBodyFactory() {
        return bodyFactory;
    }
    public EngineFactory getEngineFactory() {
        return engineFactory;
    }
    public AccessoriesFactory getAccessoriesFactory() {
        return accessoriesFactory;
    }
}
