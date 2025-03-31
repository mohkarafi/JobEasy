<%@ page import="JobConnect.Dao.Model.Candidature" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>Edit Application</h2>

    <%
        Candidature candidature = (Candidature) request.getAttribute("candidature");
        if (candidature != null) {
    %>
    <form action="Condidature?action=update" method="post">
        <input type="hidden" name="id" value="<%= candidature.getId() %>">
        <div class="form-group">
            <label for="offreEmploiId">Offer ID:</label>
            <input type="number" class="form-control" id="offreEmploiId" name="offreEmploiId" value="<%= candidature.getOffreEmploiId() %>" required>
        </div>
        <div class="form-group">
            <label for="candidatId">Candidate ID:</label>
            <input type="number" class="form-control" id="candidatId" name="candidatId" value="<%= candidature.getCandidatId() %>" required>
        </div>
        <div class="form-group">
            <label for="lettreMotivation">Motivation Letter:</label>
            <textarea class="form-control" id="lettreMotivation" name="lettreMotivation" rows="3"><%= candidature.getLettreMotivation() %></textarea>
        </div>
        <div class="form-group">
            <label for="statut">Status:</label>
            <select class="form-control" id="statut" name="statut">
                <option value="EN_ATTENTE" <%= "EN_ATTENTE".equals(candidature.getStatut()) ? "selected" : "" %>>En Attente</option>
                <option value="ACCEPTE" <%= "ACCEPTE".equals(candidature.getStatut()) ? "selected" : "" %>>Accepté</option>
                <option value="REJETE" <%= "REJETE".equals(candidature.getStatut()) ? "selected" : "" %>>Rejeté</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="candidatures?action=list" class="btn btn-secondary">Cancel</a>
    </form>
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