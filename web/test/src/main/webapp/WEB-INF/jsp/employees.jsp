<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<link href="resources/css/toastr.scss" rel="stylesheet" />

<script src="resources/js/jquery-1.12.4.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/angular/angular.js"></script>
<script src="resources/js/angular/ui-bootstrap-tpls.js"></script>
<script src="resources/js/angular/toastr.js"></script>
<script src="resources/js/angular/form-validation.js"></script>

<script src="resources/js/controllers/app.js"></script>
<script src="resources/js/controllers/util.js"></script>
<script src="resources/js/controllers/service.js"></script>
<script src="resources/js/controllers/employees/employees.js"></script>

<title>Employees</title>
</head>
<body ng-app="app">
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<div class="navbar-brand">TEST PROJECT</div>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li id="emp"><a href="<c:url value="/employees.html"/>">Employees</a></li>
				</ul>
			</div>
		</nav>
		<div class="page-header">
			<h1>Employees</h1>
		</div>
	</div>

	<div class="container" ng-controller="EmployeesCtrl">
		<div class="form-group">
			<button class="btn btn-primary" ng-click=openModal()>Add Employee</button>
		</div>
		<div class="table-responsive dont-show"
			ng-class="{shown : settings.loadingDone }">
			<table class="table table-bordered">
				<tr>
					<th width="20%">Name</th>
					<th width="20%">Surname</th>
					<th width="20%">Post</th>
					<th width="20%">Department</th>
					<th width="10%"></th>
				</tr>
				<tr>
					<td><input ng-model="search.name" class="form-control" placeholder="Search..."/></td>
					<td><input ng-model="search.surname" class="form-control" placeholder="Search..."/></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr ng-repeat="employee in employeesList | filter : search">
					<td><a ng-click=openModal(employee.id) href="#">{{employee.name}}</a>
					</td>
					<td>{{employee.surname}}</td>
					<td>{{employee.post}}</td>
					<td>{{employee.department}}</td>
					<td>
						<button ng-click="del(employee.id)" class="btn btn-danger">Delete</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<footer class="footer">
		<div class="container text-center">
			<p class="text-muted">Copyright © Andrey Gorbachov</p>
		</div>
	</footer>
</body>
<script type="text/ng-template" id="saveEmployeeModal.html">
<div class="modal-header">
    <h4>
        Add employees
    </h4>
</div>
<form name="saveEmployeeForm" novalidate ui-validation-submit="save()">
<div class="modal-body">
		<div class="form-group" ui-validation-show-errors>
			<label class="control-label">Name:</label>
			<input ng-model="employeeForm.name" class="form-control" name="name" placeholder="Name" required ng-maxlength="50"/>
			<ui-validation-error-messages>
		</div>
		<div class="form-group" ui-validation-show-errors>
			<label class="label-control">Surname:</label>
			<input ng-model="employeeForm.surname" class="form-control" name="surname" placeholder="Surname" required ng-maxlength="50"/>
			<ui-validation-error-messages>
		</div>
		<div class="form-group" ui-validation-show-errors>
			<label class="label-control">Post:</label>
			<input ng-model="employeeForm.post" class="form-control" name="post" placeholder="Post" required ng-maxlength="50"/>
			<ui-validation-error-messages>
		</div>
		<div class="form-group" ui-validation-show-errors>
			<label class="label-control">Department:</label>
			<input ng-model="employeeForm.department" class="form-control" name="department" placeholder="Department" required ng-maxlength="50"/>
			<ui-validation-error-messages>
		</div>
</div>
<div class="modal-footer">
	<button type="submit" class="btn btn-primary" ng-disabled="employeeForm.$pristine">Save</button>
    <button type="button" class="btn btn-primary" ng-click="cancel()">Cancel</button>
</div>
</form>
</script>