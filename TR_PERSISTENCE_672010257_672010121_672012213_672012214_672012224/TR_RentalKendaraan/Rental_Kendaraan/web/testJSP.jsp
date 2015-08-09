<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <script type="text/javascript" src="assets/js/moment.min.js"></script>
        <script type="text/javascript" src="assets/js/jumlah.js"></script>


    </head>
    <body>

        <div class="row">
            <div class="large-12 columns">
                <form action="#" method="post" >
                    <div class="panel radius" >
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        Lama Sewa<input type="text" name="lama" id="lama" />
                                    </th>
                                    <th>
                                        tarif<input type="text" name="tarif" id="tarif" />
                                    </th>
                                    <th>
                                        Biaya Over<input type="text" name="bOver" id="bOver" />
                                    </th>
                                </tr>
                            </thead>
                        </table>
                        
                        <table>
                            <thead>
                                <tr>
                                    <th>
                                        <input type="button" value="Start" id="start" onclick="javascript:setTgl1()">
                                    </th>
                                    <th>
                                        Ambil<input type="text" name="ambil" id="ambil" />
                                    </th>
                                    <th>
                                        <label for="bayar">Bayar
                                            <input type="text" id="bayar" name="bayar"/></label>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <input type="button" value="Start" id="start" onclick="javascript:setTgl2()">
                                    </th>
                                    <th>
                                        Kembali<input type="text" id="kembali" name="kembali" />
                                    </th>                                                                
                                    <th>
                                        Over Time<input type="text" id="over" name="over" />
                                    </th>
                                </tr>

                            </thead>
                        </table>
                    </div>
                </form>
            </div>
        </div>
        <script src="assets/js/vendor/jquery.js"></script>
        <script src="assets/js/foundation.min.js"></script>
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
                                                var tarif = parseFloat($('#tarif').val());
                                                var lama = parseInt($('#lama').val());
                                                var bayar = document.getElementById('bayar');
                                                var bOver = document.getElementById('bOver');
                                                
                                                var tOver = aa - lama;
                                                over.value = tOver;
                                                var bo = tOver * 12000;
                                                bOver.value = accounting.formatMoney(bo, "Rp ", 2, ".", ",");
                                                var by = bo + tarif;
                                                bayar.value = accounting.formatMoney(by, "Rp ", 2, ".", ",");
                                            }
        </script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>