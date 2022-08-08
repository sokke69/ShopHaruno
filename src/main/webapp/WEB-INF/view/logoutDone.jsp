<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログアウト</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/loginout_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
</head>
<body>

    <header></header>

    <div class="container" id="body">
        <div class="row">
            <div class="col"></div>
            <div class="col-5">
                    <div class="title"><div class="display-6"><div class="logout-center">ログアウトしました</div></div></div>
                    <p class="logout-center"><a href="login">ログイン画面へ戻る</a></p>
                    <p class="logout-center"><a href="index">トップページへ戻る</a></p>
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