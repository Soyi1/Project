function selcetList1(getValue){
    let getForm = document.form;
    let getOption = $("#input2 option").length;
    let setPlace = null;
    let getPlace = null;

    let list = ["서울특별시", "부산광역시", "광주광역시", "대구광역시", "대전광역시", "인천광역시", "울산광역시", "충청남도", "충청북도", "전라남도", "전라북도", "경상남도", "경상북도", "강원도", "경기도", "세종특별자시치", "제주특별자치도", "전국"];
    let getList = ["_서울특별시", "_부산광역시", "_광주광역시", "_대구광역시", "_대전광역시", "_인천광역시", "_울산광역시", "_충청남도", "_충청북도", "_전라남도", "_전라북도", "_경상남도", "_경상북도", "_강원도", "_경기도", "_세종특별자시치", "_제주특별자치도", "_전국"];

    if (getValue == "") {
        setPlace = new Array("행정구역을 선택하세요.");
        getPlace = new Array("");
    } else if (getValue == "2010") {
        setPlace = new Array("서울특별시", "부산광역시", "광주광역시", "대구광역시", "대전광역시", "인천광역시", "울산광역시", "충청남도", "충청북도", "전라남도", "전라북도", "경상남도", "경상북도", "강원도", "경기도", "제주특별자치도", "전국");
        getPlace = new Array("_서울특별시", "_부산광역시", "_광주광역시", "_대구광역시", "_대전광역시", "_인천광역시", "_울산광역시", "충청남도_2015", "_충청북도", "_전라남도", "_전라북도", "_경상남도", "_경상북도", "_강원도", "경기도_2015", "_제주특별자치도", "_전국");
    } else if (getValue == "2015") {
        setPlace = list;
        getPlace = getList;
    } else if (getValue == "2020") {
        setPlace = list;
        getPlace = getList;
    } else if (getValue == "2022") {
        setPlace = list;
        getPlace = getList;
    }

    for(let i = 0; i < getOption; i++) {
        getForm.inputPlace2.options[0] = null;
    }

    for(let k = 0; k < setPlace.length; k++) {
        getForm.inputPlace2.options[k] = new Option(setPlace[k], getPlace[k]);
    }
}