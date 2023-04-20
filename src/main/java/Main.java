import components.Body;
import components.Engine;
import configuration.Configuration;
import controller.Controller;
import dealers.Dealers;
import factories.FactoriesCreator;
import storage.CommonStorage;
import suppliers.AccessoriesSuppliers;
import suppliers.Supplier;
import view.GUI;
import workers.Workers;

import java.io.IOException;

public class Main {
    public static void main() {
        Configuration configuration;
        try {
            configuration = new Configuration("config.properties");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        FactoriesCreator factoriesCreator = new FactoriesCreator();
        CommonStorage commonStorage = new CommonStorage(configuration);
        Controller controller = new Controller();

        Supplier<Body> bodySupplier = new Supplier<>(factoriesCreator.getBodyFactory(), commonStorage.getBodyStorage(), configuration.getStartDelay(), controller.getBodyController());
        Supplier<Engine> engineSupplier = new Supplier<>(factoriesCreator.getEngineFactory(), commonStorage.getEngineStorage(), configuration.getStartDelay(), controller.getEngineController());
        AccessoriesSuppliers accessoriesSuppliers = new AccessoriesSuppliers(configuration.getSuppliersNumber(), commonStorage, factoriesCreator.getAccessoriesFactory(), controller.getAccessoriesController());

        Workers workers = new Workers(configuration.getWorkersNumber(), commonStorage, controller.getReadyCarController());
        Dealers dealers = new Dealers(configuration.getDealersNumber(), commonStorage, controller.getSoldCarController());

        GUI gui = new GUI(bodySupplier, engineSupplier, accessoriesSuppliers, dealers);
    }
}
