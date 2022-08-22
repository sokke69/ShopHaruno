<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>マイアカウント</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    
    
    
</head>

<body>
<c:import url="parts/header.jsp" />

    <div class="container" id="body">
        <div class="row">
            <div class="col"></div>
            <div class="col-8">
                <div id="add-update-user">
                <table><tr><td><div class="display-6">マイアカウント</div></td><td><a href="updateMyData" id="add" class="btn btn-primary">編集</a></td></tr></table>
            
                    <table id="list-table" class="table table-hover">
                        <tr>
                            <th>ユーザー名</th>
                            <td>
                            <c:out value="${myData.userNickName}" />
                        </tr>
                        <tr>
                            <th>ログインID</th>
                            <td>
                            <c:out value="${myData.userName}" />
                        </tr>
                        <tr>
                            <th>ログインパスワード</th>
                            <td>表示できません</td>
                        </tr>
                    </table>
                    
                    <p><a href="listDb">データベース一覧へ戻る</a></p>
            </div>
                </div>
            <div class="col"></div>
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->

    <div>
        <footer>
            <c:import url="parts/footer.jsp" />
        </footer>
    </div>

</body>

</html>