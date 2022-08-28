<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ユーザー追加</title>

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
<script>
    $(function(){
    	
    	for(let i = 1; i <= ${countTypeId}; i++){
    		if( ${inputedTypeId} == i ){
    			$(".select-type").val(i);
    		}
    	}
    });
    </script>

</head>

<%-- ナビ・ロゴ ここから --%>
<c:import url="parts/header_shop.jsp" />
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
						<th class="subject">ユーザー追加</th>
					</tr>
					<tr>
						<td><hr></td>
					</tr>
					<%-- ユーザー名 --%>
					<tr>
						<th><c:if test="${ not empty nameSuccess}">
								<i class="fa-solid fa-circle-check success"></i>
							</c:if> <c:if test="${ not empty nameError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> ユーザー名
						</th></tr>
					<tr><td>
					<c:if test="${ not empty nameError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${nameError}" />
                            	</div>
                            </c:if>
						<input type="text" name="request-user-name" value="${inputedUserName}" id="add-user-form">
							<div class="attention">※ ユーザー名は12文字以内で入力してください。</div></td>
					</tr>

					<%-- ログインID --%>
					<tr>
						<th><c:if test="${ not empty loginIdSuccess}">
								<i class="fa-solid fa-circle-check success"></i>
							</c:if> <c:if test="${ not empty loginIdError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> ログインID</th>
					</tr>
					<tr>
						<td><c:if test="${ not empty loginIdError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${loginIdError}" />
								</div>
							</c:if><input type="text" name="request-login-id"
							value="${inputedLoginId}" id="add-user-form">
							<div class="attention">※ ログインIDは4文字以上12文字以内で入力してください。</div>
							<div class="attention">※ 使用できる文字は半角英数字と「-」「_」のみです。</div></td>
					</tr>
					<%-- ログインパスワード --%>
					<tr>
						<th><c:if test="${ not empty loginPassSameSuccess}">
								<i class="fa-solid fa-circle-minus warning"></i>
							</c:if> <c:if test="${ not empty loginPassError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> <c:if test="${ not empty loginPassSameError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> ログインパスワード</th>
					</tr>
					<tr>
						<td> <c:if test="${ not empty loginPassSameSuccess}">
								<div class="alert alert-warning" id="alert">
									<c:out value="※ ${loginPassSameSuccess}" />
								</div>
							</c:if> <c:if test="${ not empty loginPassSameError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${loginPassSameError}" />
								</div>
							</c:if> <c:if test="${ not empty loginPassError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${loginPassError}" />
								</div>
							</c:if><input type="text" name="request-login-pass"
							id="add-user-form">
							<div class="attention">※ ログインパスワードは6字以上20字以内で入力してください。</div>
							<div class="attention">※ 使用できる文字は半角英数字のみです。</div></td>
					</tr>
					<%-- ログインパスワード(確認) --%>
					<tr>
						<th><c:if test="${ not empty loginPassSameSuccess}">
								<i class="fa-solid fa-circle-minus warning"></i>
							</c:if> <c:if test="${ not empty loginPassError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> <c:if test="${ not empty loginPassSameError}">
								<i class="fa-solid fa-circle-exclamation error"></i>
							</c:if> ログインパスワード(確認) </th>
					</tr>
					<tr>
						<td><c:if test="${ not empty loginPassSameSuccess}">
								<div class="alert alert-warning" id="alert">
									<c:out value="※ ${loginPassSameSuccess}" />
								</div>
							</c:if> <c:if test="${ not empty loginPassSameError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${loginPassSameError}" />
								</div>
							</c:if> <c:if test="${ not empty loginPassCheckError}">
								<div class="alert alert-danger" id="alert">
									<c:out value="※ ${loginPassCheckError}" />
								</div>
							</c:if><input type="text" name="request-login-pass-check"
							id="add-user-form"></td>
					</tr>
					<tr>
					<td><div class="submit"><input type="submit" value="追加" class="btn btn-secondary"></div>
					</td>
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