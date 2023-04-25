//c3326903
//SaveGameServlet.java
//Web Engineering Assignment 2
package pkg;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//This servlet provides a way to save the "gameState" object to a file and clear it, 
//from the HttpSession when the game is over. It also redirects the user to index.jsp to indicate that the game has ended.

@WebServlet("/SaveGameServlet")
public class SaveGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //First retrieves the "gameState" object from the HttpSession and casts it to the "GameState" type.
        HttpSession session = request.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        String saveDirectory = getServletContext().getRealPath("/WEB-INF/savedGames");
        //Creates a new FileOutputStream and ObjectOutputStream to write the "gameState" object to a file with a name based on the user's username. 
        //Is also used to serialize the object and write it to the output stream.
        try (FileOutputStream fos = new FileOutputStream(saveDirectory + "/" + gameState.getUsername() + ".dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameState);
        }
        //After the object has been written to the file, the "gameState" object is removed, 
        //from the HttpSession, since it is no longer needed.
        session.removeAttribute("gameState");
        response.sendRedirect("index.jsp");
    }
}