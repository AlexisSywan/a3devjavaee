<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8"/>
  <title></title>
</head>
<body>
<table>
  <thead>
    <tr>
      <th>Prénom</th>
      <th>Nom</th>
      <th>Email</th>
      <th>Date de naissance</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="person" items="${persons}">
      <tr>
        <td>${person.firstName}</td>
        <td>${person.lastName}</td>
        <td>${person.email}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
