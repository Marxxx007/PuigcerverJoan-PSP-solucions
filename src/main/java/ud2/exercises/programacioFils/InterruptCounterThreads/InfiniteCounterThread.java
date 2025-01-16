package ud2.exercises.programacioFils.InterruptCounterThreads;

class InfiniteCounterThread extends Thread {


  private int counter;     // Contador que incrementará indefinidamente
  private int delay;       // Retardo entre cada incremento en milisegundos
  private int startValue;  // Valor inicial del contador
  private int stopValue;   // Valor límite para la interrupción (dependiendo del hilo)

  public int getCounter() {
    return counter;
  }
  public InfiniteCounterThread(int startValue, int delay, int stopValue) {
    this.startValue = startValue;
    this.counter = startValue;
    this.delay = delay;
    this.stopValue = stopValue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        // Imprimir el nombre del hilo y el contador actual
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), counter);
        counter++;

        // Comprobar si se debe interrumpir
        if (counter >= stopValue) {
          break;
        }

        // Dormir el hilo durante el retardo especificado
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        // Si el hilo es interrumpido, mostrar el mensaje y terminar
        System.out.printf("%s interromput: %d\n", Thread.currentThread().getName(), counter);
        break;
      }
    }
  }
}