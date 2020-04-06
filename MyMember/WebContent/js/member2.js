/**
 * 
 */

var idcheck = function(){
	vid = $("#id").val().trim();
	idlen = vid.length;
	
	if(idlen == 0) {
		alert("아이디를 입력해주세요.");
		$(this).blur();
		return false;
	} 
	if(idlen < 4  || idlen > 12) {
		alert("아이디는 4~12자리로 설정해주세요.");
		$(this).blur();
		return false;
	}
	
	idreg = /^[a-z][0-9a-zA-Z]{3,11}$/;
	if(!(idreg.test(vid))) {
		alert("아이디 형식 오류");
		$(this).blur();
		return false;
	}
	
	return true;
}

var passcheck = function() {
	vpass = $("#pass").val();
	passlen = vpass.trim().length;
	
	if(passlen == 0) {
		alert("비밀번호를 입력해주세요.");
		$(this).blur();
		return false;
	} 
	if(passlen < 4  || passlen > 10) {
		alert("비밀번호는 4~10자리로 설정해주세요.");
		$(this).blur();
		return false;
	}
	
	passreg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{4,10}$/;
	if (!(passreg.test(vpass))) {
		alert("비밀번호 형식 오류");
		$(this).blur();
		return false;
	}
	
	return true;
}

var pass2check = function(){
	pass = $("#pass").val();
	passCheck = $("#passCheck").val();
	checklen = passCheck.trim().length;
	
	if(checklen == 0){
		alert("비밀번호확인창에 비밀번호를 입력해주세요.");
		$(this).blur();
		return false;
	}
	
	if(pass != passCheck) {
		alert("비밀번호가 다릅니다.");
		$(this).blur();
		return false;
	}
	
	return true;
}

var bircheck = function(){
	vbir = $("#bir").val();
	birlen = vbir.trim().length;
	if(birlen == 0) {
		alert("생년월일을 입력해 주세요.");
		$(this).blur();
		return false;
	}
	
	return true;
}

var namecheck = function(){
	vname = $("#name").val();
	namelen = vname.trim().length;
	if(namelen == 0) {
		alert("이름을 입력해 주세요.");
		$(this).blur();
		return false;
	}
	namereg = /^[가-힣]+|^[a-zA-Z]+$/;
	if(namereg.test(vname)) {
		rkor = /^[가-힇]+$/;
		reng = /^[a-zA-Z]+$/;
		if (rkor.test(vname)) {
			if (namelen < 2 || namelen > 5) {
				alert("한글 이름은 2~5자리 입니다.");
				$(this).blur();
				return false;
			}
		} else if(reng.test(vname)) {
			if(namelen < 5 || namelen > 10) {
				alert("영문 이름은 5~10자리 입니다.");
				$(this).blur();
				return false;
			}
		} else {
			alert("이름 형식 오류입니다.");
			$(this).blur();
			return false;
		}
	} else {
		alert("이름 형식 오류입니다.");
		$(this).blur();
		return false;
	}
	
	return true;
}

var telcheck = function(){
	vtel = $("#phon").val();
	tellen = vtel.trim().length;
	
	if(tellen == 0) {
		alert("전화번호를 입력해주세요.");
		$(this).blur();
		return false;
	}
	
	telreg = /^\d{3}-\d{4}-\d{4}$/;
	if (!(telreg.test(vtel))) {
		alert("숫자 사이에 '-'를 삽입해주세요.");
		$(this).blur();
		return false;
	}
	
	return true;
}

var emailcheck = function(){
	vmail= $("#email").val();
	maillen = vmail.trim().length;
	
	if(maillen == 0) {
		alert("이메일 주소를 입력해주세요.");
		$(this).blur();
		return false;
	}
	
	mailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
	if (!(mailreg.test(vmail))) {
		alert("이메일 형식 오류.");
		$(this).blur();
		return false;
	}
	
	return true;
}

