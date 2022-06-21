/**
 * 
 */
 
function setHeader(loginUser) {
    if(loginUser != undefined) {
        $("#signIn").remove();
        $("#signUp").remove();

        $("#login").append("<span id=\"hello\" style=\"padding-top: 50px\">" + loginUser + "님, 안녕하세요.</span>");
        $("#login").append("<button type=\"button\" id=\"logout\">로그아웃</button><br>");
        $("#login").append("<br><button type=\"button\" id=\"myInfo\">내 정보</button>");

        $("#logout").on("click", function() {
            location.href="/log/out";
        });

        $("#myInfo").on("click", function() {
            location.href = "/myInfo.html";
        });
    }
}