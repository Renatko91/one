<#import "part/common.ftlh" as c>
<#import "part/authform.ftlh" as af>

<h1>Вход</h1>
<@c.page>
<@af.authform "/login" "Войти" "/reg" "Регистрация">
</@af.authform>
</@c.page>