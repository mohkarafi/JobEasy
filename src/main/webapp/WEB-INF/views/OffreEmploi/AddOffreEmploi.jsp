<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Job Offer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>Add New Job Offer</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <form action="offres?action=insert" method="post">
        <div class="form-group">
            <label for="titre">Title:</label>
            <input type="text" class="form-control" id="titre" name="titre" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
        </div>
        <div class="form-group">
            <label for="datePublication">Date Publication (yyyy-MM-dd):</label>
            <input type="text" class="form-control" id="datePublication" name="datePublication" required>
        </div>
        <div class="form-group">
            <label for="entreprise">Company:</label>
            <input type="text" class="form-control" id="entreprise" name="entreprise" required>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="offres?action=list" class="btn btn-secondary">Cancel</a>
    </form>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>