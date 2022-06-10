/**
 * 
 */
 
 function setHeader(User) {
		if(User != undefined) {
			$("#signIn").remove();
			$("#signUp").remove();
			
			$("#login").append("<span id=\"hello\" style=\"padding-top: 50px\">" + User + "님, 안녕하세요.</span>");
			$("#login").append("<button type=\"button\" id=\"logout\">로그아웃</button><br>");
			$("#login").append("<br><button type=\"button\" id=\"myInfo\">내 정보</button>");
			
			$("#logout").on("click", function() {
				location.href="http://localhost/java_project/log/out";
			});
			
			$("#myInfo").on("click", function() {
				location.href="http://localhost/java_project/myInfo.html"
		});
	}
}