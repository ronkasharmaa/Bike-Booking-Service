<!DOCTYPE html>
<html>
<head>
<title>Book Service</title>
</head>
<body>

<h2>Book Service</h2>

<form action="BookingServlet" method="post">

Vehicle ID:<br>
<input type="number" name="vehicle_id" required>
<br><br>

Service Type:<br>
<select name="service">

<option>General Service</option>
<option>Oil Change</option>
<option>Full Service</option>
<option>Repair</option>

</select>

<br><br>

<input type="submit" value="Book Service">

</form>

<br>

<a href="DashboardServlet">Back</a>

</body>
</html>