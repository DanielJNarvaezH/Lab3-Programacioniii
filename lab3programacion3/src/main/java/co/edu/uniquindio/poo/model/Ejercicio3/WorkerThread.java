package co.edu.uniquindio.poo.model.Ejercicio3;

public class WorkerThread extends Thread{
    
    private ConditionMonitor monitor;

    public WorkerThread(ConditionMonitor monitor, String name) {
        super(name);
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            monitor.waitForCondition();  // Los hilos esperan aquí
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
