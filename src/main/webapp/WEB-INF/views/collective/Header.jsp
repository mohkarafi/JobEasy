<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JobConnect</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index.jsp">JobConnect</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="offres?action=list">Offres d'emploi</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="candidats?action=list">Candidats</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <% if (session.getAttribute("userId") == null) { %>
            <li class="nav-item">
                <a class="nav-link" href="login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="register">Register</a>
            </li>
            <% } else { %>
            <li class="nav-item">
                <span class="nav-link">Welcome, <%= session.getAttribute("username") %></span>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Logout</a>
            </li>
            <% } %>
        </ul>
    </div>
</nav>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-12">
            <h1>Welcome to JobConnect</h1>
            <p>JobConnect is a platform that connects job seekers with employers. It allows job seekers to search for job offers and apply to them. Employers can post job offers and view applications from job seekers.</p>
        </div>
    </div>
</div>