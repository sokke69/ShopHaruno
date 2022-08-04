<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品追加</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>

    <script type="text/javascript">

    </script>

</head>

<body>

    <header></header>

    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div class="col-9">
                <div class="display-6">商品追加</div>
                <form action="" method="post">
                    <table border="1" id="list-table">
                        <tr>
                            <th id="head">商品名</th>
                            <td><c:out value="${product.getProductName()}" /></td>
                        </tr>
                        <tr>
                            <th>商品URL</th>
                            <td><c:out value="${product.getProductUrl()}" /></td>
                        </tr>
                        <tr>
                            <th>カテゴリA</th>
                            <td>未実装</td>
                        </tr>
                        <tr>
                            <th>カテゴリB1</th>
                            <td>未実装</td>
                        </tr>
                        <tr>
                            <th>カテゴリB2</th>
                            <td>未実装</td>
                        </tr>
                        <tr>
                            <th>カテゴリB3</th>
                            <td>未実装</td>
                        </tr>
                        <tr>
                            <th>メイン画像</th>
                            <td><c:out value="${product.getImgMain()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像01</th>
                            <td><c:out value="${product.getImgSub01()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像02</th>
                            <td><c:out value="${product.getImgSub02()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像03</th>
                            <td><c:out value="${product.getImgSub03()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像04</th>
                            <td><c:out value="${product.getImgSub04()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像05</th>
                            <td><c:out value="${product.getImgSub05()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像06</th>
                            <td><c:out value="${product.getImgSub06()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像07</th>
                            <td><c:out value="${product.getImgSub07()}" /></td>
                        </tr>
                        <tr>
                            <th>サブ画像08</th>
                            <td><c:out value="${product.getImgSub08()}" /></td>
                        </tr>
                            </td>
                        
                    </table>
                    <input type="submit" value="追加" class="submit">

                    <p><a href="#">戻る</a></p>
                </form>
            </div>
            <div class="col"></div>
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->

    <div>
        <footer>
            <p class="copyright">Copyright &copy 2022 SHOP HARUNO All Rights Reserved.</p>
        </footer>
    </div>

</body>

</html>