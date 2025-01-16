package ud2.exercises.programacioFils.RunCounterThreads;

public class RunCounterThreads {

  public static void main(String[] args) {
    // Crear instancias de CounterThread con los valores especificados
    CounterThread thread1 = new CounterThread(1, 10, 1000);   // Hilo 1: empieza en 1, hasta 10, delay 1s
    CounterThread thread2 = new CounterThread(10, 100, 100);   // Hilo 2: empieza en 10, hasta 100, delay 0.1s
    CounterThread thread3 = new CounterThread(25, 50, 400);    // Hilo 3: empieza en 25, hasta 50, delay 0.4s
    CounterThread thread4 = new CounterThread(1, 5, 1300);     // Hilo 4: empieza en 1, hasta 5, delay 1.3s

    // Iniciar los hilos
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    try {
      // Esperamos a que todos los hilos terminen su ejecución antes de terminar el programa principal
      thread1.join();
      thread2.join();
      thread3.join();
      thread4.join();
    } catch (InterruptedException e) {
      System.out.println("El hilo principal fue interrumpido");
    }

    System.out.println("Todos los hilos han terminado.");
  }
}