//c3326903
//SubmitGuessServlet.java
//Web Engineering Assignment 2
package pkg;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//This is the main controller for the actual game.
//It handles the guessed number that is submitted by the user.
//The guessed number is sent via POST from guessNumber.jsp.
@WebServlet("/SubmitGuessServlet")
public class SubmitGuessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Initializes a new httpSession object and assigns it to the session variable.
        HttpSession session = request.getSession();
        //Retrieves the value of the "gameState" attribute from the HttpSession, 
        //object stored in the "session" variable. The value is then cast to the type, 
        //"GameState" and assigned to the "gameState" variable.
        GameState gameState = (GameState) session.getAttribute("gameState");
   //Retrieves the value of the "guess" parameter from the HTTP request being processed by the servlet,
   //converts it to an integer, and assigns it to the "guessedNumber" variable.
   int guessedNumber = Integer.parseInt(request.getParameter("guess").trim());
        //This helps to prevent the same number from being guessed multiple times in the game.
        //Sets hasAlreadyGuessed to false, then loops through the previousGuesses arraylist,
        //and if it finds a number that matches the number the user guessed,
        //it sets the hasAlreadyGuessed variable to true and exits the loop.
        boolean hasAlreadyGuessed = false;
        for (UserGuess userGuess : gameState.getPreviousGuesses()) {
            if (userGuess.getNumber() == guessedNumber) {
                hasAlreadyGuessed = true;
                break;
            }
        }
        //If hasAlreadyGuessed is false, it updates the state of the game,
        //to reflect the users new guess by creating a new UserGuess object,
        //and adding it to the list of previous guesses array list.
        //It then updates the number of rounds played.
        if (!hasAlreadyGuessed) {
            UserGuess userGuess = new UserGuess(guessedNumber);
            userGuess.setHigher(gameState.getSecretNumber() > guessedNumber);
            gameState.getPreviousGuesses().add(userGuess);
            gameState.setRoundsPlayed(gameState.getRoundsPlayed() + 1);
            //If the user guesses the number then it updates the gameState,
            //and redirects the user to the winner page result.jsp.
            if (guessedNumber == gameState.getSecretNumber()) {
                session.setAttribute("gameState", gameState);
                response.sendRedirect("result.jsp");
            } else {
                //else it will update the gameState and redirect,
                //to the guessNumber page to continue play.
                session.setAttribute("gameState", gameState);
                response.sendRedirect("guessNumber.jsp");
            }
        } else {
            //This will handle the case where the user has already guessed a particular number and needs to be,
            //informed to try a different number. It also forwards the request and response objects to the "guessNumber.jsp",
            //page for further processing.
            request.setAttribute("errorMessage", "You have already guessed this number. Please try another number.");
            request.getRequestDispatcher("guessNumber.jsp").forward(request, response);
        }
    }
}
