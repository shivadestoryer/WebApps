<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>To Do List</title>
    
</head>
<body>
    <div>
        <div>
           <center><h1>To do List</h1></center>
            
            <a href="/new-list">
                <button type="submit">Add new todolist</button>
            </a>
            <br/><br/>
            <div>
                <div>
                    <div> list</div>
                </div>
                <div>
                    <table>
                        <tr border=2>
                            <th>Task_Id</th>
                            <th>Task Title</th>
                            <th>Task Description</th>
                            
                        </tr>
                        <c:forEach var="ToDoList" items="${toDoList}">
                        
                            <tr>
                                <td>${ToDoList.id}</td>
                                <td>${ToDoList.title}</td>
                                <td>${ToDoList.description}</td>
                                
                                <td>
                                    <a href="/${ToDoList.id}">update</a>
                                    <a href="/${ToDoList.id}/status">mark done</a>
                                    <form action="/${ToDoList.id}/delete" method="post">
                                        <input type="submit" value="Delete" />
                                    </form>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </table>
                </div>
                
                
            </div>
        </div>
    </div>
</body>
</html>