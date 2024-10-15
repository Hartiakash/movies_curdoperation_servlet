<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="demo200.add_movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

/* Apply some basic styles to the body */
body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f4f4f4;
}

/* Style the table */
table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

/* Style the table headers */
table th, table td {
    padding: 10px;
    text-align: left;
}

/* Style for table headers */
table th {
    background-color: #4CAF50;
    color: white;
}

/* Add border and background for table rows */
table td {
    border: 2px solid #ddd;
    background-color: #ffffff;
}

/* Add styles for buttons */
button {
    padding: 8px 12px;
    border: none;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
    border-radius: 5px;
    font-size: 14px;
}

/* Add hover effects for buttons */
button:hover {
    background-color: #45a049;
}

/* Style for image within the table */
table img {
    border-radius: 5px;
    object-fit: cover;
}


</style>
</head>
<body>
<%
List<add_movie> addmovie=(List<add_movie>) request.getAttribute("movie");
%>
<table border="2px">
<tr>
<th>Movie name</th>
<th>Movie Description</th>
<th>Movie Poster</th>
<th>Movie Language</th>
<th>Movie Rating</th>
<th>Edit</th>
<th>delete</th>
</tr>
<%
for(add_movie t:addmovie)
{
	%>
<tr>
	<td><%=t.getMname() %></td>
	<td><%=t.getDescription() %></td>
	<td><img height="100px" width="100px" alt="<%=t.getMname()%>" src="data:image/png;base64,<%= Base64.encodeBase64String(t.getMimage())%>">
	</td>
	<td><%=t.getMlanguage() %></td>
	<td><%=t.getMrating() %></td>
	<td><button>Edit</button></td>
<td><a href="delete?mname=<%=t.getMname() %>"><button>delete</button></a></td>
	
	</tr>
	<%
}
%>
</table>
</body>
</html>