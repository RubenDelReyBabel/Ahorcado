package es.neesis.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class HangmanService implements IHangmanService {

    private Hangman hangman;
    private List<String> words;

    @Override
    public boolean guess(String guess) {
        return hangman.guess(guess);
    }

    @Override
    public int getTries() {
        return hangman.getTries();
    }

    @Override
    public String getGuess() {
        return hangman.getGuess();
    }

    @Override
    public boolean hasWordBeenGuessed() {
        return hangman.hasWordBeenGuessed();
    }

    @Override
    public void loadWords(List<String> words) {
        this.words = words;
    }

    @Override
    public void startGame() {
        if(this.words.isEmpty()){
            throw new RuntimeException("No se han cargado las palabras");
        }
        String word = this.words.get(new Random().nextInt(this.words.size()));
        this.hangman = new Hangman(word, 8);
    }
}
