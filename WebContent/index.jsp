<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>
</head>
<body>
<%request.getRequestDispatcher("cars").forward(request, response); %>
</body>
</html>