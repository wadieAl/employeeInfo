<%-- 
    Document   : employee_form
    Created on : May 30, 2023, 7:18:30 PM
    Author     : lenovo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Employee information system </title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
      
</head>
<body class="container-fluid">
	<center>
	    <div class="card" style="width: 600px; margin: auto; margin-top: 20px; margin-left: 200px;">
            <h2 class="bg-danger text-light card-header">Employee management </h2>
             <h2>
        	<a href="new">Add New </a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">show Employee</a>
        	 </h2>
	  </center>
    <div class="card" style="width: 600px; margin: auto; margin-top: 10px; margin-left: 200px;">
       <c:if test="${employee != null}">
         <form class="form" action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
	 <form calss="form" action="add" method="post">
        </c:if>
        <table class="table table-hover table-striped">
            <caption>
            	<h2>
            	  <c:if test="${employee != null}">
            			Edit employee
            		</c:if>
            		<c:if test="${employee == null}">
            			add employee
            		</c:if>
            	   </h2>
            </caption>
        	<c:if test="${employee != null}">
        	  <input type="hidden" name="empid" value="<c:out value='${employee.empid}' />" />
        	</c:if>            
            <tr>
                <th> Name: </th>
                <td>
                  <input type="text" name="name" size="45"
                			value="<c:out value='${employee.name}' />"
                		/>
                </td>
            </tr>
                <tr>
                <th>Password: </th>
                <td>
                  <input type="password" name="password" size="45"
                			value="<c:out value='${employee.password}' />"
                		/>
                </td>
                <tr> <th>Gender</th>
                                <td>Male<input type="radio" name="gender" value="male" checked/>
                                Female<input type="radio" name="gender" value="female" /></td>
                 </tr> 
          
                <tr>
                <th>Phone: </th>
                <td>
                   <input type="text" name="phone" size="45"
                			value="<c:out value='${employee.phone}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th> Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${employee.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Address: </th>
                <td>
                	<input type="text" name="address" size="15"
                			value="<c:out value='${employee.address}' />"
                	/>
                </td>
            </tr>
              <tr>
                <th>Salary </th>
                <td>
                	<input type="text" name="salary" size="15"
                			value="<c:out value='${employee.salary}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td >
            		<button type="submit" class="btn btn-outline-success" id="btsub" >Register</button>
            	</td>
                <td>
                    <button type="reset" class="btn btn-outline-danger" id="btres" >Reset</button>
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>

