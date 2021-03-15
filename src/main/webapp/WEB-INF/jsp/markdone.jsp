<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
                        <tr border=2>
                            <th>Id</th>
                            <th>Title</th>
                            <th>Description</th>
                            
                        </tr>
                        <c:forEach var="ToDoList" items="${list}">
                        
           
                                <td>${list.id}</td>
                                <td>${list.title}</td>
                                <td>${list.description}</td>
                                
                               </c:forEach>
                               </tr>
                               </table> 

</body>
</html>