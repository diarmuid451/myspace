// 팝업창 띄우기
// 새로운 window창을 열 경우 사용되는 함수(arg : 주소, 창제목, 넓이, 길이) 
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) /2;
	wintop = (screen.height - WinHeight) /2;
	var win = window.open(UrlStr, WinTitle, "scrollbars=yes,width="+ WinWidth+", "
				+"height="+WinHeight+", top="+wintop+", left="+winleft+", resizable=yes, status=yes");
	win.focus();
}

function CloseWindow() {
	window.opener.location.reload(true);
	window.close();
}

//===============================================

//form submit
function SubmitMemberRegist(formRole){
	var uploadCheck = $("input[name='checkUpload']").val();
	if(!(uploadCheck>0)) {
		alert("사진 업로드는 필수 입니다.");
		//$("input[name='pictureFile']").click();
		return;
	}
	var form = $('form[role="'+formRole+'"]');
	form.submit();
}


//------------------------------------------

function SubmitMemberModify(formRole){
	var form = $('form[role="'+formRole+'"]');
	form.submit();
}
// cancel
function Rollback() {
	history.go(-1);
}		

