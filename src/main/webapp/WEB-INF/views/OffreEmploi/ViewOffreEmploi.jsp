<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="JobConnect.Dao.Model.OffreEmploi" %>
<html>
<head>
    <title>View Job Offer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>View Job Offer</h2>

    <%
         OffreEmploi  offreEmploi = (OffreEmploi) request.getAttribute("offreEmploi");
        if (offreEmploi != null) {
    %>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title"><%= offreEmploi.getTitre() %></h5>
            <h6 class="card-subtitle mb-2 text-muted"><%= offreEmploi.getEntreprise() %></h6>
            <p class="card-text"><%= offreEmploi.getDescription() %></p>
            <p class="card-text">
                <small class="text-muted">Published on: <%= offreEmploi.getDatePublication() %></small>
            </p>
            <a href="offres?action=edit&id=<%= offreEmploi.getId() %>" class="btn btn-primary">Edit</a>
            <a href="offres?action=list" class="btn btn-secondary">Back to List</a>
        </div>
    </div>
    <%
    } else {
    %>
    <p>Job offer not found.</p>
    <%
        }
    %>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>