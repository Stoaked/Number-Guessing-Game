<!-- c3326903-->
<!-- result.jsp-->
<!-- Web Engineering Assignment 2-->
<%@ page import="pkg.GameState" %>
<%@ page import="pkg.UserGuess" %>
<%
    GameState gameState = (GameState) session.getAttribute("gameState");
%>
<!-- This is the winner page which will display the results!-->
<!-- It has a play again button that redirects to the main index.-->
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="styles.css">
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
    <h1>Congratulations!</h1>
    <p>You guessed the secret number <%= gameState.getSecretNumber() %> in round <%= gameState.getRoundsPlayed() %>.</p>
    <p>You've been awarded <%= 100 - (gameState.getRoundsPlayed() - 1) * 10 %> points.</p>
    <a href="index.jsp">Play Again</a>
</body>
</html>
