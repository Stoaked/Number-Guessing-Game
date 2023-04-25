//c3326903
//NewGameServlet.java
//Web Engineering Assignment 2
package pkg;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import pkg.GameState;
import pkg.UserGuess;

//This is the servlet that is the controller for starting a new game.
//Parameters are sent via POST to this servlet from the index.

@WebServlet("/NewGameServlet")
public class NewGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Once a new game is initiated it will set the ranom number
        int secretNumber = (int) (Math.random() * 11 + 1);
        //Will get the username parameter from the index.jsp
        String username = request.getParameter("username");
        //Creates an object called gameState which will send the secret number and username,
        //set by the user when the form was entered as parameters.
        GameState gameState = new GameState(secretNumber, username);
        //Will get the session attribute.
        HttpSession session = request.getSession();
        //Sets the session attribute to gameState.
        session.setAttribute("gameState", gameState);
        //Will redirect to the jsp that displays the game.
        response.sendRedirect("guessNumber.jsp");
    }
}
