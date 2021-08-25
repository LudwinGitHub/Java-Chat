<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JavaCzat</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <h1>Welcome to JavaChat</h1>
    <p>Below you can see the history of the conversation, you can join it!</p>
</header>
<main>
    <c:if test="${not empty messageHistory}">
        <ul class="message-list">
            <c:forEach var="userMessage" items="${messageHistory}">
                <li><c:out value="${userMessage}"/>:&nbsp&nbsp</li>
                <li><c:out value="${userName}"/>:&nbsp</li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty messageHistory}">
        <p>No message has been sent yet. Start a conversation.</p>
    </c:if>
    <form action="" method="post">
        <textarea name="userMessage" placeholder="Hey.." rows="5" required></textarea>
        <input name="userName" placeholder="User" required>
        <button>Send</button>
    </form>
</main>
</body>
</html>