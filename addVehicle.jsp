<!DOCTYPE html>
<html>
<head>
<title>Add Vehicle</title>
</head>
<body>

<h2>Add Vehicle</h2>

<form action="VehicleServlet" method="post">

VIN:<br>
<input type="text" name="vin" required>
<br><br>

Vehicle Number:<br>
<input type="text" name="number" required>
<br><br>

Model:<br>
<input type="text" name="model" required>
<br><br>

Brand:<br>
<input type="text" name="brand" required>
<br><br>

<input type="submit" value="Add Vehicle">

</form>

<br>

<a href="DashboardServlet">Back</a>

</body>
</html>