<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Анализ #${analyze.id}</title>
    <link rel="icon" type="image/png" href="<c:url value="/resources/img/hospital.ico"/>"/>
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body background="<c:url value="/resources/img/background.jpg"/>">
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Анализ #${analyze.id}</h3>
                    <a href="${pageContext.request.contextPath}/patient/analyzes">К таблице</a>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class=" col-md-12 col-lg-12 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Пациент</td>
                                    <td>${analyze.patient.firstName} ${analyze.patient.lastName} #${analyze.patient.username}</td>
                                </tr>
                                <tr>
                                    <td>Дата получения</td>
                                    <td>${analyze.receivingDate}</td>
                                </tr>
                                <tr>
                                    <td>Тип анализа</td>
                                    <td>${analyze.type}</td>
                                </tr>
                                </tbody>
                            </table>
                            <p>Содержание</p>
                            <p>${analyze.content}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>