package es.neesis.services;

import org.springframework.stereotype.Component;

public class Hangman {

    private String word;
    private String guess;
    private int tries;

    public Hangman(String word, int tries) {
        this.word = word;
        this.guess = "";
        for (int i = 0; i < word.length(); i++){
            this.guess += "_";
        }
        this.tries = tries;
    }

    public boolean guess(String guess){
        tries--;
        if (guess.length() == 1){
            return charGuess(guess);
        }
        else if (guess.length() > 1){
            return wordGuess(guess);
        }
        else {
            return false;
            //throw new Exception();
        }
    }

    private boolean charGuess(String guess){
        if(this.word.contains(guess) && !this.guess.contains(guess)){
            for (int i = 0; i < this.word.length(); i++){
                if (this.word.charAt(i) == guess.charAt(0)){
                    this.guess = getSubString(this.guess, 0, i) + guess + getSubString(this.guess, i + 1, this.guess.length());
                }
            }
            return true;
        }
        return false;
    }

    private String getSubString(String string, int start, int end){
        if (end < 0){
            return "";
        }
        if (start > string.length()){
            return "";
        }
        return this.guess.substring(start, end);
    }

    private boolean wordGuess(String guess){
        if (guess.equals(this.word)){
            this.guess = this.word;
            return true;
        }
        return false;
    }

    public String getGuess() {
        return guess;
    }

    public int getTries() {
        return tries;
    }

    public boolean hasWordBeenGuessed(){
        return !guess.contains("_");
    }
}
