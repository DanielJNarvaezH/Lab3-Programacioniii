package co.edu.uniquindio.poo.model;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ConditionMonitor monitor = new ConditionMonitor();
        Random random = new Random();

        // Crear y lanzar los tres hilos secundarios
        WorkerThread thread1 = new WorkerThread(monitor, "Hilo 1");
        WorkerThread thread2 = new WorkerThread(monitor, "Hilo 2");
        WorkerThread thread3 = new WorkerThread(monitor, "Hilo 3");

        thread1.start();
        thread2.start();
        thread3.start();

        // Hilo principal genera números aleatorios y los envía al monitor
        while (true) {
            int number = random.nextInt(100) + 1;
            System.out.println("Hilo principal genera: " + number);
            monitor.setCondition(number);

            // Si los tres hilos han sido notificados al menos una vez, terminamos
            if (!thread1.isAlive() && !thread2.isAlive() && !thread3.isAlive()) {
                break;
            }

            try {
                Thread.sleep(1000);  // Pausa para simular tiempo entre las generaciones de números
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
