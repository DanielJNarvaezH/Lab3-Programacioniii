package co.edu.uniquindio.poo.model.Ejercicio4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); // Cola sincronizada con tamaño máximo de 10, esta permite que los productores esperen si la cola se encuentra llena y los consumidores esperan si esta está vacía
        int numeroElementos = 20;//Cantidad de elementos a generar por cada hilo productor

        // Crear productores
        Thread productor1 = new Thread(new Productor(queue, numeroElementos), "Productor_1");
        Thread productor2 = new Thread(new Productor(queue, numeroElementos), "Productor_2");

        // Crear consumidores
        Thread consumidor1 = new Thread(new Consumidor(queue), "Consumidor_1");
        Thread consumidor2 = new Thread(new Consumidor(queue), "Consumidor_2");

        productor1.start();
        productor2.start();
        consumidor1.start();
        consumidor2.start();
    }
}

