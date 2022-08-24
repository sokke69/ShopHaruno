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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<div class="logo_bg">
    <table id="logo">
        <tr>
            <th id="title">*ショップ<span id="spring">ハル</span>ノ*</th>
        </tr>
    </table>
</div>

<br> <br>

<table class="product">
    <tr class="product-name-height">
        <td class="js-textTrim">
            <p>消せないサンプルです。文字数オーバー時の省略、三点リーダー追加チェックのため長文をいれています。実際の商品名もamazonからもってくるためコピー＆ペーストをした場合はかなりの長さになると思われるためこの機能を実装しています。
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
            <p><a href="">販売ページへ行く</a></p>
        </td>
    </tr>
</table>

<br> <br>

<table class="product">
    <tr>
        <td><img src="./imgs/2_main.jpg" alt="" data-adaptive-background></td>
    </tr>
</table>


<script src="./js/slick.min.js"></script>
 <script>
$(document).ready(function(){
	  $('.single').slick({
		    dots: true, //ドットのナビゲーションを表示
		    prevArrow: '<button class="slide-arrow prev-arrow"></button>',
		    nextArrow: '<button class="slide-arrow next-arrow"></button>'
		  });
		});
</script>

</body>

</html>