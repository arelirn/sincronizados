import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //las palabra1 y la palabra2 
        System.out.print("Ingresa la primera palabra: ");
        String palabra1 = scanner.nextLine();
        
        System.out.print("Ingresa la segunda palabra: ");
        String palabra2 = scanner.nextLine();
        
        scanner.close();
        
//el arreglo para las 50 posiciones
        String frase[] = new String[50];
        Posicion pos = new Posicion();
        
        System.out.println("\nIniciando 6 hilos");
        System.out.println("Palabra 1: " + palabra1 + " (posiciones pares)");
        System.out.println("Palabra 2: " + palabra2 + " (posiciones impares)");
        
     
        HiloEscribe hilos[] = new HiloEscribe[6];
        
  //ciclo para los pares 
        for (int i = 0; i < 3; i++) 
        {
            hilos[i] = new HiloEscribe(pos, palabra1, true);
            hilos[i].setName("Hilo_Par" + (i + 1));
            hilos[i].setInfo(frase);
            hilos[i].setTmp(50 + (i * 10));  
        }
        
        //ciclo para los impares 
        for (int i = 3; i < 6; i++) {
            hilos[i] = new HiloEscribe(pos, palabra2, false);
            hilos[i].setName("Hilo_Impar" + (i - 2));
            hilos[i].setInfo(frase);
            hilos[i].setTmp(80 + ((i - 3) * 10));  
        }
        
       //aqui se inician todos los hilos 
        for (int i = 0; i < 6; i++) {
            hilos[i].start();
        }
        
        
        try {
            for (int i = 0; i < 6; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en join: " + e.getMessage());
        }
        
       7
        System.out.println("\nRESULTADO FINAL");
        for (int i = 0; i < 50; i++) {   //ciclo que recorrera todas las celdas del arreglo 
            if (frase[i] != null) {   //verifica si la celda tiene contenido 
                System.out.println("frase[" + i + "] = " + frase[i]);   //muestra el contenido de la celda
            }
        }
        
        // Mostrar estadísticas
        System.out.println("\nESTADÍSTICAS");
        int contadorPares = 0;
        int contadorImpares = 0;
        
        for (int i = 0; i < 50; i++) {
            if (frase[i] != null) {
                if (i % 2 == 0) {
                    contadorPares++;
                } else {
                    contadorImpares++;
                }
            }
        }
        
        System.out.println("Posiciones pares escritas: " + contadorPares);
        System.out.println("Posiciones impares escritas: " + contadorImpares);
        System.out.println("Total de celdas ocupadas: " + (contadorPares + contadorImpares));
    }
}
