$(function(){
    let today = new Date();

    let month = today.getMonth() + 1;  // 월
    let date = today.getDate();  // 날짜

    var apiURI = "https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=fa56402f3cb78b5d3177c1fa1a4514d0";

    $.ajax({
        url: apiURI,
        dataType: "json",
        type: "GET",
        async: "false",
        success: function(resp) {
            console.log(resp);
            console.log("현재온도 : "+ (resp.main.temp- 273.15).toFixed(1) + "ºC" );
            console.log("날씨 : "+ resp.weather[0].main );
            console.log("상세날씨설명 : "+ resp.weather[0].description );
            console.log("날씨 이미지 : "+ resp.weather[0].icon );
            console.log("구름  : "+ (resp.clouds.all) +"%" );
            $("#weather_icon").attr('src', checkIcon(resp));
            $("#weather").html(month + "." + date + "&nbsp&nbsp&nbsp" + (resp.main.temp- 273.15).toFixed(1) + "ºC");
        }
    })

    function checkIcon(resp){
        let weather = resp.weather[0]['main'];
        let str = "";

        switch (weather) {
            case 'Clouds':
                str = "/images/weather/sunny_cloud.png";
                break;
            case 'Clear':
                str = "/images/weather/sunny.png";
                break;
            case 'Thunderstorm':
                str = "/images/weather/thunder.png";
                break;
            case 'Drizzle':
                str = "/images/weather/rainy.png";
                break;
            case 'Rain':
                str = "/images/weather/rainy.png";
                break;
            case 'Snow':
                str = "/images/weather/snowman.png";
                break;
            case 'Atmosphere':
                str = "/images/weather/smog.png";
                break;
            case 'weather-default':
                str = "/images/weather/cloud.png";
                break;
        }
        return str;
    }

});