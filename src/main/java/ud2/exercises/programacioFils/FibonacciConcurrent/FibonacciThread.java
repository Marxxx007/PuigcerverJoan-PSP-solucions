package ud2.exercises.programacioFils.FibonacciConcurrent;

import java.util.Scanner;

class FibonacciThread extends Thread {
  private long n;  // Número de términos de Fibonacci a calcular
  private String threadName;  // Nombre del hilo (FIL1, FIL2, etc.)

  public FibonacciThread(String threadName, long n) {
    this.threadName = threadName;
    this.n = n;
  }

  @Override
  public void run() {
    // Calculamos y mostramos los primeros N números de la secuencia Fibonacci
    long a = 0, b = 1;
    for (long i = 1; i <= n; i++) {
      // Muestra el paso actual de la secuencia
      System.out.printf("%s: Pas %d de %d: %d\n", threadName, i, n, a);
      // Calculamos el siguiente número de Fibonacci
      long next = a + b;
      a = b;
      b = next;
      try {
        Thread.sleep(500); // Retardo de 0.5 segundos entre cada paso (simulando trabajo)
      } catch (InterruptedException e) {
        System.out.println(threadName + " fue interrumpido.");
      }
    }
  }
}