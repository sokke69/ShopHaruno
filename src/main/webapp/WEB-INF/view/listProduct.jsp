<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品一覧</title>
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
            <h1>商品一覧</h1>
            <a href="#">商品追加</a>
            <table border="1" id="list-table">
                <tr>
                <th id="update"></th>
                <th id="delete"></th>
                <th id="id">ID</th>
                <th id="product-name">商品名</th>
                <th id="product-url">商品URL</th>
                <th>追加日</th>
                <th>追加ユーザー</th>
                <th>編集日</th>
                <th>編集ユーザー</th>
                </tr>
                
                <c:forEach items="${productList}" var="productList" >
                <tr><td><a href="#">編集</a></td><td><a href="#">削除</a></td>
                <td><c:out value="${productList.id}" /></td>
                <td id="product-name"><c:out value="${productList.productName}" /></td>
                <td><a href="<c:out value="${productList.productUrl}" />">LINK</a></td>
                <td><c:out value="${productList.registDate}" /></td>
                <td><c:out value="${productList.registBy}" /></td>
                <td><c:out value="${productList.updateDate}" /></td>
                <td><c:out value="${productList.updateBy}" /></td>
                </tr>
                </c:forEach>
                
                
            </table>
            <p><a href="#">戻る</a></p>
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