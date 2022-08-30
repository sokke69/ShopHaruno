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
<link
	href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css">
<link rel="stylesheet" href="./css/default.css">
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet" href="./css/hf_style.css">
<link rel="stylesheet" href="./css/pagenation.css">

<script src="https://kit.fontawesome.com/ec1be9ca10.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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

<c:import url="parts/header_setting.jsp" />

<%-- ホームページロゴ ここから --%>
<c:import url="parts/logo_setting.jsp" />
<%-- ホームページロゴ ここまで --%>

<%-- デザイン切り替えボタン ここから --%>
<table class="link-design">
	<tr>
		<td><a href="listProductSimple">シンプル版へ切り替える</a></td>
	</tr>
</table>
<br>
<%-- デザイン切り替えボタン ここまで --%>

<%-- 追加ボタン ここから --%>
<table class="table-add">
	<tr>
		<td class="button"><a href="addProduct"><span class="icon"><i
					class="fa-solid fa-file-circle-plus"></i></span> 追加 </a></td>
	</tr>
</table>
<%-- 追加ボタン ここまで --%>

<br>
<br>
<%-- カテゴリ一覧 ここから --%>
<table class="basic">
	<tr>
		<td class="basic-top"></td>
	</tr>
	<tr>
		<td class="basic-middle">
			<%-- テーブル中身 ここから --%>

			<table class="category-d">
				<tr>
					<th>- ソート : カテゴリ -</th>
				</tr>
				<tr>
					<td>
						<div class="container">
							<div>
								<a href="listProduct">すべて</a>
							</div>
							<c:forEach items="${aCategoryList}" var="aCategoryList"
								varStatus="vs">
								<div class="category-a">
									<a href="listProduct?Category=${aCategoryList.id}"><c:out
											value="${aCategoryList.aCategoryName}" /></a><span> </span>
								</div>
							</c:forEach>
						</div>
					</td>
				</tr>
			</table> <%-- テーブル中身 ここまで --%>

		</td>
	</tr>
	<tr>
		<td class="basic-bottom"></td>
	</tr>
</table>

<br>
<br>
<%-- カテゴリ一覧 ここまで --%>


<%-- 商品1つのテーブル(DBからデータ取得) ここから --%>
<div class="pagenation-block">
	<c:forEach items="${productList}" var="productList" varStatus="vs">
		<dl>
			<dd>
				<table class="basic">
					<tr>
						<td class="basic-top"></td>
					</tr>
					<tr>
						<td class="basic-middle">
							<%-- テーブル中身 ここから --%>
							<table class="table-product">
								<tr class="product-top">
									<th><c:out value="${productList.id}" />.<c:out
											value="${productList.productName}" /></th>
								</tr>
								<tr class="product-middle">
									<td>
											<div class="single">
												<c:forEach var="i" begin="1" end="${productList.img}"
													varStatus="vs">
													<div>
														<img src="./imgs/${productList.id}_0${i}.jpg?${today}"
															alt="" class="imgs" />
													</div>
												</c:forEach>
											</div>

									</td>
								</tr>
								<tr>
									<td class="product-bottom">
										<table class="table-bottom">
											<tr>
												<td class="product-link">
													<p>
														<a href="${productList.productUrl}"><i
															class="fa-brands fa-amazon amazon"></i> 販売ページへ</a>
													</p>
												</td>
											</tr>
											<tr>
												<td class="product-ted"><i
													class="fa-solid fa-calendar-days calender-icon"></i> <fmt:formatDate
														value="${productList.registDate}"
														pattern=" y年MM月dd日 HH時mm分" /> <c:out
														value="by ${productList.registBy}" /></td>
											</tr>
											<tr>
												<td class="product-ted"><i
													class="fa-solid fa-arrows-rotate"></i> <c:if
														test="${not empty productList.updateDate}">
														<fmt:formatDate value="${productList.updateDate}"
															pattern=" y年MM月dd日 HH時mm分" />
													</c:if> <c:if test="${empty productList.updateDate}">
														<span> ----年--月--日 --時--分</span>
													</c:if> <c:if test="${not empty productList.updateBy}">
														<c:out value="by ${productList.updateBy}" />
													</c:if> <c:if test="${empty productList.updateBy}">
														by ---
													</c:if></td>
											</tr>
										</table>
									</td>
								</tr>
							</table> <%-- ここまで --%>
						</td>
					</tr>
					<tr>
						<td class="basic-bottom"></td>
					</tr>
				</table>
				<%-- 編集・削除ボタン ここから --%>
				<table>
					<tr>
						<td>
							<table class="table-up">
								<tr>
									<td class="button"><a
										href="updateProduct?id=${productList.id}"> <span
											class="icon"><i class="fa-solid fa-wrench"></i></span> 編集
									</a></td>
								</tr>
							</table>
						</td>
						<td>
							<table class="table-del">
								<tr>
									<td class="button"><a
										href="deleteProduct?id=${productList.id}"> <span
											class="icon"><i class="fa-solid fa-trash-can"></i></span> 削除
									</a></td>
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
			$('.pagenation-block').paginathing({//親要素のclassを記述
				perPage : 3,//1ページあたりの表示件数
				prevText : '<i class="fas fa-angle-left"></i>',//1つ前のページへ移動するボタンのテキスト
				nextText : '<i class="fas fa-angle-right"></i>',//1つ次のページへ移動するボタンのテキスト
				activeClass : 'navi-active',//現在のページ番号に任意のclassを付与できます
				firstText : '<i class="fas fa-angle-double-left"></i>', // "最初ページ"に移動するボタンのテキスト
				lastText : '<i class="fas fa-angle-double-right"></i>', // "最後のページ"に移動するボタンのテキスト
			})
		});
	</script>
</div>
<%-- ページネーション ここまで --%>

<%-- フッター ここから --%>
<footer>
	<c:import url="parts/footer.jsp" />
</footer>
<%-- フッター ここまで --%>

<%-- slick ここから --%>
<script src="./js/slick.min.js"></script>
<script>
	$(document).ready(function(){
		$('.single').slick({
			autoplay : true,
			autoplaySpeed : 4000,
			dots : true, //ドットのナビゲーションを表示
			prevArrow : '<button class="slide-arrow prev-arrow"></button>',
			nextArrow : '<button class="slide-arrow next-arrow"></button>'
		});
	});
</script>
<%-- slick ここまで --%>

</body>

</html>