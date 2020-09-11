<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session</title>
	<%@ include file="/pages/common/head.jsp"%>
	<style type="text/css">

	ul li {
		list-style: none;
	}
	
</style>
</head>
<body>
	<iframe name="target" width="500" height="500" style="float: left;"></iframe>
	<div style="float: left;">
		<ul>
			<li><a href="sessionServlet?action=createOrGetSession" target="target">Session的创建和获取（id号、是否为新创建）</a></li>
			<li><a href="sessionServlet?action=setAttribute" target="target">Session域数据的存储</a></li>
			<li><a href="sessionServlet?action=getAttribute" target="target">Session域数据的获取</a></li>
			<li>Session的存活</li>
			<li>
				<ul>
					<li><a href="sessionServlet?action=defaultLife" target="target">Session的默认超时及配置</a></li>
					<li><a href="sessionServlet?action=life3" target="target">Session3秒超时销毁</a></li>
					<li><a href="sessionServlet?action=deleteNow" target="target">Session马上销毁</a></li>
				</ul>
			</li>
			<li><a href="" target="target">浏览器和Session绑定的原理</a></li>
		</ul>
	</div>
</body>
</html>