<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
</head>
<body>
<s:form action="person_save">
    <s:textfield label="Prénom" name="person.firstName"/>
    <s:textfield label="Nom de famille" name="person.lastName"/>
    <s:textfield label="Mail" name="person.email"/>
    <s:textfield label="Date de naissance" name="person.birthDate" format="dd/MM/yyyy"/>
    <s:submit/>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:if>

        <c:forEach var="person" items="${persons}">
            <c:if test="${person.id eq id}">
                <tr>
                    <td><s:hidden name="person.id"/>${person.id}</td>
                    <td><s:textfield name="person.firstName"/></td>
                    <td><s:textfield name="person.lastName"/></td>
                    <td><s:textfield name="person.email"/></td>
                    <td><s:datetextfield name="person.birthDate"
                                         format="dd/MM/yyyy"/></td>
                    <td><s:submit/></td>
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
</s:form>
<script>
    function edit(event) {
        event.preventDefault();
        console.log(envent.target);
    }
</script>
</body>
</html>
