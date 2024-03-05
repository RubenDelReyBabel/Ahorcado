package es.neesis.applications;

import es.neesis.services.Hangman;
import es.neesis.services.IHangmanService;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class HangmanApplication {

        private final IHangmanService hangmanService;

        public HangmanApplication(IHangmanService hangmanService) {
            this.hangmanService = hangmanService;
        }

        public void run(){
            Scanner scanner = new Scanner(System.in);
            int option = 0;
            List<String> words = getWords();

            hangmanService.loadWords(words);

            while(option == 0){
                System.out.print("Si quiere jugar introduzca 0, si quiere salir introduzca otro número: ");
                option = scanner.nextInt();
                if (option==0){
                    play();
                }
            }
        }

        private void play(){
            Scanner scanner = new Scanner(System.in);
            hangmanService.startGame();
            while(hangmanService.getTries() > 0 && !hangmanService.hasWordBeenGuessed()){
                System.out.println("Palabra: " + hangmanService.getGuess());
                System.out.println("Número de intentos restantes: " + hangmanService.getTries());

                System.out.print("Intente adivinar una letra o la palabra completa: ");
                String guess = scanner.next();
                if (hangmanService.guess(guess)){
                    System.out.println("Correcto!");
                }
                else {
                    System.out.println("Incorrecto");
                }
            }
            if (hangmanService.hasWordBeenGuessed()){
                System.out.println("Ha acertado la palabra!!");
            }
            else{
                System.out.println("Te has quedado sin intentos");
            }
        }

        private List<String> getWords(){
            List<String> words = new ArrayList<>();
            try {
                String word;
                FileReader f = new FileReader("./src/main/java/es/neesis/words.txt");
                BufferedReader b = new BufferedReader(f);
                while((word = b.readLine())!=null) {
                    words.add(word);
                }
            }catch (IOException ex) {
            }
            return words;
        }
}
