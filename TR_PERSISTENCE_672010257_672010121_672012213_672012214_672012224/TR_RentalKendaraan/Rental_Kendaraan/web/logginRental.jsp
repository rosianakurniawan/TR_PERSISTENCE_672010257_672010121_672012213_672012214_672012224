<%@page import="com.sun.corba.se.spi.orbutil.fsm.Input"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, 
              initial-scale=1.0" />
        <title>Welcome To Rental Web</title>
        <link rel="stylesheet" href="assets/css/foundation.css" />
        <script src="assets/js/vendor/modernizr.js"></script>
    </head>
    <body>
        <div class="fixed contain-to-grid">
            <nav class="top-bar" data-topbar role="navigation">
                <ul class="title-area">
                    <li class="name">
                        <h1><a href="#">Web Rentalan</a></h1>
                    </li>
                    <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
                    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
                </ul>

                <section class="top-bar-section">
                    <!-- Right Nav Section -->
                    <ul class="right">
                        <li class=""><a href="index.jsp">Home</a></li>
                        <li class="active"><a href="#">Loggin</a>               
                        </li>
                    </ul>

                </section>
            </nav>
        </div>
        <br/>

        <br/>
        <%-- form loggin --%>
        <div class="row">
            <div class="large-8 columns">                
                <div class="panel">
                    <h3>Selamat Datang</h3>
                    <p>
                        Selamat datang di Rentalan Website, silakan anda loggin 
                        untuk masuk kedalam web
                    </p>
                </div> 
            </div>

            <div class="large-4 columns">
                <form name="login" action="LoginSer" method="post">
                    <label for="id">
                        ID User
                        <input type="text" name="id"/>
                    </label>
                    <label for="user">
                        Username
                        <input type="text" name="user"/>
                    </label>
                    <label for="pass">
                        Password
                        <input type="password" name="pass"/>
                    </label>
                    <input type="submit" class="button small radius" value="Login"/>
                </form>
            </div>
        </div>
        <script src="assets/js/vendor/jquery.js"></script>
        <script src="assets/js/foundation.min.js"></script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>