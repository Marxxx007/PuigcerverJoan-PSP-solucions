package ud1.examples;

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {
    public static void main (String[] args) {
        // Indica la comanda que utilitza aquest programa per iniciar un nou procés
        //String[] program = {"notepad"};

        //String[] program = {"notepad"};//
        // El programa RunProcess executa la comanda notepad, que crea un process amb l'editor de notes del sistema. Després, espera a que acaba i retorna el codi 0: èxit.
        String[] program = {"powershell", "sleep", "5"};//
        // El programa RunProcess executa la comanda sleep 5 en la línia de comandes Powershell. Aquest procés esperarà 5 segons i acabarà amb el codi 0: èxit.
        //String[] program = {"powershell", "noexisteix"};
        // El programa RunProcess intenta executar la comanda noexisteix en la línia de comandes Powershell, que evidentment no existeix. Això fa que el procés acabe en el codi d'error 1: error.

        ProcessBuilder pb = new ProcessBuilder(program);
        try {
            // Inicia el procés fill
            Process process = pb.start();
            System.out.printf("S'ha iniciat el procés: %s\n", Arrays.toString(program));
            // El procés Java (pare) Espera a que el procés fill finalitze
            int codiRetorn = process.waitFor();
            System.out.println("L'execució de "+ Arrays.toString(program) +" retorna "+ codiRetorn);
        } catch (IOException ex) {
            System.err.println("Excepció d'E/S.");
            System.out.println(ex.getMessage());
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("El procés fill ha finalitzat de manera incorrecta.");
            System.exit(-1);
        }
    }
}