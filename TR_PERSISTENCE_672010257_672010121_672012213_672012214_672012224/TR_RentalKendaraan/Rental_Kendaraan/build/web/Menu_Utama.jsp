<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <li class="active"><a href="kendaraanSer">Data Kendaraan</a></li>
                        <li><a href="bookingSer">Data Booking</a></li>
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
            <div class="large-12 columns">
                <br/>
                <div class="panel">
                    <h3>Data Kendaraan</h3>
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
                <a href="" class="button small radius" data-reveal-id="myModal">Tambah Kendaraan</a>

                <table style="width: 100%">
                    <thead>
                        <tr>
                            <th style="width: 5%">No</th>
                            <th>ID Rental</th>
                            <th>Plat Nomor</th>
                            <th>Jenis Kendaraan</th>
                            <th>Status</th>
                            <th>Gambar Mobil</th>
                            <th style="width: 20%"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="no" value="1"/>
                        <c:forEach items="${kendaraan}" var="ken">
                            <tr>
                                <td>${no}</td>
                                <td>${ken.idRental.idRental}</td>
                                <td>${ken.platNo}</td>
                                <td>${ken.jenisKendaraan}</td>
                                <td>${ken.status}</td>
                                <td>${ken.gambar}</td>
                                <td>
                                    <a href="hapusKenSer?plat=${ken.platNo}" class="label alert">Delete</a>
                                    <a href="editKenSer?plat=${ken.platNo}" class="label">Update</a>
                                    <a href="ViewKenSer?plat=${ken.platNo}" class="label success">View</a>
                                </td>
                            </tr>
                            <c:set var="no" value="${no+1}"/>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="myModal" class="reveal-modal small" data-reveal 
             aria-labelledby="modalTitle" 
             aria-hidden="true" role="dialog">
            <h4 id="modalTitle">Input Kendaraan</h4>

            <form action="tambahKenSer" method="post" >
                <label for="idrental">ID User<input type="text" name="idrental" disabled="true" value="<%= id%>"/></label>
                <label for="plat">Plat No<input type="text" size="10" name="plat"/></label>
                Jenis Kendaraan
                <select id="jenis" name="jenis">
                    <option value="Motor" > Motor</option>
                    <option value="Mobil" > Mobil</option>
                </select> 
                Status
                <select id="status" name="status"> 
                    <option value="Ada"> Ada</option>
                    <option value="Dipakai"> Dipakai</option>
                </select>
                <label for="gambar">Foto<input type="text" name="gambar"/></label>
                <input type="submit" value="Simpan" class="button small radius"/>
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