<#macro authform path name url urlname>
<form action=${path} method="post">
    <h3>Логин</h3>
    <input type = "text"  name = "username" >
    <h3>Пароль</h3>
    <input type = "password"  name = "password" >
    </br>
    <input type = "submit" value = ${name} >
    </br>
    <a href = ${url}> ${urlname} </a>
    <#nested>
</form>
</#macro>