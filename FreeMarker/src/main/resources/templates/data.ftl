<!DOCTYPE html>
<html>
<head>
    <title>title</title>
</head>

<body>
this is a freemarker page!!!

get data : ${name}

<br>

List data:

<#list userList as user>
    ${user} <br>
</#list>

</body>
</html>