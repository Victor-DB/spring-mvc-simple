<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
</head>

<body>

<h1>Hello + ${name}</h1>

<div id="calendarByDay">
    Дашборд статистики:<br>
    <a href="#" onclick="getIntegration()">Получить данные с дашборда</a>
</div>

<script>

    function getIntegration() {
        $.ajax({
            url: "../getIntegrationCalendarDayWidget",
            method: "POST",
            contentType: "application/json",  //  ;charset=utf-8

            // {"result":"success","widget":{"Низкий":34,"Средний":3,"Total":43,"Высокий+":0,"Высокий":6}}
            success: function (data) {
                console.log("json: " + JSON.stringify(data));
                $('#calendarByDay').html(JSON.stringify(data));

               // $.each(data, function (key, value) {
                    //console.log("key: " + key);
                    //console.log("value: " + value);
                   // if (key == "widget") {
                     //   $.each(value, function (key1, value1) {
                            //console.log("key1: " + key1);
                            //console.log("value1: " + value1);
                       // });
                   // }
               // });

            },
            error: function (error) {
                console.log(error);
            }
        });
    }


</script>
</body>
</html>