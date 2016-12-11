<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../page-resources/Styles/bg.css">
<title>Insert title here</title>

<link rel="stylesheet" href="../page-resources/Styles/jquery-ui.css">
<script src="../page-resources/scripts/jquery-3.1.0.js"></script>
   <!-- <script src="../page-resources/scripts/jquery-ui.js"></script> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>  -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
</head>

<body>
<jsp:include page="Header.html"></jsp:include>
<f:view>

<div id="register">
<h:form>
<h:panelGrid columns="2">
<f:facet name="header">
<h:outputText value="Register Here"></h:outputText>
</f:facet>

<h:outputText value="Name : "></h:outputText>
<h:inputText value="#{registrationBean.uname}"></h:inputText>

<h:outputText value="Email : "></h:outputText>
<h:inputText value="#{registrationBean.email }"></h:inputText>

<h:outputText value="Password : "></h:outputText>
<h:inputSecret value="#{registrationBean.password }"></h:inputSecret>

</h:panelGrid>
<center><h:commandButton value="Submit" action="#{registrationBean.registerUser}"></h:commandButton></center>
</h:form>
</div>
<h:panelGrid columns="2">

<i class="fa fa-mobile fa-4x"></i>

</h:panelGrid>


<div id="center">
<center>
<h:outputText id="text" value="Don't Save what is left after spending<br/>  but spend what is left after saving. <br/>&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;
-Warren Buffet" escape="false">

</h:outputText>
</center>
</div>

<div id="footer">
<center>
<h:commandButton id="btn" value="Login Here">
</h:commandButton>

</center>

</div>

<div id="dialog" title="Login Here..." style="display:none;" >
	<p>You Can Login</p>
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
</div>
<script>
		$( "#dialog" ).dialog({
			autoOpen: false,
			show: {
				effect: "explode",
				duration: 1000
			},
			hide: {
				effect: "explode",
				duration: 1000
			}
		});
		

		$( "#btn" ).on( "click", function() {
			//$("body").css("opacity", "0.1");
			$( "#dialog" ).dialog( "open" );
			
			
			
		});
		
			$("#dialog").dialog( "option", "width", 400 );
	</script>
</f:view>
</body>
</html>