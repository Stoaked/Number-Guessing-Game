//c3326903
//LoadGameServlet.java
//Web Engineering Assignment 2
package pkg;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//This servlet is used to load a previously saved game state from a file, given the username of the player who saved the game.

@WebServlet("/LoadGameServlet")
public class LoadGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//First retrieves the username parameter from the HttpServletRequest object,
    	//obtains the file path to the directory where saved game files are stored,
        String username = request.getParameter("username");
        String saveDirectory = getServletContext().getRealPath("/WEB-INF/savedGames");
        //This method is used to create a Path object that represents the file path for the saved game, 
        //based on the save directory and the username of the player.
        Path savedGamePath = Paths.get(saveDirectory, username + ".dat");
        //the "loadedGameState" variable is initialized to null. 
        //This variable will be used to store the deserialized GameState object after it is read from the file.
        GameState loadedGameState = null;
        //creates a new FileInputStream and ObjectInputStream to read the saved game state from the file. 
        //The "toFile()" method of the Path object is used to obtain a File object that represents the saved game file.
        try (FileInputStream fis = new FileInputStream(savedGamePath.toFile());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            loadedGameState = (GameState) ois.readObject();
            //The catch is used to handle any exceptions that may occur during the deserialization process. 
            //For example, if the file is not found, a FileNotFoundException will be thrown, and the exception will be caught and handled.
        } catch (IOException | ClassNotFoundException e) {
            // Handle exceptions (e.g. file not found)
            e.printStackTrace();
        }
        //If the loadedGameState is not null, it obtains the HttpSession object,
        //and sets the "gameState" attribute to the deserialized GameState object.
        //It will also delete the save file once its loaded so the user,
        //cannot just load to a previous state if they stuff up the guess.
        if (loadedGameState != null) {
            HttpSession session = request.getSession();
            session.setAttribute("gameState", loadedGameState);
            try {
                Files.delete(savedGamePath);
            } catch (IOException e) {
                // Handle exceptions (e.g. file not found)
                e.printStackTrace();
            }
            response.sendRedirect("guessNumber.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}