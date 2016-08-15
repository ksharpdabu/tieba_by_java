
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>凤姐专区</title>
	<link rel="stylesheet" type="text/css" href="css/main.css"> 
</head>
<body>
	<!-- 简单搜索表单 -->
	<div style="margin: 15px auto; " >
		<!-- 搜索表单 -->
		<s:form action="TopicAction_list" namespace="/" theme="simple" cssClass="simpleSearchForm">
			<font class="logoLabel">传智播客贴吧</font>
			<s:textfield name="key" cssClass="queryString"></s:textfield>
			<input type="submit" value="搜 索"/>
		</s:form>





	</div>
	<!-- 菜单 -->
	<div class="menubar">
		<a href="index.jsp">主题列表</a>
	</div>
	
	<!-- 当前主题贴数 -->
	<div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
		共有<font color="red"> <s:property value="#topic.replySet.size"/> </font>篇帖子
	</div>
	
	<!-- 显示主题 -->
	<table class="postList" cellspacing="0">
	    <tr class="title">
	        <td width="20" class="num">1</td>
	        <td> <s:property value="#topic.title" /> </td>
	    </tr>
	    <tr class="content">
	        <td></td>
	        <td><pre> <s:property value="#topic.topicContent"/>  </pre></td>
	    </tr>
	    <tr class="info">
	        <td></td>
	        <td>
				作者：<font color="blue"><s:property value="#topic.ipAddr"/> </font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <font color="#999999">发帖时间： <s:date name="#topic.createDate" format="yyyy-MM-dd hh:mm:ss" /> </font>
	        </td>
	    </tr>
	</table>
	
	<!-- 显示回复列表 -->

	<s:iterator value="#topic.replyList"  var="item"  >

		<table class="postList" cellspacing="0">
			<tr class="title">
				<td width="20" class="num"> <s:property value="#item.index" /> </td>
				<td></td>
			</tr>
			<tr class="content">
				<td></td>
				<td><pre> <s:property value="#item.replyContent" /> </pre></td>
			</tr>
			<tr class="info">
				<td></td>
				<td>
					作者：<font color="blue"> <s:property value="ipAddr" /></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#999999">回帖时间： <s:date name="createDate" format="yyyy-MM-dd hh:mm:ss"/> </font>
				</td>
			</tr>
		</table>


	</s:iterator>

    
    <div style="margin-bottom: 20px"></div>
	<!-- 发表回复表单 -->
	<s:form action="TopicAction_reply" namespace="/" theme="simple"  class="addNewTopicForm">

		<s:hidden name="topic.tid" value="%{#topic.tid}" />

		<table class="publishArticleForm">
			<tr>
				<td class="label">内　容:</td>
				<td>

					<s:textarea name="reply.replyContent" class="content" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="回　贴"/></td>
			</tr>
		</table>

	</s:form>

</body>
</html>