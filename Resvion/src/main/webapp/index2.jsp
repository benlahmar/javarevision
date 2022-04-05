<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
String msg="";%>
<div>
<form action="Inscription" method="post">
<table style="width: 60%">
<tr>
<td colspan="2">Inscription</td>
</tr>
<tr>
<td>Nom:</td>
<td><input type="text" name="nom"/></td>
</tr>
<tr>
<td>Login:</td>
<td><input type="text" name="log"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="pass"/></td>
</tr>
<tr>
<td> <input type="submit" name="act" value="inscrire"/></td>
<td><input type="reset" value="Annuler"/>
</tr>
</table>
</form>
</div>

<hr/>
<div>
<form action="Inscription" method="post">
<table style="width: 60%">
<tr>
<td colspan="2">Authentification</td>
</tr>

<tr>
<td>Login:</td>
<td><input type="text" name="log"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="pass"/></td>
</tr>
<tr>
<td> <input <%=msg %> type="submit" name="act" value="connect"/></td>
<td><input type="reset" value="Annuler"/>
</tr>
<%

if(request.getParameter("err")!=null)
{
	int cpt=Integer.parseInt(request.getParameter("err"));
	if(cpt>2)
		msg="disabled='disabled'";
	%>
<tr>
<td colspan="2"> Attention username ou password incorrect! tentative:  <%=cpt %></td>
</tr>
<%} %>
</table>
</form>
</div>
</body>
</html>