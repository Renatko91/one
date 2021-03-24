<#import "part/common.ftlh" as c>

<@c.page>
<form action="/logout" method="post">
    <h1><a href = "/exchange"> Конвертер </a></h1>
    </br>
    <input type="submit" value="Выход"/>
</form>
<form action="/history" method="post">
    <h1>История</h1>
    <h3>Исходная</h3>
    <select name="code">
        <#list charCodes as code>
        <option value="${code}">${code}</option>
    </#list>
    </select>
    <h3>Целевая</h3>
    <select name="codeTwo">
        <#list charCodes as codeTwo>
        <option value="${codeTwo}">${codeTwo}</option>
    </#list>
    </select>
    <h3>Дата</h3>
    <input type="date" name="need" />

    <table border="1" cellspacing="0" cellpadding="1">
        <tr class="tableHeader">
            <td>Исходная валюта</td>
            <td>Целевая валюта</td>
            <td>Исходная сумма</td>
            <td>Получаемая сумма</td>
            <td>Дата</td>
        </tr>
        <#foreach history in historys>
        <tr class="tableBody">
            <td>${history.code_from}</td>
            <td>${history.code_to}</td>
            <td>${history.val_from}</td>
            <td>${history.val_to}</td>
            <td>${history.date}</td>
        </tr>
    </#foreach>
    </table>
    </br>
    <input type="submit" value="Поиск"/>
</form>
<form action="/history" method="get">
    <input type="submit" value="Сброс"/>
</form>
</@c.page>