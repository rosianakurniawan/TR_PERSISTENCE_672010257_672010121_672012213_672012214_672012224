<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <li class=""><a href="kendaraanSer">Home</a></li>
                        <li class="active"><a href="#">Update</a></li>
                    </ul>

                </section>
            </nav>
        </div>
        <br/>

        <br/>
        <%-- form edit --%>
        <div class="row">
            <div class="large-6 columns">
                <h4 id="modalTitle">Input Kendaraan</h4>
                <div class="panel" >
                    <form action="updateKenSer" method="post" >
                        <% String id = (String) session.getAttribute("userID");%>
                        
                        <div class="row collapse">
                            <div class="small-3 large-2 columns">
                                <span class="prefix">Plat No </span>
                            </div>
                            <div class="small-9 large-10 columns">
                                <input type="text" size="10" name="plat" value="${ken.platNo}"/>
                            </div>
                        </div>
                        
                        <div class="row collapse">
                            <div class="small-3 large-2 columns">
                                <span class="prefix">Jenis Kendaraan </span>
                            </div>
                            <div class="small-9 large-10 columns">
                                <select id="jeken" name="jeken" > 
                                    <c:choose>
                                        <c:when test="${ken.jenisKendaraan == 'Motor'}">
                                            <option value="Motor" selected="selected"> Motor</option>
                                            <option value="Mobil" >Mobil</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="Motor" >Motor</option>
                                            <option value="Mobil" selected="selected"> Mobil</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>

                        <div class="row collapse">
                            <div class="small-3 large-2 columns">
                                <span class="prefix">Status </span>
                            </div>
                            <div class="small-9 large-10 columns">
                                <select id="status" name="status"> 
                                    <c:choose>
                                        <c:when test="${ken.status == 'Ada'}">
                                            <option value="Ada" selected="selected"> Ada</option>
                                            <option value="Dipakai" >Dipakai</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="Ada" >Ada</option>
                                            <option value="Dipakai" selected="selected"> Dipakai</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>

                        <div class="row collapse">
                            <div class="small-3 large-2 columns">
                                <span class="prefix">Foto </span>
                            </div>
                            <div class="small-9 large-10 columns">
                                <input type="text" name="gambar" value="${ken.gambar}"/>
                            </div>
                        </div>
                        <input type="submit" value="Update" class="button small radius"/>

                    </form>
                </div>
            </div>
        </div>

        <script src="assets/js/vendor/jquery.js"></script>
        <script src="assets/js/foundation.min.js"></script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>