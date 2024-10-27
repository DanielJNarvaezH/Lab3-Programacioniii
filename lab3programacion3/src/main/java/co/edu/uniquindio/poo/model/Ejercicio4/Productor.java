package co.edu.uniquindio.poo.model.Ejercicio4;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable {
    private final BlockingQueue<Integer> colaCompartida;//Cola sincronizada 
    private final int numeroElementos;
    private final Random random = new Random();

    public Productor(BlockingQueue<Integer> colaCompartida, int numeroElementos) {
        this.colaCompartida = colaCompartida;
        this.numeroElementos = numeroElementos;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numeroElementos; i++) {
                int numeroAleatorio = random.nextInt(100) + 1;//Genera un numero aleatorio en el rango de 1 a 100
                colaCompartida.put(numeroAleatorio); // Agrega el número a la cola compartida
                System.out.println(Thread.currentThread().getName() + " produjo: " + numeroAleatorio);
                Thread.sleep(500); // Simula el tiempo de producción
            }
            colaCompartida.put(-1); // Se agrega el -1 como elemento para que los consumidores identifiquen cuando terminar
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

