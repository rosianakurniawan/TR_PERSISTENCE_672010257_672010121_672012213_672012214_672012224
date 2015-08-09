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
                        <li class=""><a href="transaksiSerMotor">Home</a></li>
                        <li class="active"><a href="#">Lihat Transaksi</a></li>
                    </ul>

                </section>
            </nav>
        </div>
        <br/>
        <%-- form edit --%>
        <div class="row">
            <div class="panel radius large12 columns" >
                <div class="large-12 columns">
                    <h4 id="modalTitle">Lihat Detail Transaksi</h4>

                    <form method="post">
                        <fieldset>
                            <legend>Data Transaksi</legend>
                            <table class="large-12 ">
                                <thead>
                                    <tr>
                                        <th>
                                            <label for="idtrans">ID Transaksi<input type="text" name="idtrans" disabled="true" value="${trans.idTrans}"/></label>
                                        </th>
                                        <th>
                                            <label for="namasewa">Nama Penyewa<input type="text" size="10" name="namasewa" disabled="true" value="${trans.namaSewa}"/></label>                                        
                                        </th>
                                        <th>
                                            <label for="alamat">Alamat<input type="text" size="10" name="alamat" disabled="true" value="${trans.alamat}"/></label>
                                        </th>
                                        <th>
                                            <label for="telp">No Telp<input type="text" size="10" disabled="true" value="${trans.noTelp}" name="telp"/></label>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>Lama Sewa
                                            <select id="lama" name="lama" onchange="javascript:setHarga();" disabled="true">
                                                <c:choose>
                                                    <c:when test="${trans.lamaSewa == '6'}">
                                                        <option value="default" >Pilih Lama Sewa</option>
                                                        <option value="6" selected="selected">6</option>
                                                        <option value="12" >12</option>
                                                        <option value="24" >24</option>
                                                    </c:when>
                                                    <c:when test="${trans.lamaSewa == '12'}">
                                                        <option value="default" >Pilih Lama Sewa</option>
                                                        <option value="6">6</option>
                                                        <option value="12" selected="selected">12</option>
                                                        <option value="24">24</option>
                                                    </c:when>
                                                    <c:when test="${trans.lamaSewa == '24'}">
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
                                        <th>Tarif
                                            <input type="text" name="tarif" id="tarif" value="${trans.tarif}" disabled="true"/>
                                        </th>
                                        <th>
                                            <label for="over">Ambil<input type="date" name="ambil" id="ambil" value="${trans.ambil}" disabled="true" /></label>
                                        </th>
                                        <th>
                                            <label for="over">Kembali<input type="text" id="kembali" name="kembali" disabled="true" value="${trans.kembali}"/></label>
                                        </th>
                                    </tr>
                                </thead>
                            </table>

                            <table class="large-12 ">
                                <thead>
                                    <tr>
                                        <th>
                                            <label for="over">Over Time<input type="text" disabled="true" value="${trans.overTime}" name="over"/></label>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label for="bayar">Bayar<input type="text" value="${trans.bayar}" disabled="true" name="bayar"/></label>
                                        </th>

                                    </tr>
                                </thead>
                            </table>
                        </fieldset>
                    </form>
                </div>
                <div class="large-6 columns">
                    <fieldset>
                        <legend>Data Rental</legend>
                            <p>Pemilik Rental  : ${ren.pemilikRental} 
                            <br>ID Rental      : ${ren.idRental}
                            <br>Nama Rental    : ${ren.namaRental}
                            <br>Alamat Rental  : ${ren.alamat}
                            <br>NO Telp        : ${ren.noTelp}
                            <br>Status Rental  : ${ren.status}
                        </p>
                    </fieldset>
                </div>
                        
                <div class="large-6 columns">
                    <form action="updateKenSer" method="post" >
                        <fieldset>
                            <legend>Data Kendaraan</legend>
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
                        </fieldset>
                    </form>
                </div>
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