<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dao.JdbcConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">

<table border="2">
<tr>
<td>CURRENCY</td>
<td>BID RATE</td>
<td>ASK RATE</td>
</tr>
<%
try
{
	JdbcConnection JC=new JdbcConnection();
	Connection con=JC.openConnection();
    String query="select * from interest_rate";

    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery(query);
    
    while(rs.next())
    {

    %>
        <tr>
        <td><%=rs.getString("CURRENCY") %></td>
        <td><%=rs.getFloat("BID_RATE") %></td>
        <td><%=rs.getFloat("ASK_RATE")%></td>
        </tr>
   <%
   }%>
   
   </table>
    <%
    rs.close();
    stmt.close();
    con.close();
}
   catch(Exception e)
{
	    e.printStackTrace();
}
   %>
   </form>

</body>
</html>