<%--
  Created by IntelliJ IDEA.
  User: ztw
  Date: 2020/8/2
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script>
        function a() {
            $.post({
                url:"${pageContext.request.contextPath}/user/loginA1",
                data:{'username':$("#username").val()},
                success:function (data) {
                    if(data.toString()=='用户名被注册，请重新输入用户名！'){
                        $("#userInfo").css("color","red");

                    }
                    else {
                        $("#userInfo").css("color","green");
                        
                    }
                    $("#userInfo").html(data);
                }

            })
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/loginAdd">
    <p>
        用户名：<input type="text" id="username" name="=username" onblur="a()"/>
        <span id="userInfo"></span>
    </p>
    <p>密码：<input type="password" name="password"/> </p>
    <p>
        <input type="submit" value="注册">
    </p>

</form>
</body>
</html>
