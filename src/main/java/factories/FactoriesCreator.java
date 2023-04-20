package factories;

public class FactoriesCreator {
    private final BodyFactory bodyFactory;
    private final EngineFactory engineFactory;
    private final AccessoriesFactory accessoriesFactory;
    public FactoriesCreator() {
        bodyFactory = new BodyFactory();
        engineFactory = new EngineFactory();
        accessoriesFactory = new AccessoriesFactory();
    }

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
