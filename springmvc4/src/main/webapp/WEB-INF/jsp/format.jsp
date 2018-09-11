<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
TotalCount:<spring:eval expression="format.totalCount"/><br/>
Discount:<spring:eval expression="format.discount"/><br/>
SumMoney:<spring:eval expression="format.sumMoney"/><br/>
Register Date:<spring:eval expression="format.registerDate"/><br/>
Order Date:<spring:eval expression="format.orderDate"/><br/>
</body>
</html>
