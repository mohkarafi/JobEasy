<%@ page import="JobConnect.Dao.Model.Candidat" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Candidat</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<Body>

<div class="container">
            <%@include file="/WEB-INF/views/collective/Header.jsp" %>
            <h2>Edit Candidat</h2>

        <% Candidat candidat = (Candidat) request.getAttribute("candidat");%>
        <%
            if (candidat != null){

        %>
            <form action="/candidat?action=update" method="post">
                <input type="hidden" name="id" value="<%= candidat.getId() %>">
                <div class="form-group">
                    <label for="nom"> Nom :</label>
                    <input type="text" class="form-control" value="<%=candidat.getNom()%>" name="nom" id="nom" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Prenom :</label>
                    <input type="text" class="form-control" value="<%=candidat.getPrenom()%>" name="prenom" id="prenom" required>
                </div>

                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="text" class="form-control" name="email" value="<%=candidat.getEmail()%>" id="email" required>
                </div>

                <div class="form-group">
                    <label for="telephone">Telephone :</label>
                    <input type="text" class="form-control" value="<%=candidat.getTelephone()%>" name="telephone" id="telephone" required>
                </div>

                <div class="form-group">
                    <label for="cvPath">cvPath :</label>
                    <input type="text" class="form-control" value="<%=candidat.getCvPath()%>" name="cvPath" id="cvPath" required>
                </div>
            </form>
            <%
            }else {
            %>
            <p>Condidat not found</p>

            <%
                }
            %>
        <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>

</div>
</Body>
</html>