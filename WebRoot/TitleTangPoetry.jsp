<%@page import="com.jkxy.entity.Poets"%>
<%@page import="com.jkxy.entity.Poetries"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>标题搜索</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" media="all" href="css/defaults.css" />
<link type="text/css" rel="stylesheet" media="all" href="css/system.css" />
<link type="text/css" rel="stylesheet" media="all" href="css/system-menus.css" />
<link type="text/css" rel="stylesheet" media="all" href="css/style.css" />
</head>

<body>
	
	<div id="header-region" class="clear-block"></div>
	<div id="wrapper">
		<div id="container" class="clear-block">
			<div id="header">
				<div id="logo-floater"></div>
			</div>
			<div id="center">
				<div id="squeeze">
					<div class="right-corner">
						<div class="left-corner" style="text-align: center;">
							<h2>全唐诗搜索引擎</h2>
							<div class="clear-block">
								<div id="node-2" class="node">
									<div class="content clear-block">
										<form method="post" action="poetry/TangPoetryServlet" name="glb">
											<select name="lib">
												<option value='lbl_Title'>题目
												<option value='lbl_Author'>作者
												<option value='lbl_Body'>诗歌内容
											</select> <input type="text" name="k" size="40" maxlength="60"
												value="">
											<button type="submit" id="DoSearch">搜&nbsp索</button>
										</form>
										<%
											Poetries poetries = (Poetries)session.getAttribute("poetries");
											List poetriesList = (List)session.getAttribute("poetriesList");
											Iterator iter = poetriesList.iterator();
										%>
										<table width="100%" border="0" cellpadding="1" cellspacing="0">
											<%
												if(poetries != null){
											%>
											<tr>
												<td class="AlternateRow" colspan="2"
													style="padding-left: 4px;" align="left" valign="middle"
													width="100%"><span class="title"
													style="padding-top:2px;text-align:left;float:left;FONT-SIZE: 16px">
														《<%=poetries.getTitle()%>》
												</span>
												</td>
											</tr>
											<tr>
												<td><span style="FONT-SIZE: 12px">
													<a href="poetry/TangPoetryServlet?lib=lbl_Author&k=<%= poetries.getName()%>"><font color="blue">作者：<%=poetries.getName()%></font></a>
												</span><br> <span> </span><br>
													<div
														style="background-color:#F2F2F2;border-top-width:1px;border-bottom-width:1px;border-left-width:0px;border-right-width:0px;border-style:dotted;border-color:#999999;padding:15px;line-height:150%;width:390px;text-align:left;float:left;FONT-SIZE: 16px"><%=poetries.getContent()%></div>
													<br></td>
											</tr>
											<%	}else{
												int i = 0;
												while (iter.hasNext()) {
												Poetries poe = (Poetries) iter.next();
											%>
											<tr>
												<td class="AlternateRow" colspan="2"
													style="padding-left: 4px;" align="left" valign="middle"
													width="100%"><span class="title"
													style="padding-top:2px;text-align:left;float:left;FONT-SIZE: 16px">
														《<%=poe.getTitle()%>》
												</span>
												</td>
											</tr>
											<tr>
												<td><span style="FONT-SIZE: 12px">
													<a href="poetry/TangPoetryServlet?lib=lbl_Author&k=<%= poe.getName()%>"><font color="blue">作者：<%=poe.getName()%></font></a>
												</span><br> <span> </span><br>
													<div
														style="background-color:#F2F2F2;border-top-width:1px;border-bottom-width:1px;border-left-width:0px;border-right-width:0px;border-style:dotted;border-color:#999999;padding:15px;line-height:150%;width:390px;text-align:left;float:left;FONT-SIZE: 16px"><%=poe.getContent()%></div>
													<br></td>
											</tr>
											<%	
												i++;
												}
											}
											%>
									  </table>
										
									</div>
									<div class="clear-block">
										<div class="meta"></div>
									</div>
								</div>
							</div>
							<div id="footer"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
     <%
     Object message = request.getAttribute("message");
     if(message!=null && !"".equals(message)){
 
  %>
      <script type="text/javascript">
          alert("<%=message%>");
      </script>
  <%} %>
</body>
</html>
