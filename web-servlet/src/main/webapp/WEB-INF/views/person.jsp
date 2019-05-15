<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
</head>
<body>
<c:url var="context" value="/person/"/>
<form method="post" action="${context}save">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Date de naissance</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${id eq null}">
            <tr>
                <td>*</td>
                <td><input name="firstName"/></td>
                <td><input name="lastName"/></td>
                <td><input name="email"/></td>
                <td><input name="birthDate"/></td>
                <td><input type="submit"/></td>
            </tr>
        </c:if>
        <c:if test="${person.id ne id}">
        </c:if>

        <c:forEach var="person" items="${persons}">
            <c:if test="${person.id eq id}">
                <tr>
                    <td><input type="hidden" name="id" value="${person.id}"></td>
                    <td><input name="firstName" value="${person.firstName}"></td>
                    <td><input name="lastName" value="${person.lastName}"></td>
                    <td><input name="email" value="${person.email}"></td>
                    <td><input name="birthDate" value="${person.birthDate}"></td>
                    <td><input type="submit"/></td>
                    <td><a href="${context}" name="edit">Annuler</a></td>
                    <td><a href="${context}delete/${person.id}" name="delete">Supprimer</a></td>
                </tr>
            </c:if>
            <c:if test="${person.id ne id}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>${person.email}</td>
                    <fmt:parseDate value="${person.birthDate}" type="date" var="birthDate" pattern="yyyy-MM-dd"/>
                        <td>
                        <fmt:formatDate value="${birthDate}" type="date" pattern="dd-MMM-yyyy"/>

                    </td>
                    <td><a href="${context}${person.id}" name="edit">modifier</a></td>
                        <%--                    <td><button onclick="edit(event)">modifier</button></td>--%>
                    <td><a href="${context}delete/${person.id}">delete</a></td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</form>
<script>
    function edit(event) {
        event.preventDefault();
        console.log(envent.target);
    }
</script>
</body>
</html>
