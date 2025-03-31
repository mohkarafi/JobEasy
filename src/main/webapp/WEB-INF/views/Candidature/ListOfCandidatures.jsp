<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="JobConnect.Dao.Model.Candidature" %>
<html>
<head>
    <title>List of Applications</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp/ "%>

    <h2>List of Applications</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <%
        List<Candidature> listCandidatures = (List<Candidature>) request.getAttribute("listCandidatures");
        if (listCandidatures != null && !listCandidatures.isEmpty()) {
    %>
    <table class="table">
        <thead>
        <tr>
            <th>Offer ID</th>
            <th>Candidate ID</th>
            <th>Application Date</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Candidature candidature : listCandidatures) {
        %>
        <tr>
            <td><%= candidature.getOffreEmploiId() %></td>
            <td><%= candidature.getCandidatId() %></td>
            <td><%= candidature.getDateCandidature() %></td>
            <td><%= candidature.getStatut() %></td>
            <td>
                <a href="candidatures?action=view&id=<%= candidature.getId() %>" class="btn btn-info btn-sm">View</a>
                <a href="candidatures?action=edit&id=<%= candidature.getId() %>" class="btn btn-primary btn-sm">Edit</a>
                <a href="candidatures?action=delete&id=<%= candidature.getId() %>" class="btn btn-danger btn-sm">Delete</a>
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
    <p>No applications found.</p>
    <%
        }
    %>

    <a href="candidatures?action=new" class="btn btn-success">Add New Application</a>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>