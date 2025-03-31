<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="JobConnect.Dao.Model.Candidat" %>
<html>
<head>
    <title>View Candidate</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>View Candidate</h2>

    <%
        Candidat candidat = (Candidat) request.getAttribute("candidat");
        if (candidat != null) {
    %>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title"><%= candidat.getNom() %> <%= candidat.getPrenom() %></h5>
            <h6 class="card-subtitle mb-2 text-muted"><%= candidat.getEmail() %></h6>
            <p class="card-text">Phone: <%= candidat.getTelephone() %></p>
            <p class="card-text">CV Path: <%= candidat.getCvPath() %></p>
            <a href="candidats?action=edit&id=<%= candidat.getId() %>" class="btn btn-primary">Edit</a>
            <a href="candidats?action=list" class="btn btn-secondary">Back to List</a>
        </div>
    </div>
    <%
    } else {
    %>
    <p>Candidate not found.</p>
    <%
        }
    %>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>