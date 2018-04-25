<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient</title>
</head>
<body>
    <h1>Username: ${patient.username}</h1>
    <h1>First name: ${patient.firstName}</h1>
    <h1>Last name: ${patient.lastName}</h1>
    <h1>Address: ${patient.address}</h1>
    <h1>Birthday: <fmt:formatDate value="${patient.birthDay}" pattern="dd.MM.yyyy"/></h1>
    <h1>Phone: ${patient.phoneNumber}</h1>
</body>
</html>
