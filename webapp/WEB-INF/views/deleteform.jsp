<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.sds.icto.guestbook.vo.guestbookVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%
guestbookVo vo = new guestbookVo();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook3/delete" method="post" >
	<input type='hidden' name="no" value="${param.no }">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/guestbook3/index">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>