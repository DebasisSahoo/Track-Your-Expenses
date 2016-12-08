<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
<div>
<h:form>
<center>Login</center>
<h:panelGrid columns="2">
<h:outputText value="Enter your Username :"></h:outputText>
<h:inputText value="#{loginBean.uname}"></h:inputText>
<h:outputText value="Enter your Password :"></h:outputText>
<h:inputSecret value="#{loginBean.password}"></h:inputSecret>

<h:commandButton value="Login Here" action="#{loginBean.doLogin}"></h:commandButton>


</h:panelGrid>
</h:form>
</div>
</f:view>
</body>
</html>