<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ショップ ハルノ</title>
    
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css">
    <link rel="stylesheet" href="./css/shop.css">
    <link rel="stylesheet" href="./css/hf_style.css">
    
    
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./js/bootstrap.bundle.min.js"></script>
    
    <!-- ソート 未実装  -->
    <!-- <script>
    		$(".sort-new a").click(function(){
    			let path = $(location).attr('pathname');
    			let search = $(location).attr('search');
    			console.log(path);
    			console.log(search);
        		(this).attr("href",path+search+"?sort=new")
        	});
        	$(".sort-old a").click(function(){
        		let path = $(location).attr('pathname');
        		let search = $(location).attr('search');
        		console.log(path);
    			console.log(search);
        		(this).attr("href",path+search+"?sort=old")
        	});
    </script> -->

</head>

<c:import url="parts/header_shop.jsp" />

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
<tr><td>
<div class="container">
	<div><a href="index">すべて</a></div>
	<c:forEach items="${aCategoryList}" var="aCategoryList" varStatus="vs">
		<div><a href="index?Category=${aCategoryList.id}"><c:out value="${aCategoryList.aCategoryName}" /></a></div>
	</c:forEach>
	<!-- ソート未実装 -->
	<!-- <div class="sort">
	<hr class="hr-category">
		<div>登録日 :</div><div><a href="" id="sort-new">新しい順</a></div><div><a href="" id="sort-old">古い順</a></div>
	</div> -->
</div>
</td></tr></table>

<br><br>
<%-- カテゴリ一覧 ここまで --%>


<%-- 商品1つのテーブル(DBからデータ取得) ここから --%>
<div class="pagenation_block">

<c:forEach items="${productList}" var="productList" varStatus="vs">

<dl>
<dd>
<table class="product">
    <tr class="product-name-height">
        <th class="js-textTrim">
            <p><c:out value="${productList.productName}" /></p> 
        </th>
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
        <td id="bottom">
        <table>
        <tr></tr>
        <tr id="visit"><td width="420px" colspan="2"><p><a href="${productList.productUrl}">販売ページへ行く</a></p></td></tr>
        <tr>
        <td><%-- <i class="fa-brands fa-gratipay like-off"></i><i class="fa-brands fa-gratipay like-on"></i> --%></td>
        <td id="clock"><i class="fa-solid fa-calendar-days"></i> <fmt:formatDate value="${productList.registDate}" pattern="y年MM月dd日" /></td>
        </tr>
        </table>
        </td>
    </tr>
</table>
<br> <br>
</dd>
</dl>

</c:forEach>



</div>
<%-- 商品1つのテーブル(DBからデータ取得) ここまで --%>

<%-- ページネーション ここから --%>
<script src="./js/paginathing.min.js"></script>
<div class="page-nation">
<script>
$(function() {
	  $('.pagenation_block').paginathing({//親要素のclassを記述
	   perPage: 3,//1ページあたりの表示件数
	   prevText:'<i class="fas fa-angle-left"></i>',//1つ前のページへ移動するボタンのテキスト
	   nextText:'<i class="fas fa-angle-right"></i>',//1つ次のページへ移動するボタンのテキスト
	   activeClass: 'navi-active',//現在のページ番号に任意のclassを付与できます
	   firstText: '<i class="fas fa-angle-double-left"></i>', // "最初ページ"に移動するボタンのテキスト
	   lastText: '<i class="fas fa-angle-double-right"></i>', // "最後のページ"に移動するボタンのテキスト
	  })
	});
</script>
</div>
<%-- ページネーション ここまで --%>

<footer>
     <c:import url="parts/footer.jsp" />
</footer>


<%-- slick ここから --%>
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
<%-- slick ここまで --%>

</body>

</html>