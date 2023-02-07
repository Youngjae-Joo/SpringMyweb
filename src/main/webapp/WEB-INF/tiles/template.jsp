<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>투어리스트인투어</title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/swiper.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/rollmain.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.easing.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.smooth-scroll.min.js"></script>

</head>
<body>
	<!-- 타일즈 뷰에서 정의한 name값이 들어갑니다. -->
	<div id="wrap">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>

	<tiles:insertAttribute name="left" />
</body>
</html>