package co.edu.uniquindio.poo.model.Ejercicio1;


import java.util.concurrent.TimeUnit;
import java.util.Random;


class DownloadTask implements Runnable {
    private String url;

    public DownloadTask(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        System.out.println("Iniciando descarga desde: " + url);
        try {
            int downloadTime = new Random().nextInt(26) + 5;
            TimeUnit.SECONDS.sleep(downloadTime);
            System.out.println("Descarga completada desde: " + url + " en " + downloadTime + " segundos");
        } catch (InterruptedException e) {
            System.err.println("Error en la descarga desde: " + url);
            Thread.currentThread().interrupt();
        }
    }
}
