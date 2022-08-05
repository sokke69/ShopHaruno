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
                            <td><input type="text" placeholder="商品名" name="product-name" id="longform"></td>
                        </tr>
                        <tr>
                            <th>商品URL</th>
                            <td><input type="text" value="https://" name="product-url" id="longform"></td>
                        </tr>
                        <tr>
                            <th>カテゴリA</th>
                            <td> 
                            <select name="a-category-id" id="selectform">
                            <option value="">--選択--</option>
                            <c:forEach items="${aCategoryList}" var="aCategoryList" varStatus="vs">
                            <option value="${aCategoryList.id}"><c:out value="${aCategoryList.aCategoryName}" /></option>
                            </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <th>カテゴリB</th>
                            <td>未実装</td>
                        </tr>
                        <tr>
                            <th>メイン画像</th>
                            <td>
                                <input type="text" value="./imgs/■/main.jpg" name="product-img-main">
                            </td>
                        </tr>
                        <tr><th>サブ画像01</th><td><input type="text" value="./imgs/■/sub_01.jpg" name="product-img-sub-01" class="form-sub"></td></tr>
                        <tr><th>サブ画像02</th><td><input type="text" value="./imgs/■/sub_02.jpg" name="product-img-sub-02" class="form-sub"></td></tr>
                        <tr><th>サブ画像03</th><td><input type="text" value="./imgs/■/sub_03.jpg" name="product-img-sub-03" class="form-sub"></td></tr>
                        <tr><th>サブ画像04</th><td><input type="text" value="./imgs/■/sub_04.jpg" name="product-img-sub-04" class="form-sub"></td></tr>
                        <tr><th>サブ画像05</th><td><input type="text" value="./imgs/■/sub_05.jpg" name="product-img-sub-05" class="form-sub"></td></tr>
                        <tr><th>サブ画像06</th><td><input type="text" value="./imgs/■/sub_06.jpg" name="product-img-sub-06" class="form-sub"></td></tr>
                        <tr><th>サブ画像07</th><td><input type="text" value="./imgs/■/sub_07.jpg" name="product-img-sub-07" class="form-sub"></td></tr>
                        <tr><th>サブ画像08</th><td><input type="text" value="./imgs/■/sub_08.jpg" name="product-img-sub-08" class="form-sub"></td></tr>
                    </table>
                    <input type="submit" value="追加" class="submit">

                    <p><a href="listProduct">戻る</a></p>
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