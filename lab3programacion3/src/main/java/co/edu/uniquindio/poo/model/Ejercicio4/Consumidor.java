package co.edu.uniquindio.poo.model.Ejercicio4;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {
    private final BlockingQueue<Integer> queue;//Cola sincronizada

    public Consumidor(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take(); // Extrae el número a procesar de la cola
                if (number == -1) {
                    queue.put(-1); // Se coloca otra vez la señal de terminación para otros consumidores
                    break; // Sale del ciclo si encuentra el -1
                }
                System.out.println(Thread.currentThread().getName() + " procesó: " + number);
                Thread.sleep(1000); // Simula el tiempo de procesamiento
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
