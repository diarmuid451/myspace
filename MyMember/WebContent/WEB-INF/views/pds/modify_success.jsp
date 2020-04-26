<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${param.pno}번 글 수정에 성공했습니다.");
	location.href="detail.do?pno=${param.pno}";
	window.opener.location.href.reload(true);
</script>

