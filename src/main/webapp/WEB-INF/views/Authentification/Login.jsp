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

       <form action="login" method="post">
            <div class="from-group">
                <label for="username">Username</label>
                <input type="text" name="username" class="form-control" id="username" required>
            </div>
            <div class="from-group">
                   <label for="password">Password</label>
                   <input type="text" name="password" class="form-control" id="password" required>
             </div>
             <button type="submit" class="btn btn-success">Save</button>
       </form>
       <p>vous n'avez pas de compte<a href="registre">Register Here</a></p>
   </div>


</body>
</html>