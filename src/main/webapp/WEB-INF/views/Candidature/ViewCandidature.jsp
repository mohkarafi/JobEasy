<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="JobConnect.Dao.Model.Candidature" %>
<html>
<head>
    <title>View Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>View Application</h2>

    <%
        Candidature candidature = (Candidature) request.getAttribute("candidature");
        if (candidature != null) {
    %>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Application Details</h5>
            <p class="card-text">Offer ID: <%= candidature.getOffreEmploiId() %></p>
            <p class="card-text">Candidate ID: <%= candidature.getCandidatId() %></p>
            <p class="card-text">Application Date: <%= candidature.getDateCandidature() %></p>
            <p class="card-text">Status: <%= candidature.getStatut() %></p>
            <p class="card-text">Motivation Letter: <%= candidature.getLettreMotivation() %></p>
            <a href="candidatures?action=edit&id=<%= candidature.getId() %>" class="btn btn-primary">Edit</a>
            <a href="candidatures?action=list" class="btn btn-secondary">Back to List</a>
        </div>
    </div>
    <%
    } else {
    %>
    <p>Application not found.</p>
    <%
        }
    %>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>