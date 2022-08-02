<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SHOP HARUNO</title>

    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Kiwi+Maru:wght@300&family=Kaisei+Opti&family=Klee+One&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="./css/index_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#photo-mini-1 img').click(function () {
                let src = $(this).attr('src');
                console.log(src);
                $('#photo-large-1 img').attr('src', src);
            })
            $('#photo-mini-2 img').click(function () {
                let src = $(this).attr('src');
                console.log(src);
                $('#photo-large-2 img').attr('src', src);
            })
        });
    </script>


</head>

<body>


    <div class="navi">

        <nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">MENU</a>
                <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#menu">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">HOME</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">ABOUT</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Q&A</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">CONTACT</a>
                        </li>
                    </ul>
                </div>
                <!--/.collapse.navbar-collapse-->
            </div>
            <!--/.container-->

        </nav>

    </div>

    <div class="title">

        <div class="row">
            <div class="logo_back">
                <table height="400" class="logo">
                    <td align="center" valign="middle">*ショップ ハルノ*</td>
                </table>
            </div>
        </div>
        <!--/.row-->

    </div>
    <!--/.title-->

    <div class="category-a">
        <div class="container">
            <div class="row">
                <div class="col-2"></div>
                <div class="col">
                    <table class="category-table" align="center">

                        <td class="text"><a href="#">カテゴリA01</a></td>

                        <td class="text"><a href="#">カテゴリA02</a></td>

                        <td class="text"><a href="#">カテゴリA03</a></td>

                        <td class="text"><a href="#">カテゴリA04</a></td>

                        <td class="text"><a href="#">カテゴリA05</a></td>

                        <td class="text"><a href="#">カテゴリA06</a></td>

                        <td class="text"><a href="#">カテゴリA07</a></td>

                        <td class="text"><a href="#">カテゴリA08</a></td>
                    </table>
                </div>
                <div class="col-2"></div>
            </div>
        </div>
        <!--/.container-->
    </div>
    <!--/.category-->

    <div class="category-b">
        <div class="container">
            <div class="row">
                <div class="col-2"></div>
                <div class="col">
                    <table class="category-table" align="center">

                        <td class="text"><a href="#">カテゴリB01</a></td>

                        <td class="text"><a href="#">カテゴリB02</a></td>

                        <td class="text"><a href="#">カテゴリB03</a></td>

                        <td class="text"><a href="#">カテゴリB04</a></td>

                        <td class="text"><a href="#">カテゴリB05</a></td>

                        <td class="text"><a href="#">カテゴリB06</a></td>

                        <td class="text"><a href="#">カテゴリB07</a></td>

                    </table>
                </div>
                <div class="col-2"></div>
            </div>
        </div>
        <!--/.container-->
    </div>
    <!--/.category-->

    <div class="products">
        <div class="container">
            <div class="row">
                <div align="center">
                    <div class="row">
                    
                    <c:forEach items="" var="" varStatus="vs">
                    <div class="col">
                            <table width="560px" height="260px">
                                <tr>
                                    <th height="240px" class="large">
                                        <div id="photo-large-1" class="photo-large"><img src="../imgs/1/main.jpg" alt=""
                                                width="320px" height="240px">
                                        </div>
                                        <!--/.photo-large-->

                                    </th>
                                    <td height="240px" width="240px" class="mini">
                                        <div id="photo-mini-1" class="img-table">
                                            <ul>
                                                <li><img src="../imgs/1/main.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_01.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_02.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_03.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_04.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_05.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_06.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_07.jpg" alt=""></li>
                                                <li><img src="../imgs/1/sub_08.jpg" alt=""></li>
                                            </ul>
                                        </div>
                                    </td>

                                </tr>

                                <tr>
                                    <td colspan="2" id="table-products"><a href="#">Canon コンパクトデジタルカメラ PowerShot SX620
                                            HS ブラック
                                            光学25倍ズーム/Wi-Fi対応
                                            PSSX620HSBK</a></td>
                                </tr>
                            </table>
                        </div>
                    </c:forEach>
                    
                    
                        
                        <!--ここから消さない-->
                        <div class="col">
                            <table width="560px">
                            </table>
                        </div>
                        <!--ここまで消さない-->

                    </div>
                <!--/.row-->
            </div>
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->
    </div>
    <!--/.products-->

    <div>
        <footer>
            <p class="copyright">Copyright &copy 2022 SHOP HARUNO All Rights Reserved.</p>
        </footer>
    </div>




</body>

</html>