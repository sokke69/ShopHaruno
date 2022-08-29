<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カテゴリリスト</title>
    
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css">
    <link rel="stylesheet" href="./css/default.css">
    <link rel="stylesheet" href="./css/list.css">
    <link rel="stylesheet" href="./css/hf_style.css">
    <link rel="stylesheet" href="./css/pagenation.css">
    
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./js/bootstrap.bundle.min.js"></script>

</head>

<%-- ナビ・ロゴ ここから --%>
<c:import url="parts/header_setting.jsp" />
<c:import url="parts/logo_setting.jsp" />
<%-- ここまで --%>

<%-- テーブルサンプル ここから --%>

<table class="basic">
<tr><td class="basic-top"></td></tr>
<tr><td class="basic-middle">

	<%-- テーブル中身 ここから --%>
	
		<table class="table-list">
			<tr><th class="subject">商品削除</th></tr>
			<tr><td><hr></td></tr>
			<tr>
				<td class="table-inside">
					<form action="" method="post">
					<table id="list-table" class="table table-hover">
						<tr>
							<th id="head">ID</th>
							<td><c:out value="${product.id}" /></td>
						</tr>
						<tr>
							<th>商品名</th>
							<td><c:out value="${product.productName}" /></td>
						</tr>
						<tr>
							<th>商品URL</th>
							<td><a href="${product.productUrl}"><c:out value="${product.productUrl}" /></a></td>
						</tr>
						<tr>
							<th>カテゴリA</th>
							<td><c:out value="${product.categoryAStr}" /></td>
						</tr>
						<tr >
							<th colspan="2">メイン画像<img src="${product.imgMain}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像01<img src="${product.imgSub01}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像02<img src="${product.imgSub02}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像03<img src="${product.imgSub03}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像04<img src="${product.imgSub04}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像05<img src="${product.imgSub05}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像06<img src="${product.imgSub06}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像07<img src="${product.imgSub07}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th colspan="2">サブ画像08<img src="${product.imgSub08}" alt="" id="sumb"></th>
						</tr>
						<tr>
							<th>登録日</th>
							<td><c:out value="${product.registDate}" /></td>
						</tr>
						<tr>
							<th>登録ユーザー</th>
							<td><c:out value="${product.registBy}" /></td>
						</tr>
						<tr>
							<th>編集日</th>
							<td><c:out value="${product.updateDate}" /></td>
						</tr>
						<tr>
							<th>編集ユーザー</th>
							<td><c:out value="${product.updateBy}" /></td>
						</tr>
					</table>
					<input type="submit" value="削除" class="btn btn-secondary">
				</form>
				</td>
			</tr>
			<tr><td><hr></td></tr>
			<tr>
				<td>
					<table>
						<tr>
							<td class="bottom-link"><a href="listDb">戻る</a></td>
							
						</tr>
					</table>
				</td>
			</tr>
		</table>
	
	<%-- ここまで --%>

</td></tr>
<tr><td class="basic-bottom"></td></tr>
</table>

<br><br>
<%-- ここまで --%>

<footer>
     <c:import url="parts/footer.jsp" />
</footer>


</body>

</html>
