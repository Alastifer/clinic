<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Истории болезней</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="<c:url value="/resources/img/hospital.ico"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/animate/animate.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/select2/select2.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/util.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>"/>
    <script src="<c:url value="/resources/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/popper.js"/>"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/select2/select2.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"/>"></script>
    <script>
        $('.js-pscroll').each(function(){
            var ps = new PerfectScrollbar(this);

            $(window).on('resize', function(){
                ps.update();
            })
        });
    </script>
    <script src="<c:url value="/resources/js/main.js"/>"></script>
</head>
<body background="<c:url value="/resources/img/background.jpg"/>">
    <div class="limiter">
        <div class="row float-r">
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary m-t-10">Выход</a>
        </div>
        <div class="row float-l">
            <a href="${pageContext.request.contextPath}/patient" class="btn btn-primary m-t-10">Профиль</a>
        </div>
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100 ver1 m-b-110">
                    <div class="table100-head">
                        <table>
                            <thead>
                            <tr class="row100 head">
                                <th class="cell100 column1">Номер истории болезни</th>
                                <th class="cell100 column2">Дата начала</th>
                                <th class="cell100 column3">Дата окончания</th>
                                <th class="cell100 column4">Диагноз</th>
                                <th class="cell100 column5">Содержание</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="table100-body js-pscroll">
                        <table>
                            <tbody>
                                <c:forEach var="disease" items="${diseases}">
                                    <tr class="row100 body">
                                        <td class="cell100 column1">${disease.id}</td>
                                        <td class="cell100 column2">
                                            <fmt:formatDate value="${disease.beginDate}" pattern="dd-MM-yyyy HH:mm"/>
                                        </td>
                                        <td class="cell100 column3">
                                            <fmt:formatDate value="${disease.endDate}" pattern="dd-MM-yyyy HH:mm"/>
                                        </td>
                                        <td class="cell100 column4">${disease.type}</td>
                                        <td class="cell100 column5">
                                            <a href="${pageContext.request.contextPath}/patient/diseases/${disease.id}" class="btn btn-primary">Содержание</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>