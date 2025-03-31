<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>

<div class="container">
    <h2>Login</h2>
    <% if(request.getAttribute("erreurMessage") != null) {%>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("erreurMessage") %>
    </div>
    <% }%>


    <form action="registre" method="post">
        <div class="from-group">
            <label for="username">Username</label>
            <input type="text" name="username" class="form-control" id="username" required>
        </div>

        <div class="from-group">
            <label for="password">Password</label>
            <input type="text" name="password" class="form-control" id="password" required>
        </div>
        <div class="from-group">
            <label for="email">Email : </label>
            <input type="text" name="email" class="form-control" id="email" required>
        </div>
        <div class="from-group">
            <label for="role">Role</label>
            <select id="role" name="role">
                <option value="CONDIDAT">Candidat</option>
                <option value="RECRUTEUR">Recruteur</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Registre</button>
    </form>
    <p>deja vous avez un compte<a href="login">Login</a></p>
</div>


</body>
</html>