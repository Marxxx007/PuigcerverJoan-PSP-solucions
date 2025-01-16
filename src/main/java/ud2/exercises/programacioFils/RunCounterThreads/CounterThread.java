package ud2.exercises.programacioFils.RunCounterThreads;

// Clase CounterThread que representa el hilo que contará en un rango dado con un retardo específico
class CounterThread extends Thread {
  private int start;        // Valor inicial del contador
  private int end;          // Valor final del contador
  private int delay;        // Retardo entre cada incremento en milisegundos

  public CounterThread(int start, int end, int delay) {
    this.start = start;
    this.end = end;
    this.delay = delay;
  }

  @Override
  public void run() {
    // El hilo cuenta desde el valor start hasta el valor end
    for (int counter = start; counter <= end; counter++) {
      System.out.printf("%s: %d\n", Thread.currentThread().getName(), counter);
      try {
        Thread.sleep(delay); // Dormir el hilo por el tiempo especificado en 'delay'
      } catch (InterruptedException e) {
        System.out.println("El hilo fue interrumpido");
      }
    }
  }
}
