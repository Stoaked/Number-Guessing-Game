# Number-Guessing-Game
A number guessing game web application. Written in java!
Made by Stoaked @ Newcastle University.
To demonstrate a web application made in java using MVC principles. 
The URL the marker needs to visit to start the application.

http://localhost:8080/c3326903_assignment2/index.jsp

•The application’s structure, i.e. MVC and relationships among objects etc.

Model: I have two model classes, GameState and UserGuess. The GameState class stores the games current state,
including the secret number of rounds played, and a list of previous guesses. The UserGuess class stores information, 
about a single guess made by the user, including the guessed number and whether the secret number is higher or lower than the guess.

View: I have three JSP files that serves as views including, index.jsp, guessedNumber.jsp and result.jsp. These JSP files display the,
game's interface to the user, allowing them to start a new game, load an existing game, guess a number, view the result, and save the game.

Controller: I have four java servlets that acts as controllers, NewGameServlet, LoadGameServlet, SaveGameServlet and SubmitGuessServlet. 
These servlets handle user requests, update the model (GameState and UserGuess), and forward the user to the appropriate view.

NewGameServlet creates a new GameState object and initializes it with a randomly generated secret number, the username, and sets the rounds played to 1.
It then stores the GameState object in the users session and forwards them to the guessNumber.jsp view.

LoadGameServlet reads the saved game state from a file, deserializes it into a GameState object, and stores it in the users session. It then forwards the user to the guessNumber.jsp view.

SaveGameServlet takes the current 'GameState' object from the user's session, processes the users guess by creating a 'UserGuess' object and updating the GameState and then forwards the users to the appropriate,
view (guessNumber.jsp or result.jsp) based on whether they've guesses the secret number or not.

• What is the purpose of each of your objects?

-GameState: This object represents the state of the game for a user. It stores information such as the secret number, username, the number of rounds played, and a list of previous guesses. The purpose of this object is,
 to keep track of the game's progress and data throughout its lifecycle.

-UserGuess: This object represents a single guess made by the user during the game. It contains the guessed number and a boolean indicating whether the secret number is higher than the guessed number. 
The purpose of this object is to store information about individual guesses and provide feedback to the user about their guesses in the game.

-NewGameServlet: This controller object initializes a new game by creating a GameState object, setting its properties, and storing it in the user's session. It then forwards the user to the guessNumber.jsp view to start the game. 
The purpose of this object is to handle the creation of new games.

-LoadGameServlet: This controller object handles the loading of saved games. It reads the saved game data from a file, deserializes it into a GameState object, and stores it in the user's session. It then forwards the user to the guessNumber.jsp view to resume the game. 
The purpose of this object is to manage the loading of saved games.


-SaveGameServlet: This controller object saves the current game state by serializing the GameState object from the user's session and saving it to a file. It then forwards the user back to the index.jsp view. The purpose of this object is to manage the saving of games.

-SubmitGuessServlet: This controller object processes the user's guess by creating a UserGuess object, updating the GameState object, and forwarding the user to the appropriate view (guessNumber.jsp or result.jsp) based on the outcome of the guess. 
The purpose of this object is to handle user guesses and update the game state accordingly.

• How did you implement session tracking?

Step 1: In the NewGameServlet and LoadGameServlet, when a new game is created or a saved game is loaded, a GameState object is created and populated with the appropriate data. The GameState object is then stored in the user's session with a specific attribute name.
Step 2: In the SubmitGuessServlet, when the user submits a guess, the GameState object is retrieved from the user's session, updated with the new guess, and stored back in the session.
Step 3: In the JSP files (guessNumber.jsp and result.jsp) the GameState object is retrieved from the session and used to display relevant game information to the user.

• How did you implement game saving?

1. In the SaveGameServlet, the GameState object is retrieved from the user's session.
2. A saveDirectory folder is made, which is the directory where the game save files will be stored.
3. The file name is generated based on the username provided by the user.
4. The GameState object is serialized using ObjectOutputStream and FileOutputStream, and saved to the file.
5. After saving the game, the user is redirected to the index page to start a new game or load an existing one.

When the user wants to load a saved game, the LoadGameServlet reads the saved file, deserializes the GameState object, and stores it in the user's session, allowing them to continue playing the game from where they left off.


The URL the marker needs to visit to start the application.

http://localhost:8080/c3326903_assignment2/index.jsp
