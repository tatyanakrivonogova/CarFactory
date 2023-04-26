package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Configuration {
    private final String configFile;
    private int startDelay;
    private int bodyStorageCapacity;
    private int engineStorageCapacity;
    private int accessoriesStorageCapacity;
    private int carStorageCapacity;
    private int suppliersNumber;
    private int dealersNumber;
    private int workersNumber;
    private boolean logStatus;

    public Configuration(String _configFile) throws IOException {
        configFile = _configFile;
        readConfig();
    }
    private void readConfig() throws IOException {
        InputStream input = Configuration.class.getClassLoader().getResourceAsStream(configFile);
        Properties properties = new Properties();
        properties.load(input);


        startDelay = Integer.parseInt(properties.getProperty("start_delay"));
        bodyStorageCapacity = Integer.parseInt(properties.getProperty("body_capacity"));
        engineStorageCapacity = Integer.parseInt(properties.getProperty("engine_capacity"));
        accessoriesStorageCapacity = Integer.parseInt(properties.getProperty("accessories_capacity"));
        carStorageCapacity = Integer.parseInt(properties.getProperty("car_capacity"));

        suppliersNumber = Integer.parseInt(properties.getProperty("suppliers"));
        dealersNumber = Integer.parseInt(properties.getProperty("dealers"));
        workersNumber = Integer.parseInt(properties.getProperty("workers"));
        logStatus = Boolean.parseBoolean(properties.getProperty("log"));
    }

    public int getStartDelay() { return startDelay; }
    public int getBodyStorageCapacity() { return bodyStorageCapacity; }
    public int getEngineStorageCapacity() {
        return engineStorageCapacity;
    }
    public int getAccessoriesStorageCapacity() {
        return accessoriesStorageCapacity;
    }
    public int getCarStorageCapacity() {
        return carStorageCapacity;
    }
    public int getSuppliersNumber() {
        return suppliersNumber;
    }
    public int getDealersNumber() {
        return dealersNumber;
    }
    public int getWorkersNumber() {
        return workersNumber;
    }
    public boolean getLogStatus() { return logStatus; }
}