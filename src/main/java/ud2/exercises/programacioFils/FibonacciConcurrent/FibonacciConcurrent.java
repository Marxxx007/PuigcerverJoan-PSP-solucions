package ud2.exercises.programacioFils.FibonacciConcurrent;

import java.util.Scanner;

public class FibonacciConcurrent {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Introdueix els nombres a calcular:");

    int counter = 1; // Contador para el nombre del hilo (FIL1, FIL2, ...)
    while (true) {
      long n = scanner.nextLong();

      if (n == 0) {
        break;  // Si se introduce 0, terminamos el ciclo
      }

      // Crear y lanzar un hilo para calcular Fibonacci
      FibonacciThread fibonacciThread = new FibonacciThread("FIL" + counter, n);
      fibonacciThread.start();
      counter++; // Incrementamos el contador para el siguiente hilo
    }

    scanner.close();  // Cerramos el scanner cuando ya no se necesita
  }
}