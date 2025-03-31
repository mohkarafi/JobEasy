<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/collective/Header.jsp" %>

    <h2>Add New Application</h2>

    <form action="Condidature?action=insert" method="post">
        <div class="form-group">
            <label for="offreEmploiId">Offer ID:</label>
            <input type="number" class="form-control" id="offreEmploiId" name="offreEmploiId" required>
        </div>
        <div class="form-group">
            <label for="candidatId">Candidate ID:</label>
            <input type="number" class="form-control" id="candidatId" name="candidatId" required>
        </div>
        <div class="form-group">
            <label for="lettreMotivation">Motivation Letter:</label>
            <textarea class="form-control" id="lettreMotivation" name="lettreMotivation" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="candidatures?action=list" class="btn btn-secondary">Cancel</a>
    </form>

    <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</div>
</body>
</html>