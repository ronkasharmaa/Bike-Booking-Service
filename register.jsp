<!DOCTYPE html>
<html>
<head>
<title>Register</title>
</head>
<body>

<h2>Register</h2>

<form action="RegisterServlet" method="post">

Name:<br>
<input type="text" name="name" required>
<br><br>

Email:<br>
<input type="email" name="email" required>
<br><br>

Password:<br>
<input type="password" name="password" required>
<br><br>

Phone:<br>
<input type="text" name="phone" required>
<br><br>

<input type="submit" value="Register">

</form>

<br>

<a href="LoginServlet">Login</a>

</body>
</html>