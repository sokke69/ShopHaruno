<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>データベース一覧</title>
    
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
			<tr><th class="subject">データベース一覧</th></tr>
			<tr><td><hr></td></tr>
			<tr>
				<td>
					<table class="table-table">
						<tr><td class="alink"><a href="listProduct">商品 <span class="sub-title">-Pproduct-</span></a></td></tr>
						<tr><td class="alink"><a href="listACategory">商品カテゴリ <span class="sub-title">-Category-</span></a></td></tr>
						<tr><td class="alink"><a href="listUser">ユーザー <span class="sub-title">-User-</span></a></td></tr>
					</table>
				</td>
			</tr>
			<tr><td><hr></td></tr>
			<tr>
				<td>
					<table>
						<tr>
							<td class="bottom-link"><a href="viewMyData">マイアカウント</a></td>
							<td class="bottom-link"><a href="logout">ログアウト</a></td>
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