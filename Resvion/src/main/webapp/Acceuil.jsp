<%@page import="com.model.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CategorieDao"%>
<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<%
 User u= (User)session.getAttribute("user");
CategorieDao  cdao=new CategorieDao();
List<Categorie> cats= cdao.allcat();
%>
Bonjour Mr <%=u.getNom() %>

<h1>Categories  <span class="badge badge-secondary"><%=cats.size() %></span></h1>

<div class="row">
<%
for(Categorie c: cats)
{
%>
<div class="col-md-4  btn btn-success" >
<a href='Books.jsp?idcat=<%=c.getId() %>'><%=c.getLibelle() %></a>
</div>
<%} %>
</div>

</body>
</html>