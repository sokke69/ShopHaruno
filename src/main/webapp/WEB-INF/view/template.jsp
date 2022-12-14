<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>タイトル</title>
    
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaisei+Decol:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/default.css">
    <link rel="stylesheet" href="./css/.css">
    <link rel="stylesheet" href="./css/hf_style.css">
    
    <script src="https://kit.fontawesome.com/ec1be9ca10.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./js/bootstrap.bundle.min.js"></script>

</head>

<%-- ナビ・ロゴ ここから --%>
<c:import url="parts/header_.jsp" />
<c:import url="parts/logo.jsp" />
<%--  ここまで --%>

<%-- テーブルサンプル ここから --%>

<table class="basic">
<tr><td class="basic-top"></td></tr>
<tr><td class="basic-middle">

	<%-- テーブル中身 ここから --%>
	
		
	
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