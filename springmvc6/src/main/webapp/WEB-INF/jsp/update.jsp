<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<s:form action="update" method="post" modelAttribute="admin">
    <s:hidden path="id"/>
    <table>
        <tr>
            <td>username:</td>
            <td><s:input path="username"/></td>
        </tr>
        <tr>
            <td>password:</td>
            <td><s:input path="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
