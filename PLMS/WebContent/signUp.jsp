<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>New User<br> 
<form action="SignUpServlet" method="get" >
UserID   : <input type="text" name="userid"><br>
Username : <input type="text" name="username"><br>
Password : <input type="password" name="password"><br>
First Name : <input type="text" name="FirstName"><br>
Last Name : <input type="text" name="LastName"><br>
Mail ID : <input type="text" name="MailID"><br>
Country : <input type="text" name="Country"><br>
Phone No. : <input type="text" name="PhoneNo"><br>
Account No. (USD) : <input type="text" name="AccountUSD"><br> 
Account No. (EUR) : <input type="text" name="AccountEUR"> <br>
Account No. (GBP) : <input type="text" name="AccountGBP"><br>
<input type="submit" value="Add new record">
</form>
</body>
</html>