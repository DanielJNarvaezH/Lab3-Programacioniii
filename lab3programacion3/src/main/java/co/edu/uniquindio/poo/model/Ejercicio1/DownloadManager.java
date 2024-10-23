package co.edu.uniquindio.poo.model.Ejercicio1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DownloadManager {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);  // 10 hilos fijos
        //ExecutorService executor = Executors.newCachedThreadPool();    // Pool de hilos que crece dinámicamente
        //ExecutorService executor = Executors.newSingleThreadExecutor();  // Un solo hilo

        for (int i = 1; i <= 50; i++) {
            String url = "http://example.com/file" + i;
            DownloadTask task = new DownloadTask(url);
            executor.submit(task);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Algunas descargas no se completaron a tiempo.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}