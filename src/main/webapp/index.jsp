<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JobConnect - Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <div class="jumbotron">
        <h1 class="display-4">Welcome to JobConnect!</h1>
        <p class="lead">Find your dream job or the perfect candidate.</p>
        <hr class="my-4">
        <p>Explore our job offers and candidate database.</p>
        <a class="btn btn-primary btn-lg" href="offres?action=list" role="button">View Job Offers</a>
    </div>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>