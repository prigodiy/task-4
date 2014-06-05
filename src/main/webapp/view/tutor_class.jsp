<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz system</title>
</head>
<body>
    ${quizzes.getClass()}
    <br>
    <br>
    <c:forEach var="quiz" items="${quizzes}">
    ${quiz.getName()}
    <form method="get" action="tutor_quiz">
        <input type="hidden" name="classId" value="${quiz.getId()}"/>
        <input type="submit" name="editQuiz" value="Edit"/>
        <input type="submit" name="deleteQuiz" value="Delete"/>
    </form>
    <br>
</c:forEach>
</body>
</html>