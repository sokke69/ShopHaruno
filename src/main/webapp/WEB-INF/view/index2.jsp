<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css">
    <link rel="stylesheet" href="./css/index2.css">
    <link rel="stylesheet" href="./css/hf_style.css">
    
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<%-- ホームページロゴ ここから --%>
<div class="logo_bg">
    <table id="logo">
        <tr>
            <th id="title">*ショップ<span id="spring">ハル</span>ノ*</th>
        </tr>
    </table>
</div>

<br> <br>
<%-- ホームページロゴ ここまで --%>

<%-- カテゴリ一覧 ここから --%>
<table class="table-category">
<tr><th>- カテゴリ一覧 -</th></tr>
<tr>
<td>
<c:forEach items="${aCategoryList}" var="aCategoryList" varStatus="vs">
<a href="index?Category=${aCategoryList.id}"><c:out value="${aCategoryList.aCategoryName}" /></a> 
</c:forEach>
</td>
</tr></table>

<br><br>
<%-- カテゴリ一覧 ここまで --%>


<%-- 商品1つのテーブル(サンプル) ここから --%>

<table class="product">
    <tr class="product-name-height">
        <td class="js-textTrim">
            <p>消せないサンプルです。文字数オーバー時は省略をし三点リーダー追加チェックに自動的に変更されるため長文をいれています。実際の商品名もamazonからもってくるためコピー＆ペーストをした場合はかなりの長さになると思われるためこの機能を実装しています。
            </p>
        </td>
    </tr>
    <tr class=img-view>
        <td>
            <div class="single">
                <div><img src="./imgs/sample1main.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub01.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub02.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub03.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub04.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub05.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub06.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub07.jpg" alt="" class="imgs"></div>
                <div><img src="./imgs/sample1sub08.jpg" alt="" class="imgs"></div>
            </div>
        </td>
    </tr>
    <tr class="product-bottom">
        <td>
        <table>
        <tr></tr>
        <tr><td><p><a href="">販売ページへ行く</a></p></td></tr>
        <tr><td><i class="fa-brands fa-gratipay"></i><i class="fa-brands fa-gratipay"></i>2022/09/01</td></tr>
        </table>
        </td>
    </tr>
</table>

<br> <br>

<%-- 商品1つのテーブル(サンプル) ここまで --%>


<%-- 商品1つのテーブル(DBからデータ取得) ここから --%>
<c:forEach items="${productList}" var="productList" varStatus="vs">

<table class="product">
    <tr class="product-name-height">
        <td class="js-textTrim">
            <p><c:out value="${productList.productName}" /></p> 
        </td>
    </tr>
    <tr class=img-view>
        <td>
            <div class="single">
                <div><img src="${productList.imgMain}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub01}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub02}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub03}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub04}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub05}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub06}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub07}" alt="" class="imgs"></div>
                <div><img src="${productList.imgSub08}" alt="" class="imgs"></div>
            </div>
        </td>
    </tr>
    <tr class="product-bottom">
        <td>
        <table>
        <tr></tr>
        <tr><td><p><a href="">販売ページへ行く</a></p></td></tr>
        <tr><td><i class="fa-brands fa-gratipay"></i><i class="fa-brands fa-gratipay"></i><fmt:formatDate value="${productList.registDate}" pattern="y/MM/dd" /></td></tr>
        </table>
        </td>
    </tr>
</table>

<br> <br>

</c:forEach>
<%-- 商品1つのテーブル(DBからデータ取得) ここまで --%>

<footer>
     <c:import url="parts/footer.jsp" />
</footer>

<script src="./js/slick.min.js"></script>
<script>
$(document).ready(function(){
	  $('.single').slick({
		    autoplay:true,
		    autoplaySpeed:4000,
		    dots: true, //ドットのナビゲーションを表示
		    prevArrow: '<button class="slide-arrow prev-arrow"></button>',
		    nextArrow: '<button class="slide-arrow next-arrow"></button>'
		  });
		});
</script>

</body>

</html>