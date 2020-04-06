/**
 * 
 */

var regcheck = function() {
	
	vname = $("#name").val();
	namelen = vname.trim().length;
	if(namelen == 0) {
		alert("이름을 입력해 주세요.");
		return false;
	}
	if (namelen < 2 || namelen > 5) {
		alert("한글 이름은 2~5자리 입니다.");
		return false;
	}
	namereg = /^[가-힣]+$/;
	if(!(namereg.test(vname))) {
		alert("이름 형식 오류입니다.");
		return false;
	}
	
	vbir = $("#bir").val();
	birlen = vbir.trim().length;
	if(birlen == 0) {
		alert("생년월일을 입력해 주세요.");
		return false;
	}
	birtreg = /^\d{4}-\d{2}-\d{2}$/;
	if (!(birtreg.test(vbir))) {
		alert("생년월일 형식 오류.");
		return false;
	}
	
	// \w+(?=str) >> str을 찾아서 str을 기준으로 앞에 한번이상 나오는 문자나 숫자를 검색
	// \w*(?=str) >> str을 찾아서 str을 기준으로 문자나 숫자가 없을시 str로 시작
	vpass = $("#pass").val();
	passlen = vpass.trim().length;
	
	if(passlen == 0) {
		alert("비밀번호를 입력해주세요.");
		return false;
	} 
	if(passlen < 4  || passlen > 10) {
		alert("비밀번호는 4~10자리로 설정해주세요.");
		return false;
	}
	
	passreg = /^[a-zA-Z0-9]+$/;
	if (!(passreg.test(vpass))) {
		alert("영문과 숫자로 설정해주세요.");
		return false;
	}
	
	vtel = $("#phon").val();
	tellen = vtel.trim().length;
	
	if(tellen == 0) {
		alert("전화번호를 입력해주세요.");
		return false;
	}
	
	telreg = /^\d{3}-\d{4}-\d{4}$/;
	if (!(telreg.test(vtel))) {
		alert("숫자 사이에 '-'를 삽입해주세요.");
		return false;
	}
	
	vmail= $("#email").val();
	maillen = vmail.trim().length;
	
	if(maillen == 0) {
		alert("이메일 주소를 입력해주세요.");
		return false;
	}
	
	mailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
	if (!(mailreg.test(vmail))) {
		alert("이메일 형식 오류. @를 반드시 넣어주세요.");
		return false;
	}
	
	vzip = $("#zip").val();
	ziplen = vzip.trim().length;
	
	if(ziplen == 0) {
		alert("우편번호를 직접 입력하시거나 번호검색을 사용해 주세요.");
		return false;
	}
	
	vadd1 = $("#add1").val();
	addlen = vadd1.trim().length;
	
	if(addlen == 0) {
		alert("주소를 직접 입력하시거나 번호검색을 사용해 주세요.");
		return false;
	}
	vadd2 = $("#add2").val();
	addrlen = vadd2.trim().length;
	
	if(addrlen == 0) {
		alert("상세주소를 입력해주세요.");
		return false;
	}
	return true;
}