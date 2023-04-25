//c3326903
//GameState.java
//Web Engineering Assignment 2
package pkg;
import java.io.Serializable;
import java.util.ArrayList;

import pkg.UserGuess;

//This javabean is used to store the information regarding the game state.
//Will include all the data that is required for the game to operate.
public class GameState implements Serializable {
    //Private variables for the secret number and amount of rounds played to keep track.
    //Also has an array list to store the users previous guesses.
    private int secretNumber;
    private int roundsPlayed;
    private ArrayList<UserGuess> previousGuesses;
    private String username;
    
    //Constructor for gameState, takes the secret number and username as parameters.
    //The username is set by the user in the index.jsp
    public GameState(int secretNumber, String username) {
        //Initializes a new game and stores the variables to keep track.
        this.secretNumber = secretNumber;
        this.roundsPlayed = 0;
        this.previousGuesses = new ArrayList<>();
        this.username = username;
    }
    
    //Secret number getter
    public int getSecretNumber() {
        return secretNumber;
    }
    //Rounds played getter to keep track of rounds
    public int getRoundsPlayed() {
        return roundsPlayed;
    }
    //Setter for rounds played to keep track of the rounds
    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }
    //Getter for the arraylist of the users previous guesses.
    //This makes sure the user doesn't guess a number he has,
    //previously guessed.
    public ArrayList<UserGuess> getPreviousGuesses() {
        return previousGuesses;
    }
    //Getter for the username.
    public String getUsername() {
        return username;
    }
}
