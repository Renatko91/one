<#import "part/common.ftlh" as c>
<#import "part/authform.ftlh" as af>

<h1>Регистрация</h1>
<@c.page>
<@af.authform "/reg" "Зарегистрировать" "/login" "Войти">
    </br>
    <#if message??>
        <h1>${message}</h1>
    </#if>
</@af.authform>
</@c.page>