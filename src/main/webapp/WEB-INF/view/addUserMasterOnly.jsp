<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザー追加</title>
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
                        <div class="display-6">ユーザー追加</div>
                        <form action="" method="post">
                        <table id="list-table" class="table table-hover">
                            <tr><th>ユーザー名</th><td><input type="text" name="request-user-nick-name"></td></tr>
                            <tr><th>ユーザーID</th><td><input type="text" name="request-user-name"></td></tr>
                            <tr><th>パスワード</th><td><input type="password" name="request-user-pass"></td></tr>
                            <tr><th>パスワード(確認)</th><td><input type="password" name="request-user-pass-check"></td></tr>
                            <tr><th>ユーザータイプ</th><td>
                                <select name="request-user-type" id="">
                                    <option value="">--選択--</option>
                                    <c:forEach items="${userTypeList}" var="userTypeList" varStatus="vs">
                                    <option value="${userTypeList.id}"><c:out value="${userTypeList.typeName}" /></option>
                                    </c:forEach>
                                    
                                </select>
                            </td></tr>
                        </table>
                        <input type="submit" value="登録" class="submit">
                        </form>
                        <p><a href="listUser">戻る</a></p>

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