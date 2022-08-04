<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品削除</title>
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
			<div class="col-9">
				<div class="display-6">商品削除</div>
				<form action="" method="post">
					<table border="1" id="list-table">
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
							<td><c:out value="${product.productUrl}" /></td>
						</tr>
						<tr>
							<th>カテゴリA</th>
							<td><c:out value="${product.categoryA}" /></td>
						</tr>
						<tr>
							<th>カテゴリB</th>
							<td><c:out value="${product.categoryB01}" /></td>
						</tr>
						<tr>
							<th>カテゴリB</th>
							<td><c:out value="${product.categoryB02}" /></td>
						</tr>
						<tr>
							<th>カテゴリB</th>
							<td><c:out value="${product.categoryB03}" /></td>
						</tr>
						<tr>
							<th>メイン画像</th>
							<td><img src="${product.imgMain}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像01</th>
							<td><img src="${product.imgSub01}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像02</th>
							<td><img src="${product.imgSub02}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像03</th>
							<td><img src="${product.imgSub03}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像04</th>
							<td><img src="${product.imgSub04}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像05</th>
							<td><img src="${product.imgSub05}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像06</th>
							<td><img src="${product.imgSub06}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像07</th>
							<td><img src="${product.imgSub07}" alt="" id="sumb"></td>
						</tr>
						<tr>
							<th>サブ画像08</th>
							<td><img src="${product.imgSub08}" alt="" id="sumb"></td>
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
					<input type="submit" value="削除" class="submit">

					<p>
						<a href="listProduct">戻る</a>
					</p>
				</form>
			</div>
			<div class="col"></div>
		</div>
		<!--/.row-->
	</div>
	<!--/.container-->

	<div>
		<footer>
			<p class="copyright">Copyright &copy 2022 SHOP HARUNO All Rights
				Reserved.</p>
		</footer>
	</div>

</body>
</html>