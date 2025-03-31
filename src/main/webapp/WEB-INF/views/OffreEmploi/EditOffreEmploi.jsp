<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="JobConnect.Dao.Model.OffreEmploi" %>
<html>
<head>
    <title>Edit Job Offer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>Edit Job Offer</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <%
       OffreEmploi offreEmploi = (OffreEmploi) request.getAttribute("offreEmploi");
        if (offreEmploi != null) {
    %>
    <form action="offres?action=update" method="post">
        <input type="hidden" name="id" value="<%= offreEmploi.getId() %>">
        <div class="form-group">
            <label for="titre">Title:</label>
            <input type="text" class="form-control" id="titre" name="titre" value="<%= offreEmploi.getTitre() %>" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3" required><%= offreEmploi.getDescription() %></textarea>
        </div>
        <div class="form-group">
            <label for="datePublication">Date Publication (yyyy-MM-dd):</label>
            <input type="text" class="form-control" id="datePublication" name="datePublication" value="<%= offreEmploi.getDatePublication() %>" required>
        </div>
        <div class="form-group">
            <label for="entreprise">Company:</label>
            <input type="text" class="form-control" id="entreprise" name="entreprise" value="<%= offreEmploi.getEntreprise() %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="offres?action=list" class="btn btn-secondary">Cancel</a>
    </form>
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