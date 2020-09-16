<%--
  Created by IntelliJ IDEA.
  User: xiaofeiwang
  Date: 2020-09-16
  Time: 4:40 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp"%>


    <script type="text/javascript">
        $(function(){
            // ajax请求
            $("#ajaxBtn").click(function(){
                $.ajax({
                    url:"http://localhost:8080/Book/ajaxServlet",
                    // data:"action=jQueryAjax",
                    data:{action:"jQueryAjax"},
                    type:"GET",
                    success:function (data) {
                        // alert("服务器返回的数据是：" + data);
                        // var jsonObj = JSON.parse(data);
                        $("#msg").html(" ajax 编号：" + data.id + " , 姓名：" + data.name);
                    },
                    dataType : "json"
                });
            });

            // ajax--get请求
            $("#getBtn").click(function(){

                $.get("http://localhost:8080/Book/ajaxServlet",{action:"jQueryGet"},function (data) {
                    $("#msg").html(" ajax 编号：" + data.id + " , 姓名：" + data.name);
                },"json");

            });

            // ajax--post请求
            $("#postBtn").click(function(){
                // post请求
                $.post("http://localhost:8080/Book/ajaxServlet",{action:"jQueryPost"},function (data) {
                    $("#msg").html(" ajax 编号：" + data.id + " , 姓名：" + data.name);
                },"json");

            });

            // ajax--getJson请求
            $("#getJSONBtn").click(function(){
                // 调用
                $.getJSON("http://localhost:8080/Book/ajaxServlet",{action:"jQueryGetJSON"},function (data) {
                    $("#msg").html(" ajax 编号：" + data.id + " , 姓名：" + data.name);
                });

            });

            // ajax请求
            $("#submit").click(function(){
                // 把参数序列化
                alert("serialize()");
            });

        });
    </script>
</head>
<body>
<div>
    <button id="ajaxBtn">$.ajax请求</button>
    <button id="getBtn">$.get请求</button>
    <button id="postBtn">$.post请求</button>
    <button id="getJSONBtn">$.getJSON请求</button>
</div>
<div id="msg">

</div>
<br/><br/>
<form id="form01" >
    用户名：<label>
    <input name="username" type="text" />
</label><br/>
    密码：<label>
    <input name="password" type="password" />
</label><br/>
    下拉单选：<label>
    <select name="single">
    <option value="Single">Single</option>
    <option value="Single2">Single2</option>
</select>
</label><br/>
    下拉多选：
    <label>
        <select name="multiple" multiple="multiple">
            <option selected="selected" value="Multiple">Multiple</option>
            <option value="Multiple2">Multiple2</option>
            <option selected="selected" value="Multiple3">Multiple3</option>
        </select>
    </label><br/>
    复选：
    <label>
        <input type="checkbox" name="check" value="check1"/>
    </label> check1
    <label>
        <input type="checkbox" name="check" value="check2" checked="checked"/>
    </label> check2<br/>
    单选：
    <label>
        <input type="radio" name="radio" value="radio1" checked="checked"/>
    </label> radio1
    <label>
        <input type="radio" name="radio" value="radio2"/>
    </label> radio2<br/>
</form>
<button id="submit">提交--serialize()</button>
<input type="button" name="submit" value="AAA">
</body>
</html>
