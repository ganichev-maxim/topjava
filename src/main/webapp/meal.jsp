<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%--@elvariable id="meal" type="ru.javawebinar.topjava.model.Meal"--%>
<%--
  Created by IntelliJ IDEA.
  User: Maksim
  Date: 10.02.2021
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
    <form method="post">
        <input type="hidden" name="id" value="${meal.id}">
        <table>
            <tr>
                <td>Дата: </td>
                <c:choose>
                    <c:when test="${meal.dateTime ne null}">
                        <javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd" var="parsedDate" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="parsedDate" value="${meal.dateTime}"/>
                    </c:otherwise>
                </c:choose>
                <td><input type="date" name="dateTime" value="${parsedDate}"></td>
            </tr>
            <tr>
                <td>Описание: </td>
                <td><input type="text" name="description" value="${meal.description}"></td>
            </tr>
            <tr>
                <td>Калории: </td>
                <td><input type="number" name="calories" value="${meal.calories}"></td>
            </tr>
        </table>
        <input type="submit">
    </form>
</body>
</html>
