<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<#list students as student >
${student.id} - ${student.name} - ${student.sex} - ${student.no} <br/>
</#list>
</body>
</html>