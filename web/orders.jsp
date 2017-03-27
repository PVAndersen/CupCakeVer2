<%-- 
    Document   : orders
    Created on : Mar 10, 2017, 6:52:31 AM
    Author     : PVA
--%>

<%@page import="cake.CakeBottom"%>
<%@page import="cake.CakeTopping"%>
<%@page import="java.util.List"%>
<%@page import="entyties.OrderLine"%>
<%@page import="entyties.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%User user = (User) session.getAttribute("user");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <title>Welcome <%=user.getName()%></title>
    </head>

    <body onload="myFunction4()">
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">TheEriks</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="login.html">Enter</a></li>
                            <li class="active"><a href="#">Home</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <%
                                        List<OrderLine> cartList = (List<OrderLine>) request.getSession().getAttribute("cartList");
                                    %>
                                    <%= user.getName()%>
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Balance: <%= user.getForBal()%> </a></li>
                                    <li><a href="#">action</a></li>
                                </ul>                
                            <li role="separator" class="divider"></li>    
                            <li>
                                <a href="#">
                                    <form action="ControlServlet" method="post">
                                        <input type="hidden" name="whoareyou" value="logout">
                                        <input type="submit" name="Logout" value="Logout">
                                    </form>
                                </a>
                            </li>
                            </li>
                        </ul>
                    </div>    
                </div>
            </nav>
        </div>
        <header class="container">
            <div class="page-header">
                <br><br><br><br><br>
                <h1>Erik CupCakes!</h1>                    
            </div>
        </header>
              <main>
                    <div class="container">
                        <div class="collapse">
                            <ul class="list-group">                              
                                
                                
                            </ul>
                        </div>



                </main>

            </div>                      
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
