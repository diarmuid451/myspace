<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${param.id}님 회원정보 수정이 정상적으로 완료되었습니다.");
	location.href="detail?id=${id}";
</script>