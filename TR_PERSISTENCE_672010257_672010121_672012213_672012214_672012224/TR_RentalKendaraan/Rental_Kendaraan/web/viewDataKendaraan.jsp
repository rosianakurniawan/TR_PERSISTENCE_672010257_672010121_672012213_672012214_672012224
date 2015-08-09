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
                        <li class="active"><a href="#">View</a></li>
                    </ul>

                </section>
            </nav>
        </div>
        <br/>

        <br/>
        <%-- form edit --%>
        <div class="row">
            <div class="panel large-12 column">
            <div class="large-5 columns">
                <fieldset>
                    <legend>Data Kendaraan</legend>
                <div class="panel callout radius" >
                    <form action="updateKenSer" method="post" >
                        <% String id = (String) session.getAttribute("userID");%>

                        <div class="row collapse">
                            <div class="small-3 large-4 columns">
                                <span class="prefix">Plat No </span>
                            </div>
                            <div class="small-9 large-8 columns">
                                <input type="text" size="10" name="plat" disabled="true" value="${ken.platNo}"/>
                            </div>
                        </div>

                        <div class="row collapse">
                            <div class="small-3 large-4 columns">
                                <span class="prefix">Jenis Kendaraan </span>
                            </div>
                            <div class="small-9 large-8 columns">
                                <select id="jeken" name="jeken" disabled="true"> 
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
                            <div class="small-3 large-4 columns">
                                <span class="prefix">Status </span>
                            </div>
                            <div class="small-9 large-8 columns">
                                <select id="status" name="status" disabled="true"> 
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
                            <div class="small-3 large-4 columns">
                                <span class="prefix">Foto </span>
                            </div>
                            <div class="small-9 large-8 columns">
                                <input type="text" name="gambar" value="${ken.gambar}"/>
                            </div>
                        </div>
                    </form>
                </div>
                </fieldset>
            </div>
            
            <div class="large-7 columns">
                <fieldset>
                    <legend>Data Rental</legend>
                <div class="panel callout radius " >
                    <p>Pemilik Rental  : ${ren.pemilikRental} 
                    <br>ID Rental      : ${ren.idRental}
                    <br>Nama Rental    : ${ren.namaRental}
                    <br>Alamat Rental  : ${ren.alamat}
                    <br>NO Telp        : ${ren.noTelp}
                    <br>Status Rental  : ${ren.status}
                    <br> data rental tempat dimana kendaraan berada
                    </p>
                </div>
                </fieldset>
            </div>
        </div>
        </div>
        <script src="assets/js/vendor/jquery.js"></script>
        <script src="assets/js/foundation.min.js"></script>
        <script src="js/foundation/foundation.topbar.js"></script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>