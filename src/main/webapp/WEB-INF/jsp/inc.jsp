<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page</title>
    <link href="/libryries/js/jquery-1.9.1.min.js">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
</head>

<body>

<h1>Hello + ${name}</h1>

<div>
<%--    <form action="/incident/list" method="post"><br>--%>
        <input id="afterDate" name="afterDate" placeholder="afterDate"><br>
        <input id="onDate" name="onDate" placeholder="onDate"><br>
        <input id="onDateEnd" name="onDateEnd" placeholder="onDateEnd"><br>
        <input id="maxCount" name="maxCount" placeholder="maxCount"><br>
        <select id="sortOrder" name="sortOrder" title="sortOrder">
            <option name="" value="byCreationDateDesc" selected>byCreationDateDesc</option>
            <option name="" value="byCreationDateAsc">byCreationDateAsc</option>
            <option name="" value="byBusinessUpdateDateDesc">byBusinessUpdateDateDesc</option>
            <option name="" value="byBusinessUpdateDateAsc">byBusinessUpdateDateAsc</option>
        </select><br>
        <input id="systemId" name="systemId" placeholder="systemId"><br>
        <input id="incidentId" name="incidentId" placeholder="incidentId"><br>
<%--        onchange="onFilterTypeChanged(this.value)"--%>
        <select id="filterType" name="filterType"  title="filterType">
            <option value="noFilter" >Не фильтровать</option>
            <option value="last7days" selected="selected">За последние 7 дней</option>
            <option value="lastWeek">За последнюю неделю</option>
            <option value="date">За определенную дату</option>
            <option value="dateInterval">За период времени</option>
        </select><br>
        <select id="visibleType" name="visibleType" title="visibleType">
            <option value="visible">Не отображать</option>
            <option value="all">Отображать все</option>
            <option value="hidden" selected="selected">Только скрытые</option>
        </select><br>
        <input id="systemIds" name="systemIds" placeholder="systemIds"><br>

        <button onclick="getIncs()">Получить список случаев</button>

        <div id="incidentList">

        </div>
<%--    </form>--%>
</div>

<script>

    function getIncs() {
        let afterDate = $('#afterDate').val();
        let onDate = $('#onDate').val();
        //let dStart = new Date(onDate);
        let onDateEnd = $('#onDateEnd').val();
        //let dEnd = new Date(onDateEnd);
        let maxCount = $('#maxCount').val();
        let sortOrder = $('#sortOrder').val();
        let systemId = $('#systemId').val();
        let incidentId = $('#incidentId').val();
        let filterType = $('#filterType').val();
        let visibleType = $('#visibleType').val();
        let systemIds = $('#systemIds').val();

        let params = {};
        params = params.afterDate;
        params = params.onDate;
        params = params.onDateEnd;
        params = params.maxCount;
        params = params.sortOrder;
        params = params.systemId;
        params = params.incidentId;
        params = params.filterType;
        params = params.visibleType
        params = params.systemIds;

        $.ajax({
            url: "../incident/list",
            method: "POST",
            contentType: "application/json",
            date: JSON.stringify(params),

            success: function (data) {
                console.log("json: " + JSON.stringify(data));
                $('#incidentList').html(JSON.stringify(data));
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

</script>
</body>
</html>