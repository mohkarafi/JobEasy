<%@ page import="JobConnect.Dao.Model.Candidat" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>List Of Candidats</title>
    </head>
    <body>
        <div class="container">
            <%
            List<Candidat> candidatList = (List<Candidat> )request.getAttribute("candidats");
            if(candidatList != null && !candidatList.isEmpty()){
            %>
            <table class="table">
               <thead>
               <tr>
                   <th>Name</th>
                   <th>Email</th>
                   <th>Telephone</th>
                   <th>cvPath</th>
               </tr>
               </thead>
                <tbody>
                <%
                    for(Candidat candidat : candidatList){

                %>
                <tr>
                    <td><%=candidat.getNom()%><%= candidat.getPrenom()%></td>
                    <td><%=candidat.getEmail()%></td>
                    <td><%=candidat.getTelephone()%></td>
                    <td><%=candidat.getCvPath()%></td>
                    <td>
                        <a href="/Condidat?action=view&id=<%=candidat.getId()%>">View</a>
                        <a href="/Condidat?action=edit&id=<%=candidat.getId()%>">Edit</a>
                        <a href="/Condidat?action=delete&id=<%=candidat.getId()%>">Delete</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        <%}else{
        %>
            <p>No Condidat Found</p>
        <%
            }
         %>
            <a href="candidats?action=new" class="btn btn-success">Add New Candidate</a>
            <%@include file="/WEB-INF/views/collective/Footer.jsp" %>
        </div>
    </body>
</html>