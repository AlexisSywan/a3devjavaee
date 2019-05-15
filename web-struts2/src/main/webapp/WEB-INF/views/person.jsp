<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <s:head/>
</head>
<body>

<s:actionerror/>
<s:actionmessage/>

<s:form action="person_save">
    <s:textfield label="Prénom" name="person.firstName"/>
    <s:textfield label="Nom" name="person.lastName"/>
    <s:textfield label="Email" name="person.email"/>
    <s:textfield label="Date de naissance" name="person.birthDate" format="dd/MM/yyyy" type="date"/>
    <s:submit/>
</s:form>

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
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.email}</td>
            <td><fmt:formatDate value="${person.birthDate}" type="date" pattern="dd/MM/yyyy"/></td>

            <td><a href="${context}${person.id}" !onclick="edit(event);">modifier</a></td>
            <td>
                <s:form action="person_delete">
                    <input type="hidden" name="id" value="${person.id}"/>
                    <s:submit value="supprimer"/>
                </s:form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    function edit(event) {
        event.preventDefault();
        // NOT PRO
        var tr = event.target.parentNode.parentNode;
        var tds = Array.from(tr.children);
        tds.splice(-2, 2);
        tds.forEach(function (td, col) {
            if (col === 0) {
                var name = 'id';
            } else {
                var name = document.querySelector('tbody')
                    .firstElementChild.children[col]
                    .firstElementChild.name;
                console.log(name);
            }
            var value = td.textContent;
            td.innerHTML = '<input name="' + name + '" value="' + value + '" />';
        });
    }
</script>
</body>
</html>
