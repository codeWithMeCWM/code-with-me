<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Code With Me - Spring MVC</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
</head>
<body>
	<div class="col-sm-12">
		<h2>Hi, ${name}!</h2>
		<p>You have just seen Spring MVC in action.</p>
		<hr>
		<div class="alert alert-info" role="alert">
			<p><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> ${injected}</p>
		</div>
		<div class="alert alert-success" role="alert">
			<p>
				<span class="glyphicon glyphicon glyphicon-check" aria-hidden="true"></span>
				Try to change the URL parameter to see the greeting change.
			</p>
		</div>
		<a class="btn btn-primary" href="/spring-mvc-demo">Back</a>
	</div>
</body>
</html>