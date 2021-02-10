<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 09.02.2021
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%--@elvariable id="meal" type="ru.javawebinar.topjava.model.MealTo"--%>
<%--@elvariable id="meals" type="java.util.List"--%>
<html>
<head>
    <title>Еда</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <td>Дата</td>
            <td>Описание</td>
            <td>Калории</td>
        </tr>
        </thead>
        <c:forEach var="meal" items="${meals}">
            <tr bgcolor="${meal.excess ? 'red' : 'green'}">
                <td><javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd HH:mm:ss" var="parsedDate" />
                    <c:out value="${parsedDate}"/></td>
                <td><c:out value="${meal.description}"/></td>
                <td><c:out value="${meal.calories}"/></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
