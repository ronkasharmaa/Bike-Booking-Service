<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="LoginServlet" method="post">

Email:<br>
<input type="email" name="email" required>
<br><br>

Password:<br>
<input type="password" name="password" required>
<br><br>

<input type="submit" value="Login">

</form>

<br>

<a href="RegisterServlet">Register Here</a>

</body>
</html>