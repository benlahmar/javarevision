<%@page import="com.model.Livre"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CategorieDao"%>
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
<div class="row">
<%
CategorieDao cdao=new CategorieDao();
int idcat= Integer.parseInt(request.getParameter("idcat"));
List<Livre> books= cdao.livres(idcat);

for(Livre v:books)
{
%>
<div class="col-sm-4 alert alert-success" role="alert">
<h3><%=v.getTitre() %></h3>
<p><%=v.getAuteur() %></p>
 <a href=''>Reserver</a>
</div>

<%} %>
</div>
</body>
</html>