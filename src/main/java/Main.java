import components.Body;
import components.Engine;
import configuration.Configuration;
import controller.Controller;
import dealers.Dealers;
import factories.FactoriesCreator;
import org.apache.log4j.Logger;
import storage.CommonStorage;
import suppliers.AccessoriesSuppliers;
import suppliers.Supplier;
import threads.*;
import threads.threadpools.AccessoriesSuppliersRequests;
import threads.threadpools.DealersRequests;
import threads.threadpools.ThreadPool;
import threads.threadpools.WorkersRequests;
import view.GUI;
import workers.Workers;

import java.io.IOException;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
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

        Supplier<Body> bodySupplier = new Supplier<>(factoriesCreator.getBodyFactory(), commonStorage.getBodyStorage(), 5000, controller.getBodyController());
        Supplier<Engine> engineSupplier = new Supplier<>(factoriesCreator.getEngineFactory(), commonStorage.getEngineStorage(), 5000, controller.getEngineController());
        AccessoriesSuppliers accessoriesSuppliers = new AccessoriesSuppliers(configuration.getSuppliersNumber(), commonStorage, factoriesCreator.getAccessoriesFactory(), controller.getAccessoriesController());

        Workers workers = new Workers(configuration.getWorkersNumber(), commonStorage, controller.getReadyCarController());
        Dealers dealers = new Dealers(configuration.getDealersNumber(), commonStorage, controller.getSoldCarController(), logger);

        ThreadsController threadsController = new ThreadsController();

        GUI gui = new GUI(commonStorage, controller, bodySupplier, engineSupplier, accessoriesSuppliers, dealers, threadsController);
        gui.setVisible(true);

        WorkersRequests workersRequests = new WorkersRequests(workers);
        ThreadPool workersPool = new ThreadPool("workers", configuration.getWorkersNumber());
        for (Task request : workersRequests.getWorkersRequests()) {
            workersPool.addRequest(request);
        }

        BodySupplierRequests bodySupplierRequests = new BodySupplierRequests(bodySupplier);
        ThreadPool bodySuppliersPool = new ThreadPool("body supplier", 1);
        for (Task request : bodySupplierRequests.getBodySupplierRequests()) {
            bodySuppliersPool.addRequest(request);
        }

        EngineSupplierRequests engineSupplierRequests = new EngineSupplierRequests(engineSupplier);
        ThreadPool engineSuppliersPool = new ThreadPool("engine supplier", 1);
        for (Task request : engineSupplierRequests.getEngineSupplierRequests()) {
            engineSuppliersPool.addRequest(request);
        }


        AccessoriesSuppliersRequests accessoriesSuppliersRequests = new AccessoriesSuppliersRequests(accessoriesSuppliers);
        ThreadPool accessoriesSuppliersPool = new ThreadPool("accessories supplier", configuration.getSuppliersNumber());
        for (Task request : accessoriesSuppliersRequests.getAccessoriesSuppliersRequests()) {
            accessoriesSuppliersPool.addRequest(request);
        }

        DealersRequests dealersRequests = new DealersRequests(dealers);
        ThreadPool dealersPool = new ThreadPool("dealers", configuration.getDealersNumber());
        for (Task request : dealersRequests.getDealersRequests()) {
            dealersPool.addRequest(request);
        }

        threadsController.setPools(workersPool, bodySuppliersPool, engineSuppliersPool, accessoriesSuppliersPool, dealersPool);
    }
}
