<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${param.bno}번 글 수정에 성공했습니다.");
	location.href="detail.do?bno=${param.bno}";
	window.opener.location.href.reload(true);
</script>

