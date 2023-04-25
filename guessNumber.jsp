<!-- c3326903-->
<!-- guessNumber.jsp-->
<!-- Web Engineering Assignment 2-->
<%@ page import="pkg.UserGuess, pkg.GameState" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Imports the packages UserGuess and Gamestate-->
<html>
<head>
    <link rel="stylesheet" href="styles.css">
    <meta charset="UTF-8">
    <title>Make a Guess</title>
</head>
<body>
    <!-- Gets the session attribute for gameState.-->
    <%
        GameState gameState = (GameState) request.getSession().getAttribute("gameState");
    %>
    <!-- This displays what round it is-->
    <h1>Round: <%= gameState.getRoundsPlayed() + 1 %></h1>
    <!-- A form for the user to enter their guess, -->
    <!-- and a form for the user to save the game.-->
    <!-- These forms will send the parameters via POST,-->
    <!-- to the own servlets depending on the form.-->
    <form action="SubmitGuessServlet" method="post">
        <label for="guess">Your guess:</label>
        <input type="number" id="guess" name="guess" min="1" max="11" required>
        <button type="submit">Submit</button>
    </form>
    <form action="SaveGameServlet" method="post">
        <button type="submit">Save Game</button>
    </form>
    <!-- This part displays the guess, result and will tell the user,-->
    <!-- if the correct number is higher or lower.-->
    <table>
        <tr>
            <th>Guess</th>
            <th>Result</th>
        </tr>
        <% for (UserGuess guess : gameState.getPreviousGuesses()) { %>
            <tr>
                <td><%= guess.getNumber() %></td>
                <td><%= guess.isHigher() ? "Higher" : "Lower" %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
