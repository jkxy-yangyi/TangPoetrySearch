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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
							<h2>全唐诗搜索网站</h2>
							<div class="clear-block">
								<div id="node-2" class="node">
									<div class="content clear-block">
										<form method="post" action="/" name="glb">
											<input type="text" name="q" value="quantangshi"> 
											<select name="lib">
												<option value='lbl_Title'>题目
												<option value='lbl_Author'>作者
												<option value='lbl_Body'>诗歌内容
											</select> <input type="text" name="k" size="40" maxlength="60"
												value="">
											<button type="submit" id="DoSearch">search</button>
										</form>
										<%
		List poes = (List) session.getAttribute("poes");
		Iterator iter = poes.iterator();
	%> 
										<table width="100%" border="0" cellpadding="1" cellspacing="0">
									 	<%--<%
											int i = 0;
											if(iter.hasNext())
											while (i<10) {
												Poetries p = (Poetries)iter.next();
												Poets poets = new PoetsService().poet(p.getPoet_id());
										%>--%> 
											<tr>
												<td class="AlternateRow" colspan="2"
													style="padding-left: 4px;" align="left" valign="middle"
													width="100%"><span class="title"
													style="padding-top:2px;text-align:left;float:left;FONT-SIZE: 16px">
														<%--<%=p.getTitle()%>
												--%></span>
												</td>
											</tr>
											<tr>
												<td><span style="FONT-SIZE: 12px">
												<%--<%=poets.getName()%>
												--%></span><br> <span> </span><br>
													<%--<div
														style="background-color:#F2F2F2;border-top-width:1px;border-bottom-width:1px;border-left-width:0px;border-right-width:0px;border-style:dotted;border-color:#999999;padding:15px;line-height:150%;width:390px;text-align:left;float:left;FONT-SIZE: 16px"><%=p.getContent()%></div>--%>
													<br></td>
											</tr><%--
											 <%
												i++;
												}
											%> 
										--%></table>
										<div class="item-list">
											<ul class="pager">
												<li class="pager-current first">1</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=1" title="Go to page 2"
													class="active">2</a>
												</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=2" title="Go to page 3"
													class="active">3</a>
												</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=3" title="Go to page 4"
													class="active">4</a>
												</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=4" title="Go to page 5"
													class="active">5</a>
												</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=5" title="Go to page 6"
													class="active">6</a>
												</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=6" title="Go to page 7"
													class="active">7</a>
												</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=7" title="Go to page 8"
													class="active">8</a>
												</li>
												<li class="pager-item"><a
													href="/?q=quantangshi&amp;page=8" title="Go to page 9"
													class="active">9</a>
												</li>
												<li class="pager-ellipsis">…</li>
												<li class="pager-next"><a
													href="/?q=quantangshi&amp;page=1" title="Go to next page"
													class="active">next ›</a>
												</li>
												<li class="pager-last last"><a
													href="/?q=quantangshi&amp;page=12907"
													title="Go to last page" class="active">last »</a>
												</li>
											</ul>
										</div>
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

</body>
</html>
