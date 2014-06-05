<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz system</title>
</head>
<body>
    Welcome tutor <b>${sessionScope.tutor.getLogin()}</b>
    <form method="post" action="tutor_logout">
        <input type="submit" name="logout" value="Logout"/>
    </form>
    <br>
    You classes:
    <br>
    <br>
    <c:forEach var="quiz" items="${sessionScope.tutor.getClasses()}">
        ${quiz.getName()}
        <form method="post" action="tutor_class">
            <input type="hidden" name="classId" value="${quiz.getId()}" />
            <input type="submit" name="showClass" value="Show"/>
            <input type="submit" name="deleteClass" value="Delete"/>
        </form>
        <br>
    </c:forEach>
    <form method="post" action="tutor_add_class">
        New class: <input type="text" name="newClassName">
        <input type="submit" value="Add class"/>
    </form>
</body>
</html>