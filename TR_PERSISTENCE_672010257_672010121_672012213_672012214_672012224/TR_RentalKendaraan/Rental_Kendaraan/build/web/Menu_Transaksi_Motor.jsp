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
                var txt_tgl = document.getElementById('kembali');
                txt_tgl.value = '<fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${now}"/>';
                var ambil = document.getElementById('ambil').value;
                if (ambil != '') {
                    hitung();
                }
            }

            <c:set var="now" value="<%= new java.util.Date()%>"/>
            function setTgl1() {
                var txt_tgl = document.getElementById('ambil');
                txt_tgl.value = '<fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${now}"/>';
            }

            function p(i)
            {
                return Math.floor(i / 10) + "" + i % 10;
            }

            function trunc(i)
            {
                var j = Math.round(i * 100);
                return Math.floor(j / 100) + (j % 100 > 0 ? "." + p(j % 100) : "");
            }

            function hitung() {
                var ambil = $('#ambil').val();
                var kembali = $('#kembali').val();

                var date1 = new Date(ambil);
                var date2 = new Date(kembali);
                var sec = date2.getTime() - date1.getTime();

                if (isNaN(sec))
                {
                    alert("Input data is incorrect!");
                    return;
                }
                if (sec < 0)
                {
                    alert("The second date ocurred earlier than the first one!");
                    return;
                }

                var second = 1000, minute = 60 * second, hour = 60 * minute, day = 24 * hour;
                var aa = trunc(sec / hour);
                var days = Math.floor(sec / day);
                sec -= days * day;
                var hours = Math.floor(sec / hour);
                sec -= hours * hour;
                var over = document.getElementById('over');
                over.value = aa;
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
                        <li class=""><a href="bookingSer">Data Booking</a></li>
                        <li class="has-dropdown active">
                            <a href="#">Data Transaksi</a>
                            <ul class="dropdown">
                                <li><a href="transaksiSer">Mobil</a></li>
                                <li class="active"><a href="transaksiSerMotor">Motor</a></li>
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
                    <h3>Data Transaksi Motor</h3>
                    <br/>
                    <% String id = (String) session.getAttribute("userID");%>
                </div>

                <div class="row collapse">
                    <div class="small-3 large-4 columns">
                        <span class="prefix">Status kendaraan Rental</span>
                        <select id="statusKen" nama="statusKen"> 
                            <option value="Ada" selected="selected"> Ada</option>
                            <option value="Habis" >Habis</option>
                        </select>
                    </div>
                </div>
                <a href="" class="button small radius" data-reveal-id="myModal">Tambah Transaksi</a>
                <div style="width:100%; overflow: auto">
                    <table style="width: 1800px;">
                        <thead>
                            <tr>
                                <th style="width: 5%">No</th>
                                <th>Nama Penyewa</th>
                                <th>Alamat</th>
                                <th>No Telp</th>
                                <th>Lama Sewa</th>
                                <th>Tarif</th>
                                <th>Ambil</th>
                                <th>Kembali</th>
                                <th>Over Time</th>
                                <th>Bayar</th>
                                <th>Plat NO</th>
                                <th>ID Rental</th>
                                <th>Jenis Kendaraan</th>
                                <th style="width: 10%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="no" value="1"/>
                            <c:forEach items="${transaksi}" var="tr">
                                <tr>
                                    <td>${no}</td>
                                    <td>${tr.namaSewa}</td>
                                    <td>${tr.alamat}</td>
                                    <td>${tr.noTelp}</td>
                                    <td>${tr.lamaSewa}</td>
                                    <td>${tr.tarif}</td>
                                    <td>${tr.ambil}</td>
                                    <td>${tr.kembali}</td>
                                    <td>${tr.overTime}</td>
                                    <td>${tr.bayar}</td>
                                    <td>${tr.platNo.platNo}</td>
                                    <td>${tr.idRental.idRental}</td>
                                    <td>${tr.platNo.jenisKendaraan}</td>
                                    <td>
                                        <a href="hapusTransSerMotor?idtrans=${tr.idTrans}" class="label alert">Delete</a>
                                        <a href="motorEditTrans?idtrans=${tr.idTrans}" class="label">Stop</a>
                                        <a href="motorViewDetail?idtrans=${tr.idTrans}" class="label success">View</a>
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

            <form action="tambahTransSerMotor" method="post" >
                <label for="namasewa">Nama Penyewa<input type="text" size="10" name="namasewa"/></label>
                <label for="alamat">Alamat<input type="text" size="10" name="alamat"/></label>
                <label for="telp">No Telp<input type="text" size="10" name="telp"/></label>
                Plat Nomor
                <select id="plat" name="plat" >
                    <c:forEach items="${kend}" var="ken">
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
                            <th>Tarif
                                <input type="text" name="tarif" id="tarif"/>
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
                                Ambil<input type="date" name="ambil" id="ambil" />
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <input type="button" value="Start" id="start" disabled="true" onclick="javascript:setTgl2();">
                            </th>
                            <th>
                                Kembali<input type="text" id="kembali" disabled="true" name="kembali"/>
                            </th>                            
                        </tr>
                    </thead>
                </table>
                <label for="over">Over Time<input type="number" name="over" value="0" disabled="true"/></label>
                <label for="bayar">Bayar<input type="number" name="bayar" value="0" disabled="true"/></label>
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