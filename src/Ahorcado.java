import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] palabrasJuego = {"oxido", "inteligencia", "televisor", "automovil", "computador"};

        
        String palabraSecreta = palabrasJuego[random.nextInt(palabrasJuego.length)];
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;
        StringBuilder letrasIntentadas = new StringBuilder();
        
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        System.out.println("¡Bienvenido al juego del Ahorcado!\n");
        
        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra: " + String.valueOf(letrasAdivinadas) + 
                             " (" + palabraSecreta.length() + " letras)");
            System.out.println("Intentos restantes: " + (intentosMaximos - intentos));
            if (letrasIntentadas.length() > 0) {
                System.out.println("Letras intentadas: " + letrasIntentadas);
            }
            
            System.out.print("\nIntroduce una letra: ");
            String input = scanner.next().toLowerCase();
            
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Por favor, ingresa solo una letra válida.\n");
                continue;
            }
            
            char letra = input.charAt(0);
            
            if (letrasIntentadas.toString().indexOf(letra) >= 0) {
                System.out.println("Ya has intentado con la letra '" + letra + "'.\n");
                continue;
            }
            
            letrasIntentadas.append(letra).append(" ");
            
            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            
            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! La letra '" + letra + "' no está en la palabra.\n");
            } else {
                System.out.println("¡Correcto! La letra '" + letra + "' está en la palabra.\n");
            }
            
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }
        }
        
        if (!palabraAdivinada) {
            System.out.println("\n¡Qué pena! Te has quedado sin intentos. La palabra era: " + palabraSecreta);
        }
        
        scanner.close();
    }
}
