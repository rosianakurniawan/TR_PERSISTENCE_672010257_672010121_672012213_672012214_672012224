<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, 
              initial-scale=1.0" />
        <title>Welcome To Rental Web</title>
        <link rel="stylesheet" href="assets/css/foundation.css" />
        <script src="assets/js/vendor/modernizr.js"></script>
        <script type="text/javascript" src="assets/js/ago.js"></script>
        <script type="text/javascript" src="assets/js/jumlah.js"></script>
        <script type="text/javascript" src="assets/js/nominal.js"></script>
        
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
                        <li class=""><a href="bookingSer">Home</a></li>
                        <li class="active"><a href="#">Update</a></li>
                    </ul>

                </section>
            </nav>
        </div>
        <br/>

        <div class="row">
            <div class="large-12 columns">
                <form action="updateBooktoTrans" method="post" onclick="return hitung(this);">
                    <div class="panel radius" >
                        <table class="large-12 ">
                            <thead>
                                <tr>
                                    <th>
                                        <label for="idBook">ID Booking<input type="text" name="idBook" value="${book.idBooking}"/></label>
                                    </th>
                                    <th>
                                        <label for="namasewa">Nama Penyewa<input type="text" size="10" name="namasewa" value="${book.namaSewa}"/></label>                                        
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="alamat">Alamat<input type="text" size="10" name="alamat" value="${book.alamat}"/></label>
                                    </th>
                                    <th>
                                        <label for="telp">No HP<input type="text" size="10" value="${book.noHp}" name="telp"/></label>
                                    </th>
                                </tr>
                                <tr>

                                    <th>Lama Sewa
                                        <select id="lama" name="lama" ">
                                            <c:choose>
                                                <c:when test="${book.lamaSewa == '6'}">
                                                    <option value="default" >Pilih Lama Sewa</option>
                                                    <option value="6" selected="selected">6</option>
                                                    <option value="12" >12</option>
                                                    <option value="24" >24</option>
                                                </c:when>
                                                <c:when test="${book.lamaSewa == '12'}">
                                                    <option value="default" >Pilih Lama Sewa</option>
                                                    <option value="6">6</option>
                                                    <option value="12" selected="selected">12</option>
                                                    <option value="24">24</option>
                                                </c:when>
                                                <c:when test="${book.lamaSewa == '24'}">
                                                    <option value="default" >Pilih Lama Sewa</option>
                                                    <option value="6">6</option>
                                                    <option value="12">12</option>
                                                    <option value="24"selected="selected">24</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="default" >Pilih Lama Sewa</option>
                                                    <option value="6">6</option>
                                                    <option value="12">12</option>
                                                    <option value="24">24</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </th>
                                    <th>
                                        <label for="jenis">Jenis Kendaraan<input type="text" id="jenis" value="${book.jenisKendaraan}" name="jenis" /></label>
                                    </th>
                                </tr>
                            </thead>
                        </table>
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        <label for="booking">Booking<input type="date" name="booking" id="ambil" value="${book.tglBooking}" /></label>
                                    </th>
                                    <th>
                                        <label for="ambil">Ambil<input type="date" id="ambil" name="ambil" value="${book.tglAmbil}" /></label>
                                    </th>
                                </tr>
                            </thead>
                        </table>
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        <label for="idrent">ID Rental<input type="text" id="idrent" value="${book.idRental.idRental}" name="idrent"/></label>
                                    </th>
                                    <th>
                                        <label for="plat">Plat Nomor<input type="text" id="plat" name="plat" value="${book.platNo.platNo}"/></label>
                                    </th>
                                </tr>
                            </thead>
                        </table>
                        <input type="submit" value="Start" class="button small radius" />
                    </div>
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