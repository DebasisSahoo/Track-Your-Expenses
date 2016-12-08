<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:jsf="http://java.sun.com/jsf">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../page-resources/Styles/jquery-ui.css">

  <script src="../page-resources/scripts/jquery-3.1.0.js"></script>
  <script src="../page-resources/scripts/jquery-ui.js"></script>

 
</head>
<body>

<f:view>


<jsp:include page="Header.html"></jsp:include>

<h:form id="loginForm">
<script type="text/javascript">
  $(document).ready(function() {
    $("[id='loginForm:date']").datepicker({dateFormat:'dd-M-yy'});
    $("[id='loginForm:date1']").datepicker({dateFormat:'dd-M-yy'});
  });
  function myFunction() {
	    document.getElementById("loginForm").reset();
	}
  </script>
<!-- <div style="width: 40%;float: left;"> -->

<h:outputText value="Hi #{loginBean.uname} ,You have successfully logged in, welcome to our website"></h:outputText>
<h:inputText value="#{loginBean.uname}"></h:inputText>

<h:panelGrid columns="3">
<h:panelGrid columns="3">
<h:column>
<h1 style="color:green" ><abbr title="Mobile Recharge"><i class="fa fa-mobile fa-3x"></i></abbr></h1>
<h1 style="color:green" ><abbr title="Travel"><i class="fa fa-bus fa-3x"></i></abbr></h1>
<h1 style="color:green" ><i class="fa fa-cutlery fa-3x"></i></h1>
</h:column>
<h:column>
<h1 style="color:green" ><i class="fa fa-wifi fa-3x"></i></h1>
<h1 style="color:green" ><i class="fa fa-home fa-3x"></i></h1>
<h1 style="color:green" ><i class="fa fa-glass fa-3x"></i></h1>
</h:column>
<h1 style="color:green" ><i class="fa fa-book fa-3x"></i></h1>
<h1 style="color:green" ><i class="fa fa-shopping-cart fa-3x"></i></h1>
<h1 style="color:green" ><i class="fa fa-money fa-3x" ></i></h1>


</h:panelGrid>
<!-- </div> -->

<!-- <div  style="width: 40%;float: right;"> -->


<h:panelGrid columns="3" style="padding:5em;">
<h:outputText value="Enter the date :"></h:outputText>
<h:inputText id="date1" value="#{loginSuccessBean.dateOfData}">
<f:converter converterId="calendarConv"/>
</h:inputText>
<!-- </div> -->

<div id="mobile" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value="mobile "></h:outputText>
<h:inputText value="#{loginSuccessBean.mobile}"></h:inputText>
</div>
<div id="wifi" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value="wifi "></h:outputText>
<h:inputText value="#{loginSuccessBean.wifi}"></h:inputText>
</div>
<div id="book" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value="book   "></h:outputText>
<h:inputText value="#{loginSuccessBean.book}"></h:inputText>
</div>
<div id="bus" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value="bus   "></h:outputText>
<h:inputText value="#{loginSuccessBean.bus}"></h:inputText>
</div>
<div id="home" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value=" home   "></h:outputText>
<h:inputText value="#{loginSuccessBean.home}"></h:inputText>
</div>
<div id="food" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value="food   "></h:outputText>
<h:inputText value="#{loginSuccessBean.food}"></h:inputText>
</div>
<div id="shopping" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value="shopping   "></h:outputText>
<h:inputText value="#{loginSuccessBean.shopping}"></h:inputText>
</div>
<div id="party" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value=" party   "></h:outputText>
<h:inputText value="#{loginSuccessBean.party}"></h:inputText>
</div>
<div id="other" style="width: 40%;float: right;color: blue;display: none;">
<h:outputText value="Other Expenditures   "></h:outputText>
<h:inputText value="#{loginSuccessBean.other}"></h:inputText>
</div>
<div>
<h:commandButton value="Submit"  action="#{loginSuccessBean.submitData(loginBean.uname)}"></h:commandButton>
<h:commandButton value="Reset" onclick="myFunction()"></h:commandButton>
</div>
</h:panelGrid>



<h:panelGrid columns="3" >
<!-- <div  style="width: 40%;float: right;"> -->
<h:outputText value="Daily date :"></h:outputText>
<h:inputText id="date" value="#{loginSuccessBean.daily_date}">
<f:converter converterId="calendarConv"/>
</h:inputText><br/>
<!-- </div> -->
<!-- <div  style="width: 40%;float: right;"> -->
<h:outputText value="Monthly date :"></h:outputText>
<h:inputText value="#{loginSuccessBean.monthly_month}">
</h:inputText>
<h:inputText value="#{loginSuccessBean.monthly_year}">
</h:inputText>
<!-- </div> -->


<h:commandButton value="Monthly" action="#{loginSuccessBean.calculate_monthly_expenses(loginBean.uname)}"></h:commandButton>
<h:commandButton value="Daily" action="#{loginSuccessBean.calculate_daily_expenses(loginBean.uname)}"></h:commandButton>
<h:commandButton value="Logout" action="#{loginBean.doLogout}"></h:commandButton>
</h:panelGrid>





</h:panelGrid>
</h:form>
<h:outputText value="Your Expenses is #{loginSuccessBean.daily_count}"></h:outputText>
<h:outputText value="Your Monthly Expenses is #{loginSuccessBean.monthly_count}"></h:outputText>
</f:view>
</body>
</html>