<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品リスト</title>

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
<link rel="stylesheet" href="./css/list.css">
<link rel="stylesheet" href="./css/hf_style.css">
<link rel="stylesheet" href="./css/pagenation.css">

<script src="https://kit.fontawesome.com/ec1be9ca10.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/bootstrap.bundle.min.js"></script>

</head>

<%-- ナビ・ロゴ ここから --%>
<c:import url="parts/header_setting.jsp" />
<c:import url="parts/logo_setting.jsp" />
<%-- ここまで --%>

<%-- デザイン切り替えボタン ここから --%>
<table class="link-design">
	<tr>
		<td><a href="listProductViewOnly">デザイン版へ切り替える</a></td>
	</tr>
</table>
<br>
<br>
<%-- デザイン切り替えボタン ここまで --%>

<%-- カテゴリ一覧 ここから --%>
<table class="basic">
	<tr>
		<td class="basic-top"></td>
	</tr>
	<tr>
		<td class="basic-middle">
			<%-- テーブル中身 ここから --%>

			<table class="category">
				<tr>
					<th>- ソート : カテゴリ -</th>
				</tr>
				<tr>
					<td>
						<div class="container">
							<div>
								<a href="index">すべて</a>
							</div>
							<c:forEach items="${aCategoryList}" var="aCategoryList"
								varStatus="vs">
								<div class="category-a">
									<a href="listProductSimple?Category=${aCategoryList.id}"><c:out
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

<%-- テーブルサンプル ここから --%>

<table class="basic">
	<tr>
		<td class="basic-top"></td>
	</tr>
	<tr>
		<td class="basic-middle">
			<%-- テーブル中身 ここから --%>

			<table class="table-list">
				<tr>
					<th class="subject">商品リスト</th>
				</tr>
				<tr>
					<td><hr></td>
				</tr>
				<tr>
					<td class="table-inside"><div class="pagenation-block"><c:forEach items="${productList}"
							var="productList" varStatus="vs">
							<dl><dd><table class="table table-borderless">

								<tr>
									<th class="product-name-simple"><c:out
											value="${productList.id}" />.<c:out
											value="${productList.productName}" /></th>
								</tr>
								<tr>
									<td class="product-ted-simple">
										<div>
											<i class="fa-solid fa-calendar-days calender-icon"></i>
											<fmt:formatDate value="${productList.registDate}"
												pattern=" y年MM月dd日 HH時mm分" />
											<c:out value="by ${productList.registBy}" />
										</div>
										<div>
											<i class="fa-solid fa-arrows-rotate"></i>
											<c:if test="${not empty productList.updateDate}">
												<fmt:formatDate value="${productList.updateDate}"
													pattern=" y年MM月dd日 HH時mm分" />
											</c:if>
											<c:if test="${empty productList.updateDate}">
												<span> ----年--月--日 --時--分</span>
											</c:if>
											<c:if test="${not empty productList.updateBy}">
												<c:out value="by ${productList.updateBy}" />
											</c:if>
											<c:if test="${empty productList.updateBy}">
														by ---
													</c:if>
										</div>
									</td>
									
								</tr>

							</table></dd></dl>
						</c:forEach></div></td>
				</tr>
				<tr>
					<td><hr></td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td class="bottom-link"><a href="listDb">戻る</a></td>

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

<br>
<br>
<%-- ここまで --%>

<%-- ページネーション ここから --%>
<script src="./js/paginathing.min.js"></script>
<div class="page-nation">
	<script>
		$(function() {
			$('.pagenation-block').paginathing({//親要素のclassを記述
				perPage : 5,//1ページあたりの表示件数
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

<footer>
	<c:import url="parts/footer.jsp" />
</footer>


</body>

</html>