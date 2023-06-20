<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/21/2023
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="cssfile.css" type="text/css" />
    <link rel="stylesheet" href="css/displaytag.css" type="text/css" />
    <link rel="stylesheet" href="css/screen.css" type="text/css" />
    <link rel="stylesheet" href="css/site.css" type="text/css" />
    <title>Student Registrations</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddd;
            text-align: left;
            padding: 8px;
        }

        thead{
            background-color: #00009C;
            color: white;
            font-family: 'Quicksand', sans-serif;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="layout">
    <div id="banner">
        <div class="bannerlogo"></div>
        <div class="text_header">RCA Management Information System</div>
        <div class="right" style="text-align: right;">
            <c:if test="${authenticatedUser !=null}">
                <b> <a
                        href="listuser.php?page=profile&&id=${authenticatedUser.id}"><button>Profile
<%--                </button></a> | <img src="icons/cou.png" /> <font color="#ffffff">${authenticatedUser.userRole}:--%>
                        ${authenticatedUser.username}</font> | <a href="login.ap?page=logout"><font
                        color="#ffffff">Logout</font></a>
                </b>
            </c:if>
            <c:if test="${authenticatedUser ==null}">
                <div class="menu" align="left">
                    | <a href="login.php?">Login</a> |
                </div>
            </c:if>
        </div>
    </div>
    <div>
        <%@ include file="menu.jsp"%>
    </div>
    <div id="middle">
        <c:if test="${authenticatedUser !=null}">
            <div class="options">

                <a href="createmark.php?page=createmark"><button>
                    <img src="icons/add.png" /> New marks Registration
                </button></a>
            </div>
            <div class="search">
                <form action="listmark.php" method="get">
                    <table>
                        <tr>
                            <td style="color: #000000;">Enter marks ID</td>
                            <td><input type="text" name="id" id="id" /></td>
                            <td><input type='submit' name="markSearch"
                                       value='search' /></td>
                        </tr>
                    </table>
                </form>
            </div>
            <hr />
            <table style="border: 0;">
                <td align="left"><input type="text" size="15"
                                        maxlength="50" readonly="readonly" name="savedBy" id="savedBy"
                                        hidden="hidden" value="${authenticatedUser.id}" /></td>


                <table>
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>course</td>
                        <td>marksScored</td>
                        <td>totalMarks</td>
                        <td>student</td>
                        <td>grade</td>

                            <%--              <td>isCancelled</td>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${marks}" var="mark" varStatus="usrstatus">
                        <tr>
                            <td>${mark.id}</td>
                            <td>${mark.course.getName()}</td>
                            <td>${mark.marksScored}</td>
                            <td>${mark.totalMarks}</td>
                            <td>${mark.student.getFirstName()}</td>
                            <td>${mark.grade}</td>

                                <%--                <td>${csr.isCancelled}</td>--%>
                            <td><input type="checkbox" name="usrIds"
                                       value="${usr.id}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </table>
        </c:if>
    </div>
<%@ include file="footer.jsp"%>