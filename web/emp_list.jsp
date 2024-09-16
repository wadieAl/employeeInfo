<%-- 
    Document   : emp_list
    Created on : May 30, 2023, 5:49:19 PM
    Author     : lenovo
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Employee information system </title>
         <link rel="stylesheet"
              herf="http://stackpath.bootstapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorgin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
   <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
   
</head>
<body class="container-fluid">
    <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: tomato">
                <div>
                     <a href="<%=request.getContextPath()%>/list" 
                    class="nav-link" class="navbar-brand">Home page</a>
                </div>
                <ul class="navbar-nav">
                    <li><a herf="<%=request.getContextPath()%>/list" 
                    class="nav-link"> employee </a> </li>
                </ul>
            
        </header>
	<center>
             <div class="row">
                        <div class="container">
                           <hr>
                            <div class="container text-Left">
                                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New  </a>
                                 &nbsp;&nbsp;&nbsp;
                                <a href="<%=request.getContextPath()%>/list" class="btn btn-success">show employee  </a>
                              &nbsp;&nbsp;&nbsp;
                         </div>
                                </br>
                            <div class="card" style="width: 600px; margin: auto; margin-top: 10px; margin-left: 200px;">
           
                                <h2 class="bg-danger text-light card-header">List employee</h2>
                            </div>
         
	
    <div class="card" style="width: 600px; margin: auto; margin-top: 10px; margin-left: 100px;">
        <table class="table table-hover table-striped">
            <tr class="bg-danger text-light card-header">
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Salary</th>
                <th>actions</th>
            </tr>
            <c:forEach var="list" items="${listEmp}">
                <tr>
                    <td><c:out value="${list.empid}" /></td>
                    <td><c:out value="${list.name}" /></td>
                    <td><c:out value="${list.password}" /></td>
                    <td><c:out value="${list.gender}" /></td>
                    <td><c:out value="${list.phone}" /></td>
                    <td><c:out value="${list.email}" /></td>
                    <td><c:out value="${list.address}" /></td>
                   <td><c:out value="${list.salary}" /></td>
                    <td>
                    	<a href="edit?empid=<c:out value='${list.empid}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?empid=<c:out value='${list.empid}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        </center>
    </div>	
</body>
</html>
