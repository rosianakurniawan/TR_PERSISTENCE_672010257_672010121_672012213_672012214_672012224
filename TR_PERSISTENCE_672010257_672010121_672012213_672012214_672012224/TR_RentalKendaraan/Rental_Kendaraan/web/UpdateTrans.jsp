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
                var tarif = parseFloat(accounting.unformat($('#tarif').val(), ","));
                var lama = parseInt($('#lama').val());
                var bayar = document.getElementById('bayar');
                var bOver = document.getElementById('bOver');
                var hslTgl = parseInt(aa);
                var tOver = aa - lama;
                over.value = accounting.toFixed(tOver, 2);
                var bo = tOver * 12000;
                bOver.value = accounting.formatMoney(bo, "Rp ", 2, ".", ",");
                var by = bo + tarif;
                bayar.value = accounting.formatMoney(by, "Rp ", 2, ".", ",");
            }
            function setHarga() {
                var lama = document.getElementById('lama');
                var tarif = document.getElementById('tarif');
                if (lama.value == '6') {
                    tarif.value = '125.000';
                } else if (lama.value == '12') {
                    tarif.value = '175.000';
                } else if (lama.value == '24') {
                    tarif.value = '275.000';
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
                        <li class=""><a href="transaksiSer">Home</a></li>
                        <li class="active"><a href="#">Update</a></li>
                    </ul>

                </section>
            </nav>
        </div>
        <br/>

        <div class="row">
            <div class="large-12 columns">
                <form action="updateTransSer" method="post" onclick="return hitung(this);">
                    <div class="panel radius" >
                        <table class="large-12 ">
                            <thead>
                                <tr>
                                    <th>
                                        <label for="idtrans">ID Transaksi<input type="text" name="idtrans" value="${trans.idTrans}"/></label>
                                    </th>
                                    <th>
                                        <label for="namasewa">Nama Penyewa<input type="text" size="10" name="namasewa" value="${trans.namaSewa}"/></label>                                        
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="alamat">Alamat<input type="text" size="10" name="alamat" value="${trans.alamat}"/></label>
                                    </th>
                                    <th>
                                        <label for="telp">No Telp<input type="text" size="10" value="${trans.noTelp}" name="telp"/></label>
                                    </th>
                                </tr>
                                <tr>

                                    <th>Lama Sewa
                                        <select id="lama" name="lama" onchange="javascript:setHarga();">
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
                                        <input type="text" name="tarif" id="tarif" value="${trans.tarif}"/>
                                    </th>
                                </tr>
                            </thead>
                        </table>
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        <input type="button" disabled="true" value="Start" id="start" onclick="javascript:setTgl1()"/>
                                    </th>
                                    <th>
                                        Ambil<input type="date" name="ambil" id="ambil" value="${trans.ambil}" />
                                    </th>
                                    <th>
                                        <label for="bayar">Over Time<input type="text" id="over" name="over"/></label>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <input type="button" value="Start" id="start" onclick="javascript:setTgl2()"/>
                                    </th>
                                    <th>
                                        Kembali<input type="text" id="kembali" name="kembali" />
                                    </th>
                                    <th>
                                        <label for="bOver">Biaya Over Time<input type="text" id="bOver" name="bOver"/></label>
                                    </th>
                                </tr>
                            </thead>
                        </table>
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        Total Bayar<input type="text" id="bayar" name="bayar"/></label>
                                    </th>
                                    <th>
                                        Plat Nomor<input type="text" id="plat" name="plat" value="${trans.platNo.platNo}"/></label>
                                    </th>
                                </tr>
                            </thead>
                        </table>
                        <input type="submit" value="Simpan" class="button small radius" />
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