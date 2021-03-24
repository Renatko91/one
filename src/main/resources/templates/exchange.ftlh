<#import "part/common.ftlh" as c>


<@c.page>
    <form action="/logout" method="post">
        <h1><a href = "/history"> История </a></h1>
        </br>
        <input type="submit" value="Выход"/>
    </form>
    <form action="/exchange" method="post">
        <h2>Конвертер</h2>
        <h3>Из какой валюты</h3>
        <select name="code">
            <#list charCodes as code>
                <option value="${code}">${code}</option>
            </#list>
        </select>
        <h3>Сколько</h3>
        <input type="text" name="need" />
        </br>
        <h3>В какую валюту</h3>
        <select name="codeTwo">
            <#list charCodes as codeTwo>
            <option value="${codeTwo}">${codeTwo}</option>
        </#list>
        </select>
        <h3>Результат</h3>
        <#if total??>
            <input type="text" value="${total}"/>
        <#else>
            <input type="text"/>
        </#if>
        </br>
        <input type="submit" value="Отправить"/>
    </form>
</@c.page>