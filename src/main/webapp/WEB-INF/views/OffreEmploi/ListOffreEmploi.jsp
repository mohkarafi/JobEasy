<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="JobConnect.Dao.Model.OffreEmploi" %>
<html>
<head>
    <title>List of Job Offers</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>List of Job Offers</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <%
        List<OffreEmploi> listOffreEmplois = (List<OffreEmploi>) request.getAttribute("OffreEmploiList");
        if (listOffreEmplois != null && !listOffreEmplois.isEmpty()) {
    %>
    <table class="table">
        <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Date Publication</th>
            <th>Company</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (OffreEmploi offre : listOffreEmplois) {
        %>
        <tr>
            <td><%= offre.getTitre() %></td>
            <td><%= offre.getDescription() %></td>
            <td><%= offre.getDatePublication() %></td>
            <td><%= offre.getEntreprise() %></td>
            <td>
                <a href="offres?action=view&id=<%= offre.getId() %>" class="btn btn-info btn-sm">View</a>
                <a href="offres?action=edit&id=<%= offre.getId() %>" class="btn btn-primary btn-sm">Edit</a>
                <a href="offres?action=delete&id=<%= offre.getId() %>" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <p>No job offers found.</p>
    <%
        }
    %>

    <a href="offres?action=new" class="btn btn-success">Add New Job Offer</a>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>