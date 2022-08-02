<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>データベース一覧</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>

</head>
<body>

    <header></header>


    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div class="col-10">
                <h1>データベース一覧</h1>
                <table border="1" id="list-table">
                    <tr><td><a href="listProduct">商品一覧</a></td></tr>
                    <tr><td><a href="listCat">カテゴリ一覧</a></td></tr>
                    <tr><td><a href="listUser">ユーザー一覧</a></td></tr>
                
                </table>
                <p><a href="logout">ログアウト</a></p>
            </div>
            <div class="col"></div>
        </div><!--/.row-->
    </div><!--/.container-->


    <div>
        <footer>
            <p class="copyright">Copyright &copy 2022 SHOP HARUNO All Rights Reserved.</p>
        </footer>
    </div>
    
</body>
</html>