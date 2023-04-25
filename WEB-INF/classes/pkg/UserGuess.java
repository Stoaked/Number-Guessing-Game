//c3326903
//UserGuess.java
//Web Engineering Assignment 2
package pkg;
import java.io.Serializable;

//This javabean handles the users number he has guessed.
//It sets the number and a boolean value to tell if its higher.

public class UserGuess implements Serializable {
    private int number;
    private boolean higher;
    //Constructor that takes the guessed number as a parameter.
    public UserGuess(int number) {
        this.number = number;
    }
    //Getter for the number.
    public int getNumber() {
        return number;
    }
    //Getter for the higher variable.
    public boolean isHigher() {
        return higher;
    }
    //Setter for the higher variable, takes
    //boolean values higher as a parameter.
    public void setHigher(boolean higher) {
        this.higher = higher;
    }
}
