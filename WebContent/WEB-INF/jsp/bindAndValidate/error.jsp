<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 表单的默认命令对象名为command -->
<form:form commandName="command">   <%--表示我们的表单标签，commandName表示绑定的命令对象名字，默认为command--%>
    <form:errors path="*"></form:errors>    <%--表示显示错误信息的标签，如果path为“*”表示显示所有错误信息--%>
</form:form>
