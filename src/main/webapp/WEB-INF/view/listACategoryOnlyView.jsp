<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カテゴリ一覧</title>
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
                <table><tr><td><div class="display-6">カテゴリ一覧</div></td></tr></table>
                <table id="list-table" class="table table-hover">
                    <thead><tr>
                        <th id="id">ID</th>
                        <th id="user-name">カテゴリ</th>
                    </tr></thead>
                    
                    <tbody><c:forEach items="${aCategoryList}" var="aCategoryList" varStatus="vs">
                    <tr>
                        <td><c:out value="${aCategoryList.id}" /></td>
                        <td><c:out value="${aCategoryList.aCategoryName}" /></td>
                    </tr>
                    </c:forEach></tbody>
                    
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