<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>カテゴリ削除</title>

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
						<th class="subject" colspan=2>カテゴリ削除</th>
					</tr>
					<tr>
						<td colspan=2><hr></td>
					</tr>
					<tr>
                            <th class="head">ID</th>
                            <td><c:out value="${aCategory.id}" /></td>
                        </tr>
                        <tr>
                            <th>カテゴリ名</th>
                            <td><c:out value="${aCategory.aCategoryName}" />
                            </td>
                        </tr>
					<tr>
					<td colspan=2><div class="submit"><input type="submit" value="決定" class="btn btn-secondary"></div>
					</td>
					</tr>
					<tr>
						<td colspan=2><hr></td>
					</tr>
					<tr>
						<td colspan=2>
							<table>
								<tr>
									<td class="bottom-link"><a href="listUser">戻る</a></td>
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