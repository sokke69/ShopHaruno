<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザー削除</title>
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
            <div class="col-9">
                <div class="display-6">ユーザー削除</div>
                <form action="" method="post">
                    <table border="1" id="list-table">
                        <tr>
                            <th id="head">ID</th>
                            <td><c:out value="${user.id}" /></td>
                        </tr>
                        <tr>
                            <th>ユーザー名</th>
                            <td><c:out value="${user.userNickName}" /></td>
                        </tr>
                        <tr>
                            <th>ユーザーID</th>
                            <td><c:out value="${user.userName}" /></td>
                        </tr>
                        <tr>
                            <th>ユーザータイプ</th>
                            <td><c:out value="${user.typeName}" /></td>
                        </tr>
                    </table>
                    <input type="submit" value="削除" class="submit">

                    <p><a href="listUser">戻る</a></p>
                </form>
            </div>
            <div class="col"></div>
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->

    <div>
        <footer>
            <p class="copyright">Copyright &copy; 2022 SHOP HARUNO All Rights Reserved.</p>
        </footer>
    </div>
    
</body>
</html>