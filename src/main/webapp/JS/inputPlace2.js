function selcetList2(getValue){
    let getForm = document.form;
    let getOption = $("#input3 option").length;
    let setPlace = null;
    let getPlace = null;
2
    if (getValue == "") {
        setPlace = new Array("도시를 선택하세요.");
        getPlace = new Array("");
    } else if (getValue == "_서울특별시") {
        setPlace = new Array("서울특별시");
        getPlace = new Array("서울특별시");
    } else if (getValue == "_부산광역시") {
        setPlace = new Array("부산광역시");
        getPlace = new Array("부산광역시");
    } else if (getValue == "_광주광역시") {
        setPlace = new Array("광주광역시");
        getPlace = new Array("광주광역시");
    } else if (getValue == "_대구광역시") {
        setPlace = new Array("대구광역시");
        getPlace = new Array("대구광역시");
    } else if (getValue == "_대전광역시") {
        setPlace = new Array("대전광역시");
        getPlace = new Array("대전광역시");
    } else if (getValue == "_광주광역시") {
        setPlace = new Array("광주광역시");
        getPlace = new Array("광주광역시");
    } else if (getValue == "_인천광역시") {
        setPlace = new Array("인천광역시");
        getPlace = new Array("인천광역시");
    } else if (getValue == "_울산광역시") {
        setPlace = new Array("울산광역시");
        getPlace = new Array("울산광역시");
    } else if (getValue == "_충청남도") {
        setPlace = new Array("충청남도", "천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시");
        getPlace = new Array("충청남도", "천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시");
    } else if (getValue == "_충청북도") {
        setPlace = new Array("충청북도", "충북 청주시", "충주시", "제천시", "청주시");
        getPlace = new Array("충청북도", "충북 청주시", "충주시", "제천시", "청주시");
    } else if (getValue == "_전라남도") {
        setPlace = new Array("전라남도", "목포시", "여수시", "순천시", "나주시", "광양시");
        getPlace = new Array("전라남도", "목포시", "여수시", "순천시", "나주시", "광양시");
    } else if (getValue == "_전라북도") {
        setPlace = new Array("전라북도", "전주시", "군산시", "익산시", "정읍시", "남원시", "김제시");
        getPlace = new Array("전라북도", "전주시", "군산시", "익산시", "정읍시", "남원시", "김제시");
    } else if (getValue == "_경상남도") {
        setPlace = new Array("경상남도", "경남 창원시", "마산시", "진주시", "경남 진해시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "창원시");
        getPlace = new Array("경상남도", "경남 창원시", "마산시", "진주시", "경남 진해시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "창원시");
    } else if (getValue == "_경상북도") {
        setPlace = new Array("경상북도", "포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시");
        getPlace = new Array("경상북도", "포항시", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시");
    } else if (getValue == "_강원도") {
        setPlace = new Array("강원도", "춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시");
        getPlace = new Array("강원도", "춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시");
    } else if (getValue == "_경기도") {
        setPlace = new Array("경기도", "수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "평택시", "동두천시", "안산시", "고양시", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시", "여주시");
        getPlace = new Array("경기도", "수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "평택시", "동두천시", "안산시", "고양시", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시", "여주시");
    } else if (getValue == "_세종특별자치시") {
        setPlace = new Array("세종특별자치시");
        getPlace = new Array("세종특별자치시");
    } else if (getValue == "_제주특별자치도") {
        setPlace = new Array("제주특별자치도", "제주시", "서귀포시");
        getPlace = new Array("제주특별자치도", "제주시", "서귀포시");
    } else if (getValue == "_전국") {
        setPlace = new Array("전국");
        getPlace = new Array("전국");
    } else if (getValue == "충청남도_2015") {
        setPlace = new Array("충청남도", "천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시");
        getPlace = new Array("충청남도", "천안시", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시");
    } else if (getValue == "경기도_2015") {
        setPlace = new Array("경기도", "수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "평택시", "동두천시", "안산시", "고양시", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시");
        getPlace = new Array("경기도", "수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "평택시", "동두천시", "안산시", "고양시", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시");
    }

    for(let i = 0; i < getOption; i++) {
        getForm.inputPlace3.options[0] = null;
    }

    for(let k = 0; k < setPlace.length; k++) {
        getForm.inputPlace3.options[k] = new Option(setPlace[k], getPlace[k]);
    }
}