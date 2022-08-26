<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>お問い合わせ</title>

<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap"
	rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css">
<link rel="stylesheet" href="./css/default.css">
<link rel="stylesheet" href="./css/setting.css">
<link rel="stylesheet" href="./css/hf_style.css">


<script src="https://kit.fontawesome.com/ec1be9ca10.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./js/bootstrap.bundle.min.js"></script>

</head>

<c:import url="parts/header_shop.jsp" />

<%-- ホームページロゴ ここから --%>
<div class="logo_bg">
	<table id="logo">
		<tr>
			<th id="title">*ショップ<span id="spring">ハル</span>ノ*
			</th>
		</tr>
	</table>
</div>

<br>
<br>
<%-- ホームページロゴ ここまで --%>

<%-- 問い合わせテーブル ここから --%>
<form action="" method="post">
	<table class="table-category-e">
		<tr>
			<th>- お問い合わせ -</th>
		</tr>
		<tr>
			<td>
				<div>
					<table class="table-enquiry">
						<tr>
							<th><c:if test="${ not empty nameSuccess}">
									<i class="fa-solid fa-circle-check success"></i>
								</c:if> <c:if test="${ not empty nameError}">
									<i class="fa-solid fa-circle-exclamation error"></i>
								</c:if> お名前(会社名)*</th>
						</tr>
						<tr>
							<td><c:if test="${ not empty nameError}">
									<div class="alert alert-danger" id="alert">
										<c:out value="※ ${nameError}" />
									</div>
								</c:if> <input type="text" value="<c:out value="${requestName}" />"
								name="request-name" id="add-user-form"></td>
						</tr>
						<tr>
							<th>
							<c:if test="${ not empty emailAddressSuccess}">
                            		<i class="fa-solid fa-circle-check success"></i>
                            </c:if>
                            <c:if test="${ not empty emailAddressError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             メールアドレス*
							<th>
						</tr>
						<tr>
							<td>
							<c:if test="${ not empty emailAddressError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${emailAddressError}" />
                            	</div>
                            </c:if>
							<input type="text"
								value="<c:out value="${requestEmailAddress}" />"
								name="request-email" id="add-user-form"></td>
						</tr>
						<tr>
							<th>
							<c:if test="${ not empty textSuccess}">
                            		<i class="fa-solid fa-circle-check success"></i>
                            </c:if>
                            <c:if test="${ not empty textError}">
                            		<i class="fa-solid fa-circle-exclamation error"></i>
                            </c:if>
                             お問い合わせ内容*</th>
						</tr>
						<tr>
							<td>
							<c:if test="${ not empty textError}">
                            	<div class="alert alert-danger" id="alert">
                            		<c:out value="※ ${textError}" />
                            	</div>
                            </c:if>
							<textarea name="request-text" cols="" rows="5"><c:out
										value="${requestText}" /></textarea>
								<div class="attention">「*」は必須項目です。</div></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<th><div class="input-wrap">
					<input type="submit">
				</div></th>
		</tr>
	</table>
</form>



<br>
<br>
<%-- カテゴリ一覧 ここまで --%>


<footer>
	<c:import url="parts/footer.jsp" />
</footer>




</body>

</html>