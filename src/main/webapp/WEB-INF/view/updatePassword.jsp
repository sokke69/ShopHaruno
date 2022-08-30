<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>パスワード編集</title>

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
						<th colspan=2 class="subject">パスワード編集</th>
					</tr>
					<tr>
						<td colspan=2><hr></td>
					</tr>
					<tr>
						<th><c:if test="${ not empty oldLoginPassSuccess}">
								<i class="fa-solid fa-circle-minus warning"></i>
							</c:if> <c:if test="${ not empty oldLoginPassError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> 旧パスワード</th>
					</tr>
					<tr>
						<td><c:if test="${ not empty oldLoginPassSuccess}">
								<div class="alert alert-warning" id="alert">
									<c:out value="※ ${oldLoginPassSuccess}" />
								</div>
							</c:if> <c:if test="${ not empty oldLoginPassError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${oldLoginPassError}" />
								</div>
							</c:if> <input type="text" name="request-old-login-pass"
							id="add-user-form"></td>
					</tr>
					<tr>
						<th><c:if test="${ not empty newLoginPassSameSuccess}">
								<i class="fa-solid fa-circle-minus warning"></i>
							</c:if> <c:if test="${ not empty newLoginPassError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> <c:if test="${ not empty newLoginPassSameError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> 新パスワード
					</tr>
					<tr>
						<td><c:if test="${ not empty newLoginPassSameSuccess}">
								<div class="alert alert-warning" id="alert">
									<c:out value="※ ${newLoginPassSameSuccess}" />
								</div>
							</c:if> <c:if test="${ not empty newLoginPassSameError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${newLoginPassSameError}" />
								</div>
							</c:if> <c:if test="${ not empty newLoginPassError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${newLoginPassError}" />
								</div>
							</c:if> <input type="text" name="request-new-login-pass"
							id="add-user-form">
							<div class="attention">※ ログインパスワードは6字以上20字以内で入力してください。</div>
							<div class="attention">※ 使用できる文字は半角英数字のみです。</div></td>
					</tr>
					<tr>
						<th><c:if test="${ not empty newLoginPassSameSuccess}">
										<i class="fa-solid fa-circle-minus warning"></i>
									</c:if> <c:if test="${ not empty newLoginPassError}">
										<i class="fa-solid fa-circle-exclamation error"></i>
									</c:if> <c:if test="${ not empty newLoginPassSameError}">
										<i class="fa-solid fa-circle-exclamation error"></i>
									</c:if> 新パスワード(確認)</th>
					</tr>
					<tr>
						<td><c:if test="${ not empty newLoginPassSameSuccess}">
										<div class="alert alert-warning" id="alert">
											<c:out value="※ ${newLoginPassSameSuccess}" />
										</div>
									</c:if> <c:if test="${ not empty newLoginPassSameError}">
										<div class="alert alert-danger" id="alert">
											<c:out value="※ ${newLoginPassSameError}" />
										</div>
									</c:if> <c:if test="${ not empty newLoginPassCheckError}">
										<div class="alert alert-danger" id="alert">
											<c:out value="※ ${newLoginPassCheckError}" />
										</div>
									</c:if> <input type="text" name="request-new-login-pass-check"
									id="add-user-form"></td>
					</tr>

					<tr>
						<td><div class="submit">
								<input type="submit" value="決定" class="btn btn-secondary">
							</div></td>
					</tr>
					<tr>
						<td><hr></td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<td class="bottom-link"><a href="updateMyData">戻る</a></td>
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
<%-- ここまで --%>



<footer>
	<c:import url="parts/footer.jsp" />
</footer>


</body>

</html>