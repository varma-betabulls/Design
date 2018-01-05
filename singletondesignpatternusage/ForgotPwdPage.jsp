<%-- 
    Document   : RegistrationPage
    Created on : 15 Aug, 2017, 11:15:01 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h3>Forgot Password Form</h3>
    <body style="background-color: deepskyblue">
        <div id="divId" style="margin-left: 20%;margin-top: 4%;">
            User Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"/><br><br>
            Select City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="citiesList" style="width: 10%">
                <c:forEach var="item" items="${citiesList}">
                    <option>${item}</option>
                </c:forEach>
            </select><br><br>
            Select State:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="statesList" style="width: 10%">
                <c:forEach var="item" items="${statesList}">
                    <option>${item}</option>
                </c:forEach>
            </select><br><br>
            Select Country:&nbsp;&nbsp;&nbsp;<select name="countriesList" style="width: 10%">
                <c:forEach var="item" items="${countriesList}">
                    <option>${item}</option>
                </c:forEach>
            </select><br><br>
            <input type="button" value="submit"/><br><br>
        </div>

    </body>
</html>
