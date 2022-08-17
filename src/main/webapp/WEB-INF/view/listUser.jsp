<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザー一覧</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/list_style.css">
    <link rel="stylesheet" href="./css/hf_style.css">

    <script src="./js/bootstrap.bundle.min.js"></script>
    <script src="./js/jquery-3.6.0.min.js"></script>
</head>

<body>
<c:import url="parts/header.jsp" />

    <div class="container" id="body">
        <div class="row">
            <div class="col"></div>
            <div class="col-8">
                <div class="display-6">ユーザー一覧</div>
                <a href="addUser">ユーザー追加</a>
                <table id="list-table" class="table table-hover">
                    <thead><tr>
                        <th id="update"></th>
                        <th id="delete"></th>
                        <th id="id">ID</th>
                        <th>ユーザー名</th>
                        <th id="user-name">ユーザーID</th>
                        <th id="user-types">ユーザータイプ</th>
                    </tr></thead>
                    <c:forEach items="${userList}" var="userList" varStatus="vs">
                    <tr>
                        <td><a href="updateUser?id=${userList.id}">編集</a></td>
                        <td><a href="deleteUser?id=${userList.id}">削除</a></td>
                        <td><c:out value="${userList.id}" /></td>
                        <td><c:out value="${userList.userNickName}" /></td>
                        <td><c:out value="${userList.userName}" /></td>
                        <td><c:out value="${userList.typeName}" /></td>
                    </tr>
                    </c:forEach>
                    
                </table>
                <p><a href="listDb">戻る</a></p>
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