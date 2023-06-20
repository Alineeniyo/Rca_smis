<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jazzy Bruno
  Date: 4/22/2023
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #f2f2f2;
        }

        .container {
            margin: 50px auto;
            margin-top: 10%;
            width: 400px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
            position: relative;
            justify-content: center;
            display: flex;
            flex-direction: column;
        }

        .container img {
            position: absolute;
            top: -50px;
            left: 50%;
            transform: translateX(-50%);
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background-color: #ffffff;
            padding: 5px;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
        }

        h2 {
            text-align: center;
            color: #333333;
            font-family: 'Quicksand', sans-serif;
            margin-top: 10px;
        }

        p, a {
            text-align: center;
            font-family: 'Quicksand', sans-serif;
            text-decoration: none;
        }
        input[type="text"], input[type="password"] , select , input[type="date"] , input[type="number"] {
            width: 93%;
            padding: 10px;
            margin-bottom: 20px;
            border: none;
            border-radius: 5px;
            background-color: #f2f2f2;
            color: #333333;
            font-size: 16px;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #00009C;
            color: #ffffff;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
        }



        option {
            color: #333333;
        }

    </style>
</head>
<body>
<div class="container">
    <img src="https://media.licdn.com/dms/image/C560BAQEl6a9tUkSKfg/company-logo_200_200/0/1558604414993?e=2147483647&amp;v=beta&amp;t=liCSw94UkEjwbMZZh8N23ZMYixEAMmZNq2IftvsF97Y"
         alt="LinkedIn Logo">
    <h2>Create Mark</h2>
    <p>Welcome to RCA SMIS marks Creation Please Enter Details!!</p>
    <c:if test="${CreateMarkerror != null}">
        <p>
            <span style="color: red"> ${CreateMarkerror}</span>
        </p>
    </c:if>
    <c:if test="${successMark != null}">
        <p>
            <span style="color: green"> ${successMark}</span>
        </p>
    </c:if>
    <form  action="createmark.php?page=createmark" method="post">
        <input type="text" placeholder="grade" required name="grade">
        <input type="number" placeholder="marksScored" required name="marksScored">
        <input type="number" placeholder="totalMarks" required name="totalMarks">
        <select name="course">
            <Option>select course</Option>
            <c:forEach items="${courses}" var="course">
                varStatus="coursestatus">
                <option value="${course.id}">
                    <c:out value="${course.name}"/>
                </option>
            </c:forEach>
        </select>
            <select name="student">
                <Option>select student</Option>
                <c:forEach items="${students}" var="student">
                    varStatus="studentstatus">
                    <option value="${student.id}">
                        <c:out value="${student.firstName}"/>
                    </option>
                </c:forEach>

        </select>
        <input type="submit" value="Create Mark">
    </form>

    <p>
        <a href="listmark.php?page=marks&&user_role=adm&&action=list">
            All Marks
        </a>
    </p>
</div>
</body>
</html>