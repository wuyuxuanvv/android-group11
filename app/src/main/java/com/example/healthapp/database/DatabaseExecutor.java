package com.example.healthapp.database;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** One shared executor for all Room work. Never run DAO methods on the UI thread. */
public final class DatabaseExecutor {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);

    private DatabaseExecutor() {
    }

    public static void execute(Runnable task) {
        EXECUTOR.execute(task);
    }
}
