<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Candidat</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<Body>
    <div class="container">
               <%@include file="/WEB-INF/views/collective/Header.jsp" %>
               <h2>Add new Candidat</h2>
            <form action="/candidat?action=insert" method="post">
                <div class="form-group">
                   <label for="nom"> Nom :</label>
                    <input type="text" class="form-control" name="nom" id="nom" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Prenom :</label>
                    <input type="text" class="form-control" name="prenom" id="prenom" required>
                </div>

                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="text" class="form-control" name="email" id="email" required>
                </div>

                <div class="form-group">
                    <label for="telephone">Telephone :</label>
                    <input type="text" class="form-control" name="telephone" id="telephone" required>
                </div>

                <div class="form-group">
                    <label for="cvPath">cvPath :</label>
                    <input type="text" class="form-control" name="cvPath" id="cvPath" required>
                </div>
            </form>
           </div>
           <%@ include file="/WEB-INF/views/collective/Footer.jsp" %>
</Body>
</html>