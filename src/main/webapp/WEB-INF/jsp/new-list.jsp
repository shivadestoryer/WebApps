<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>todo list</title>
</head>
<body>
    <div>
        <h2>New list</h2>
        <div>
            <div>
                <form:form action="/add" modelAttribute="list" method="post">
                    <div>
                        <div>
                            <form:label path="title">title</form:label>
                            <form:input type="text" id="title" path="title"/>
                            <form:errors path="title" />
                        </div>
                        <div>
                            <form:label path="description">Description</form:label>
                            <form:input type="text" id="description" path="description"/>
                            <form:errors path="description" />
                        </div>
                    </div>
                    <div>
                        <div>
                            <input type="submit" value="Add List">
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    </body>
</html>