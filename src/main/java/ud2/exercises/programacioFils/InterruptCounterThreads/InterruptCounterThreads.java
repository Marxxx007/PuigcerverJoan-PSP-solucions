package ud2.exercises.programacioFils.InterruptCounterThreads;

public class InterruptCounterThreads {

  public static void main(String[] args) {

    int contadorHilo4 = 0 ;

    // Crear hilos con las configuraciones especificadas
    InfiniteCounterThread thread1 = new InfiniteCounterThread(1, 1000, 10);   // Hilo 1: empieza en 1, delay 1s, hasta 10
    InfiniteCounterThread thread2 = new InfiniteCounterThread(10, 100, 50);   // Hilo 2: empieza en 10, delay 0.1s, hasta 50
    InfiniteCounterThread thread3 = new InfiniteCounterThread(25, 400, Integer.MAX_VALUE); // Hilo 3: empieza en 25, delay 0.4s, hasta 3s
    InfiniteCounterThread thread4 = new InfiniteCounterThread(1, 1300, Integer.MAX_VALUE); // Hilo 4: empieza en 1, delay 1.3s

    // Iniciar los hilos
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    // Comprobar las condiciones de interrupción y realizar las interrupciones
    try {
      // Control para el hilo 1 (cuando llegue a 10)
      while (thread1.isAlive()) {

        if (thread1.getCounter() >= 10) {
          thread1.interrupt();
          contadorHilo4 = thread4.getCounter();
        }

        Thread.sleep(500);//para dar tiempo a que los hilos realicen sus contadores antes de que se les interrumpa
      }

      // Control para el hilo 2 (cuando llegue a 50)
      while (thread2.isAlive()) {
        if (thread2.getCounter() >= 50) {
          thread2.interrupt();
          //System.out.printf("%s interromput: %d\n", thread1.getName(), thread1.getCounter());
        }
        Thread.sleep(500);
      }

      // Control para el hilo 3 (cuando han pasado 3 segundos)
      long startTime = System.currentTimeMillis();
      while (System.currentTimeMillis() - startTime < 3000) {
        thread3.interrupt();
        //System.out.printf("%s interromput: %d\n", thread1.getName(), thread1.getCounter());

      }
      Thread.sleep(500);


      // Control para el hilo 4 (cuando el hilo 4 haya contado 10 números desde la interrrupcion del hilo1)

      if ((!thread1.isAlive() && thread4.getCounter() == contadorHilo4 + 10 )) {
        thread4.interrupt();
        //System.out.printf("%s interromput: %d\n", thread1.getName(), thread1.getCounter());
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
