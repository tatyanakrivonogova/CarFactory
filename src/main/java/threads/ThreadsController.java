package threads;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import threads.threadpools.ThreadPool;

import java.util.ArrayList;

public class ThreadsController {
    ArrayList<ThreadPool> pools;
    Logger logger;
    public ThreadsController(Logger _logger) { logger = _logger; }

    public void setPools(ThreadPool workersPool, ThreadPool bodySuppliersPool, ThreadPool engineSuppliersPool,
                         ThreadPool accessoriesSuppliersPool, ThreadPool dealersPool) {
        pools = new ArrayList<>();
        pools.add(workersPool);
        pools.add(bodySuppliersPool);
        pools.add(engineSuppliersPool);
        pools.add(accessoriesSuppliersPool);
        pools.add(dealersPool);
    }
    public void stopPools() {
        if (pools == null) return;
        for (ThreadPool t : pools) {
            t.shutdown();
        }
        logger.log(Level.INFO, "Production is finished");
    }
}
