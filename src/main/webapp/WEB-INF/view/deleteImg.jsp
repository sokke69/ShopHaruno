<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品画像削除</title>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="./css/default.css">
<link rel="stylesheet" href="./css/list.css">
<link rel="stylesheet" href="./css/hf_style.css">

<script src="./js/bootstrap.bundle.min.js"></script>
<script src="./js/jquery-3.6.0.min.js"></script>

</head>

<%-- ナビ・ロゴ ここから --%>
<c:import url="parts/header_setting.jsp" />
<c:import url="parts/logo_setting.jsp" />
<%-- ここまで --%>

<%-- テーブルサンプル ここから --%>

<table class="basic">
	<tr>
		<td class="basic-top"></td>
	</tr>
	<tr>
		<td class="basic-middle">
			<form action="" method="post">
				<%-- テーブル中身 ここから --%>
				<table class="table-list">
					<tr>
						<th colspan=2 class="subject">商品画像削除</th>
					</tr>
					<tr>
						<td colspan=2><hr></td>
					</tr>
					<%-- 商品ID --%>
					<tr><th class="img-id">商品ID</th><td><c:out value="${product.id}" /></td></tr>
					<%-- 商品名 --%>
					<tr>
						<th>商品名</th><td><c:out value="${product.productName}" /></td>
					</tr>
					<%-- 商品URL --%>
					<tr>
						<th>商品URL*</th><td><c:out value="${product.productUrl}" /></td>
					</tr>
					<%-- カテゴリA --%>
					<tr>
						<th>カテゴリA*</th><td><c:out value="${product.categoryAStr}" /></td>
					</tr>
					<%-- 画像 --%>
					<c:forEach var="i" begin="1" end="${product.img}" varStatus="vs">
						<tr>
							<th colspan=2>画像0<c:out value="${i}" /></th>
						</tr>
						<tr>
							<td colspan=2><img src="./imgs/${product.id }_0${i}.jpg" alt=""></td>	
						</tr>
						<tr><td colspan=2>
								<div class="form-check form-check-inline delete-radio">
									<input class="form-check-input" type="radio" value="no" id="0${i}choiceA" name="check0${i}" checked>
									<label class="form-check-label" for="0${i}choiceA">削除しない</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" value="exe" id="0${i}choiceB" name="check0${i}">
									<label class="form-check-label" for="0${i}choiceB">削除する</label>
								</div>
							</td></tr>
					</c:forEach>
					<%-- 画像hidden --%>
					<c:forEach var="j" begin="${countImgPlus}" end="9" varStatus="vs">
						<tr><td><input type="hidden" name="check0${j}" value="no"></td></tr>
					</c:forEach>
					<tr>
						<td colspan=2><div class="submit">
								<input type="submit" value="決定" class="btn btn-secondary">
							</div></td>
					</tr>
					<tr>
						<td colspan=2><hr></td>
					</tr>
					<tr>
						<td colspan=2>
							<table>
								<tr>
									<td class="bottom-link">
											<a href="updateProduct?id=${product.id}">戻る</a>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<%-- ここまで --%>
			</form>

		</td>
	</tr>
	<tr>
		<td class="basic-bottom"></td>
	</tr>
</table>

<br>
<br>
<%-- ここまで --%>

<footer>
	<c:import url="parts/footer.jsp" />
</footer>

</body>

</html>