package co.edu.uniquindio.poo.model.Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CuentaRegresiva {
    private final ReentrantLock bloqueo = new ReentrantLock();
    //ReentrantLock es un mecanismo de bloqueo para recursos compartidos, es similar al synchronized. 
    private final Condition condicion = bloqueo.newCondition();
    //El condition es un recurso utilizado en la sincronización de hilos, de modo que define cuando se debe notificar o esperar
    private int contador = 10;

    // Método para ejecutar la cuenta regresiva del hilo principal
    public void iniciarCuentaRegresiva() {
        bloqueo.lock();//Se activa el bloqueo
        try {
            while (contador > 0) {
                System.out.println("Cuenta regresiva: " + contador);
                contador--;
                Thread.sleep(1000);  // Simula un retraso de 1 segundo
            }
            System.out.println("Cuenta regresiva Terminada");
            condicion.signalAll();  // Notifica a todos los hilos que estaban en espera
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            bloqueo.unlock();//Se desactiva el bloqueo
        }
    }

    // Método que espera a que el contador llegue a 0
    public void esperarCuentaRegresiva() {
        bloqueo.lock();//Se activa el bloqueo
        try {
            while (contador > 0) {
                System.out.println(Thread.currentThread().getName() + " esperando...");
                condicion.await();  // Espera hasta que el contador llegue a 0, es decir hasta que el condition se cumpla
            }
            System.out.println(Thread.currentThread().getName() + " inicio ejecución");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            bloqueo.unlock();//Se desactiva el bloqueo
        }
    }

}
