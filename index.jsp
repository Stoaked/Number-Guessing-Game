<!-- c3326903-->
<!-- index.jsp-->
<!-- Web Engineering Assignment 2-->
<!DOCTYPE html>
<!-- This is the main index page of the game.-->
<!-- it displays two forms, Start New Game and Load Game -->
<!-- the parameters will be sent via POST to the appropriate Servlet -->
<html>
<head>
    <link rel="stylesheet" href="styles.css">
    <title>Number Guessing Game</title>
</head>
<body>
    <h1>Number Guessing Game</h1>
    <form action="/c3326903_assignment2/NewGameServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <input type="submit" value="Start New Game">
    </form>
    <br>
    <form action="/c3326903_assignment2/LoadGameServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <input type="submit" value="Load Game">
    </form>
</body>
</html>