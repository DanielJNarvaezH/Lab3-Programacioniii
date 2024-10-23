package co.edu.uniquindio.poo.model.Ejercicio2;

public class App {
    public static void main(String[] args) {
        CuentaRegresiva cuenta = new CuentaRegresiva();
        //Se instancia el hilo principal, usando una expresión lambda :: que hace posible el uso de interfaces funcionales como Runnable
        Thread hiloCuenta = new Thread(cuenta::iniciarCuentaRegresiva);

        // Hilos que se encuentran dormidos hasta que la cuenta regresiva llege a 0
        Thread hilo1 = new Thread(cuenta::esperarCuentaRegresiva, "Hilo 1");
        Thread hilo2 = new Thread(cuenta::esperarCuentaRegresiva, "Hilo 2");
        Thread hilo3 = new Thread(cuenta::esperarCuentaRegresiva, "Hilo 3");

        // Iniciar todos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hiloCuenta.start();

        // Esperar a que terminen todos los hilos
        try {
            hiloCuenta.join();
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
