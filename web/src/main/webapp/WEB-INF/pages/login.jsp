<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <link rel="icon" type="image/png" href="<c:url value="/resources/img/hospital.ico"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet"/>
</head>
<body background="<c:url value="/resources/img/background.jpg"/>">
    <div class="login-page">
        <div class="form">
            <form class="login-form" method="post" action="${pageContext.request.contextPath}/j_spring_security_check">
                <input type="text" placeholder="Логин" name="id_user"/>
                <input type="password" placeholder="Пароль" name="password"/>
                <c:if test="${param.error != null}"><span class="error">Неверный логин или пароль</span></c:if>
                <button name="submit" type="submit">вход</button>
            </form>
        </div>
    </div>
</body>
</html>
