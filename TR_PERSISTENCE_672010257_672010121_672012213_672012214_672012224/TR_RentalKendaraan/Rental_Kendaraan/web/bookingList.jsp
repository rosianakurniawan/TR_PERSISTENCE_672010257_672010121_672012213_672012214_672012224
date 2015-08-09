<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <script type="text/javascript">
            <c:set var="now" value="<%= new java.util.Date()%>"/>
            function setTgl2() {
                var txt_tgl = document.getElementById('ambil');
                txt_tgl.value = '<fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${now}"/>';
            }

            function setTgl1() {
                var txt_tgl = document.getElementById('booking');
                txt_tgl.value = '<fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${now}"/>';
            }

            function setHarga() {
                var lama = document.getElementById('lama');
                var tarif = document.getElementById('tarif');
                if (lama.value == '6') {
                    tarif.value = accounting.formatMoney("125000", "Rp ", 2, ".", ",");
                } else if (lama.value == '12') {
                    tarif.value = accounting.formatMoney("175000", "Rp ", 2, ".", ",");
                } else if (lama.value == '24') {
                    tarif.value = accounting.formatMoney("275000", "Rp ", 2, ".", ",");
                } else {
                    tarif.value = null;
                }
            }
        </script>
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
                        <li class=""><a href="kendaraanSer">Data Kendaraan</a></li>
                        <li class="active"><a href="">Data Booking</a></li>
                        <li class="has-dropdown">
                            <a href="#">Data Transaksi</a>
                            <ul class="dropdown">
                                <li><a href="transaksiSer">Mobil</a></li>
                                <li><a href="transaksiSerMotor">Motor</a></li>
                                <li><a href="AllTransSer">Rekap Transaksi</a></li>
                            </ul>
                        </li>
                        <li class=""><a href="LogoutSer">Log Out</a>
                        </li>
                    </ul>
                </section>
            </nav>
        </div>
        <div class="row">
            <div class="large-12 columns" >
                <br/>
                <div class="panel">
                    <h3>Data Booking </h3>
                    <br/>
                </div>
                <a href="" class="button small radius" data-reveal-id="myModal">Tambah Booking Motor</a>
                <a href="" class="button small radius" data-reveal-id="myModal2">Tambah Booking Mobil</a>
                <div style="width:100%; overflow: auto">
                    <table style="width: 1800px;">
                        <thead>
                            <tr>
                                <th style="width: 5%">No</th>
                                <th>Nama Penyewa</th>
                                <th>No HP</th>
                                <th>Lama Sewa</th>
                                <th>Alamat</th>
                                <th>Tanggal Booking</th>
                                <th>Tanggal Ambil</th>
                                <th>Plat No</th>
                                <th>Jenis Kendaraan</th>
                                <th>ID Rental</th>
                                <th style="width: 10%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="no" value="1"/>
                            <c:forEach items="${booking}" var="bk">
                                <tr>
                                    <td>${no}</td>
                                    <td>${bk.namaSewa}</td>
                                    <td>${bk.noHp}</td>
                                    <td>${bk.lamaSewa}</td>
                                    <td>${bk.alamat}</td>
                                    <td>${bk.tglBooking}</td>
                                    <td>${bk.tglAmbil}</td>
                                    <td>${bk.platNo.platNo}</td>
                                    <td>${bk.platNo.jenisKendaraan}</td>
                                    <td>${bk.idRental.idRental}</td>
                                    <td>
                                        <a href="deleteBooking?idBooking=${bk.idBooking}" class="label alert">Delete</a>
                                        <a href="editBooking?idBooking=${bk.idBooking}" class="label">Start</a>
                                        <a href="ViewBooking?idBooking=${bk.idBooking}" class="label success">View</a>
                                    </td>
                                </tr>
                                <c:set var="no" value="${no+1}"/>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="myModal" class="reveal-modal small" data-reveal 
             aria-labelledby="modalTitle" 
             aria-hidden="true" role="dialog">
            <h4 id="modalTitle">Input Kendaraan</h4>

            <form action="tambahBookingSer" method="post" >
                <label for="namasewa">Nama Penyewa<input type="text" size="10" name="namasewa"/></label>
                <label for="alamat">Alamat<input type="text" size="10" name="alamat"/></label>
                <label for="telp">No HP<input type="text" size="10" name="telp"/></label>

                Plat Kendaraan
                <select id="plat" name="plat">
                    <c:forEach items="${knd}" var="ken">
                        <option value="${ken.platNo}" >${ken.platNo}</option>
                    </c:forEach>
                </select>
                <table >
                    <thead>
                        <tr>
                            <th>Lama Sewa
                                <select id="lama" name="lama" onchange="javascript:setHarga();">
                                    <option value="default" >Pilih Lama Sewa</option>
                                    <option value="6" >6</option>
                                    <option value="12" >12</option>
                                    <option value="24" >24</option>
                                </select>
                            </th>
                        </tr>
                    </thead>
                </table>
                <table style="width: 300px">
                    <thead>
                        <tr>
                            <th>
                                <input type="button" value="Start" id="start" onclick="javascript:setTgl1();">
                            </th>
                            <th>
                                Booking<input type="date" name="booking" id="booking" />
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <input type="button" value="Start" id="start" onclick="javascript:setTgl2();">
                            </th>
                            <th>
                                Ambil<input type="date" id="ambil" name="ambil"/>
                            </th>                            
                        </tr>
                    </thead>
                </table>
                <input type="submit" value="Tambah" class="button small radius"/>
            </form>
            <a class="close-reveal-modal" aria-label="Close">&#215;</a>
        </div>
                            
        <div id="myModal2" class="reveal-modal small" data-reveal 
             aria-labelledby="modalTitle" 
             aria-hidden="true" role="dialog">
            <h4 id="modalTitle">Input Kendaraan</h4>

            <form action="tambahBookingSer" method="post" >
                <label for="namasewa">Nama Penyewa<input type="text" size="10" name="namasewa"/></label>
                <label for="alamat">Alamat<input type="text" size="10" name="alamat"/></label>
                <label for="telp">No HP<input type="text" size="10" name="telp"/></label>

                Plat Kendaraan
                <select id="plat" name="plat">
                    <c:forEach items="${kend}" var="ken">
                        <option value="${ken.platNo}" >${ken.platNo}</option>
                    </c:forEach>
                </select>
                <table >
                    <thead>
                        <tr>
                            <th>Lama Sewa
                                <select id="lama" name="lama">
                                    <option value="default" >Pilih Lama Sewa</option>
                                    <option value="6" >6</option>
                                    <option value="12" >12</option>
                                    <option value="24" >24</option>
                                </select>
                            </th>
                        </tr>
                    </thead>
                </table>
                <table style="width: 300px">
                    <thead>
                        <tr>
                            <th>
                                <input type="button" value="Start" id="start" onclick="javascript:setTgl1();">
                            </th>
                            <th>
                                Booking<input type="date" name="booking" id="booking" />
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <input type="button" value="Start" id="start" onclick="javascript:setTgl2();">
                            </th>
                            <th>
                                Ambil<input type="date" id="ambil" name="ambil"/>
                            </th>                            
                        </tr>
                    </thead>
                </table>
                <input type="submit" value="Tambah" class="button small radius"/>
            </form>
            <a class="close-reveal-modal" aria-label="Close">&#215;</a>
        </div>

        <script src="assets/js/vendor/jquery.js"></script>
        <script src="assets/js/foundation.min.js"></script>
        <script>
                                    $(document).foundation();
        </script>
    </body>
</html>