package es.neesis.services;

import java.util.List;

public interface IHangmanService {

    boolean guess(String guess);
    int getTries();
    String getGuess();
    boolean hasWordBeenGuessed();
    void loadWords(List<String> words);
    void startGame();
}
