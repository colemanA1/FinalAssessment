<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MacUser
  Date: 3/8/17
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<table border = "1">
    <tr>
     <th>Employee ID</th>
     <th>First Name</th>
     <th>Last Name</th>
     <th>Title</th>
     <th>Birth Date</th>
     <th>Salary</th>
    </tr>
    <c:forEach var="employees" items="${eList}">
        <tr>
            <td>${employees.employeeID}</td>
            <td>${employees.firstName}</td>
            <td>${employees.lastName}</td>
            <td>${employees.title}</td>
            <td>${employees.birthDate}</td>
            <td>${employees.salary}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
