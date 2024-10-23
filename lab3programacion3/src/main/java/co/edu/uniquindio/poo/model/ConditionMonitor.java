package co.edu.uniquindio.poo.model;

public class ConditionMonitor {
    
    private int condition = 0;
    private boolean notified = false;

    // Método para que los hilos esperen hasta que la condición sea múltiplo de 5
    public synchronized void waitForCondition() throws InterruptedException {
        while (!notified) {
            wait();  // Espera hasta que se notifique
        }
        System.out.println(Thread.currentThread().getName() + " continúa con el valor de la condición: " + condition);
        notified = false;  // Restablece el estado para que otros hilos puedan esperar
    }

    // Método para que el hilo principal establezca la condición
    public synchronized void setCondition(int value) {
        condition = value;
        if (condition % 5 == 0) {
            notified = true;
            notifyAll();  // Notifica a todos los hilos cuando se cumple la condición
        }
    }

}
