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
<c:import url="parts/header.jsp" />


<div class="container" id="body">
    <div class="row">
        <div class="col"></div>
        <div class="col-10">
            <table><tr><td><div class="display-6">商品一覧</div></td></tr></table>
            <a href="listProduct">全カテゴリ</a><c:forEach items="${aCategoryList}" var="aCategoryList" varStatus="vs">
                <a href="listProductByAId?aId=${aCategoryList.id}"><c:out value="${aCategoryList.id}.${aCategoryList.aCategoryName}" /></a>
                </c:forEach>
            <table id="list-table" class="table table-hover">
                <tr>
                <th id="id">ID</th>
                <th id="product-name">商品名</th>
                <th id="product-url">商品URL</th>
                <th id="product-category">カテゴリ</th>
                <th>登録日</th>
                <th>登録ユーザー</th>
                <th>編集日</th>
                <th>編集ユーザー</th>
                </tr>
                
                <c:forEach items="${productList}" var="productList" >
                <tr>
                <td><c:out value="${productList.id}" /></td>
                <td id="product-name"><c:out value="${productList.productName}" /></td>
                <td><a href="<c:out value="${productList.productUrl}"/>" target="_blank">LINK</a></td>
                <td><c:out value="${productList.categoryAStr}" /></td>
                <td><fmt:formatDate value="${productList.registDate}" pattern="y年MM月dd日 HH:mm:ss" /></td>
                <td><c:out value="${productList.registBy}" /></td>
                <td><fmt:formatDate value="${productList.updateDate}" pattern="y年MM月dd日 HH:mm:ss" /></td>
                <td><c:out value="${productList.updateBy}" /></td>
                </tr>
                </c:forEach>
                
                
            </table>
            <p><a href="listDb">戻る</a></p>
        </div>
        <div class="col"></div>
    </div><!--/.row-->
</div><!--/.container-->





    <div>
        <footer>
            <c:import url="parts/footer.jsp" />
        </footer>
    </div>
    
</body>
</html>