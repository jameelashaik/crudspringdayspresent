<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editform.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
    <h1>Edit  Employee</h1>  
       <form:form method="post" action="./employeedetails/editsave" modelAttribute="employeedetails">
        <form:hidden  path="id"  />     
         Name: <form:input path="name" />         
        <br><br>  
         SALARY: <form:input path="salary" />
         <br><br>   
         Designation: <form:input path="designation" />  
        <br><br>
         <input type="submit" value="Save" onclick="return validate()"/>   
      
       </form:form>    
  </body>
  <script>

</script>
</html>
