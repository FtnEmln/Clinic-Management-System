<%-- 
    Document   : AddDoctor
    Created on : Feb 3, 2022, 10:36:33 AM
    Author     : Farah
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sql:setDaraSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver"></sql:setDaraSource>
<html>
<head>
	<!-- Basic Page Info -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Doctor</title>

	<!-- Site favicon -->
        <link rel="apple-touch-icon" sizes="180x180" href="vendors/images/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="vendors/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="vendors/images/favicon-16x16.png">


	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="vendors/styles/core.css">
	<link rel="stylesheet" type="text/css" href="vendors/styles/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendors/styles/style.css">
	
</head>
<body>
    
	<div class="pre-loader" style="background: #0C2340;">
		<div class="pre-loader-box">
                    <div class="loader-logo"><img src="<c:url value="/src/images/loader/loader.jpeg"/>" alt=""></div>
			<div class='loader-progress' id="progress_div">
				<div class='bar' id='bar1'></div>
			</div>
			<div class='percent' id='percent1'>0%</div>
			<div class="loading-text" style="color:white;">
				Loading...
			</div>
		</div>
	</div>

	<div class="header">
		<div class="header-left">
			<div class="menu-icon dw dw-menu"></div>
			<div class="header-search"><b>Clinic Management System's [CMS] Dashboard - DeskApp</b></div>
		</div>
		<div class="header-right">
			<div class="user-info-dropdown">
				<a class="dropdown-toggle no-arrow" >
					<span class="user-icon">
                                            <img src="<c:url value="/vendors/images/photo1.jpg"/>" alt="">
					</span>
					<span class="user-name UserName">Use .UserName Class</span>
				</a>
			</div>
			<div class="github-link">
                            <img src="<c:url value="/vendors/images/github.svg"/>" alt=""></a>
			</div>
		</div>
	</div>

	<div class="left-side-bar">
		<div class="brand-logo">
			<a href="index.html">
                            <img src="<c:url value="/vendors/images/deskapp-logo.svg"/>" alt="" class="dark-logo">
                            <img src="<c:url value="/vendors/images/deskapp-logo-white.svg"/>" alt="" class="light-logo">
			</a>
			<div class="close-sidebar" data-toggle="left-sidebar-close">
				<i class="ion-close-round"></i>
			</div>
		</div>

		<div class="menu-block customscroll">
			<div class="sidebar-menu">
				<ul id="accordion-menu">
					<li class="dropdown num1"><!--show-->
						<a href="javascript:;" class="dropdown-toggle">
							<span class="micon dw dw-edit2"></span><span class="mtext">Patient</span>
						</a>
						<ul class="submenu num1submenu"> <!-- style display : block -->
							<li><a class="num1sub1" href="addPatient.jsp">Add Patient</a></li> <!-- class="active"-->
						</ul>
					</li>
                                        <li class="dropdown num2">
						<a href="javascript:;" class="dropdown-toggle">
							<span class="micon dw dw-edit2"></span><span class="mtext">Doctor</span>
						</a>
						<ul class="submenu num2submenu">
							<li><a class="num2sub1" href="addDoctor.jsp">Add Doctor</a></li>

						</ul>
					</li>
					<li class="dropdown num3">
						<a href="javascript:;" class="dropdown-toggle">
							<span class="micon dw dw-library"></span><span class="mtext">Appointment</span>
						</a>
						<ul class="submenu num2submenu">
							<li><a class="num2sub1" href="addAppointment.jsp">Add Appointment</a></li>
							<li><a  class="num2sub2" href="#">Update Appointment</a></li>
						</ul>
					</li>
					<li>
						<a href="calendar.html" class="dropdown-toggle no-arrow">
							<span class="micon dw dw-calendar1"></span><span class="mtext">Generate Bill</span>
						</a>
					</li>

					<li>
						<div class="dropdown-divider"></div>
					</li>
					<li>
						<div class="sidebar-small-cap">Extra</div>
					</li>
					<li>
						<a href="#" target="_blank" class="dropdown-toggle no-arrow">
							<span class="micon dw dw-right-arrow1"></span>
							<span class="mtext">Logout</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="mobile-menu-overlay"></div>

	<div class="main-container">
		<div class="pd-ltr-20 xs-pd-20-10">
			<div class="min-height-200px">
				<div class="page-header">
					<div class="row">
						<div class="col-md-6 col-sm-12">
							<nav aria-label="breadcrumb" role="navigation">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.html">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Add Doctor</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
				<!-- Default Basic Forms Start -->
				<div class="pd-20 card-box mb-30">
					<div class="clearfix">
						<div class="pull-left">
							<h4 class="text-blue h4">Add Doctor</h4>
						</div>
					</div>
					<form class="form" action="addDoctorServlet2" method="POST" >  
                            
                            <div class="row">
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Doctor IC Number</label>
                                        <input class="form-control" type="text" name="employeeICNo" autocomplete="off" placeholder="IC Number">
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Start Date</label>
                                        <input class="form-control" type="datetime-local" name="employeeStartDate" autocomplete="off" placeholder="Start Date">
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Doctor First Name</label>
                                        <input class="form-control" type="text" name="dName" autocomplete="off" placeholder="First Name">
                                    </div>
                                </div>
                                
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Doctor Address</label>
                                        <input class="form-control" type="text" name="employeeAddress" autocomplete="off" placeholder="Address">
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Doctor Last Name</label>
                                        <input class="form-control" type="text" name="dName" autocomplete="off" placeholder="Last Name">
                                    </div>
                                </div>
                                
                                
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input class="form-control" type="text" name="username" autocomplete="off" placeholder="Username">
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Phone Number</label>
                                        <input class="form-control" type="text" name="employeePhone" autocomplete="off" placeholder="Phone Number">
                                    </div>
                                </div>
                                 
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input class="form-control" type="text" name="password" autocomplete="off" placeholder="Password">
                                    </div>
                                </div>
                              
	                        
                                <div class="col-md-6 col-sm-12">
                                    <div class="form-group">
                                        <label class="col-md-4 col-sm-12">Employee Type</label>
											<div class="col-sm-8">
												<select class="form-control selectpicker" name="EmpTypeId" title="Select Employee Type">
													<option value="1">Doctor</option>
													
												</select>
											</div>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="row">
                                <div class="col-md-3 col-sm-12">
                                </div>
                                <div class="col-md-3 col-sm-12">
                                    <input class="btn btn-danger" type="reset" name="Empty" value="Reset">
                                </div>
                                <div class="col-md-3 col-sm-12">
                                </div>
                                <div class="col-md-3 col-sm-12">
                                    <input class="btn btn-primary" type="submit" name="Submit" value="Submit">
                                </div>
                            </div>
                                            
                        </form>
				</div>
				<!-- Input Validation End -->

			</div>
			<div class="footer-wrap pd-20 mb-20 card-box">
				Clinic Management System
			</div>
		</div>
	</div>
	<!-- js -->
	<script src="vendors/scripts/core.js"></script>
	<script src="vendors/scripts/script.min.js"></script>
	<script src="vendors/scripts/process.js"></script>
	<script src="vendors/scripts/layout-settings.js"></script>
</body>
</html>
