<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="cssfile.css" type="text/css" />
	<script src="https://cdn.tailwindcss.com"></script>
	<link rel="stylesheet" href="cssfile.css" type="text/css" />
	<title>${param.title}</title>

</head>

<body>
<style >
	#layout {
		width: 100%;
		height: 10vh;
	}
	#banner {
		width: 100%;
		height:5vh;

	}

	.container  {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;

	}
	#menu {
		display: flex;
		justify-content: center;
		align-items: center;
		gap: 30px;
	}
</style>
	<div id="layout" class=" ">
		<div id="banner ">
			<div class="bannerlogo"></div>
			<div class="container">
				<div class="text_header">RCA Management Information System</div>
			<div class="right" style="text-align: right;">
				<c:if test="${authenticatedUser !=null}">
					<b><a href="listuser.php?page=profile&&id=${authenticatedUser.id}"><button>Profile
						</button></a> | <img src="icons/user.png" /> <font color="#ffffff">${authenticatedUser.fullName}</font>
						| <a href="login.php?logout=logout"><font color="#ffffff">Logout</font></a>
					</b>
				</c:if>
				<c:if test="${authenticatedUser ==null}">
					<div class="menu" >
						| <a href="login.php?"><font color="white">Login</font></a> |
					</div>
				</c:if>
			</div>
			</div>

		</div>

		<%@ include file="menu.jsp"%>