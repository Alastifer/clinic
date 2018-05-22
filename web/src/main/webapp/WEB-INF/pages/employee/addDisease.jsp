<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить историю болезни</title>
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
                    <a href="${pageContext.request.contextPath}/employee/patients/${disease.patient.username}/diseases">К таблице</a>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class=" col-md-12 col-lg-12 ">
                            <form:form id="dis" modelAttribute="disease" action="${pageContext.request.contextPath}/employee/patients/${disease.patient.username}/diseases/add" method="POST">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td align="left"><form:label path="beginDate">Дата начала<sup>*</sup></form:label></td>
                                        <td>
                                            <form:input path="beginDate" placeholder="Дата начала"/>
                                            <form:errors path="beginDate" cssClass="error" element="div"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="left"><form:label path="endDate">Дата окончания<sup>*</sup></form:label></td>
                                        <td>
                                            <form:input path="endDate" placeholder="Дата окончания"/>
                                            <form:errors path="endDate" cssClass="error" element="div"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="left"><form:label path="type">Диагноз<sup>*</sup></form:label></td>
                                        <td>
                                            <form:input path="type" placeholder="Диагноз"/>
                                            <form:errors path="type" cssClass="error" element="div"/>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <p><form:label path="content">Содержание</form:label></p>
                                <p>
                                    <form:textarea path="content" placeholder="Содержание" rows="5" cols="40"/>
                                </p>
                                <p>
                                    <input form="dis" type="submit" class="btn btn-primary" value="Добавить">
                                </p>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>