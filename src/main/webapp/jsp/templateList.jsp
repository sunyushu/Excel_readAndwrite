<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta content="no-cache" http-equiv="pragma">
	<meta content="no-cache" http-equiv="cache-control">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/jquery-2.1.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/themes/icon.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/commons.js"></script>
	<script type="text/javascript">
		$(function(){
			/**
			* 初始化数据表格
			*/
			$("#t_importdata").datagrid({
				idField:"id",
				title:"数据列表",
				fit:true,
				height:450,
				url:"<%=request.getContextPath() %>/template_list.action?page=1&rows=10",
				fitColumns:true,
				striped:true,
				loadMsg:"数据正在加载，请耐心等待...",
				rownumbers:true,
				frozenColumns:[[//冻结列特性，不要与fitColumns特性一致
					{
						field:"ck",
						width:50,
						checkbox:true
					}
				]],
				columns:[[
					{
						field:"import_id",
						title:"主表id",
						width:100,
						hidden:true
					},{
						field:"import_data_type",
						title:"数据类型",
						width:100,
						sortable:true
					},{
						field:"import_date",
						title:"导入时间",
						width:100,
						sortable:true
					},{
						field:"import_status",
						title:"导入标志",
						width:100,
						formatter:function(value,record,index){
							if(value == 1){
								return "导入成功";
							}else if(value == 0){
								return "导入失败";
							}
						}
					},{
						field:"handleDate",
						title:"处理时间",
						width:100
					},{
						field:"handle_status",
						title:"处理标志",
						width:100,
						formatter:function(value,record,index){
							if(value == 1){
								return "处理成功";
							}else if(value == 0){
								return "处理失败";
							}
						}
					}
				]],
				pagination:true,
				pageSize:10,
				pageList:[5,10,15,20,50],
				toolbar:[
					{
						text:"导入模板",
						iconCls:"icon-add",
						handler:function(){
							$("#templateDialog").dialog("open");
						}
					}
				]
			});
			<%-- 下载模板事件触发 --%>
			$("#okBtn").click(function(){
				//获取选择模版ID
				var str = $("#templates").combobox("getValue");
				$("#templateDialog").dialog("close");
				$("#importDialog").dialog("open");
				var val = "<%=request.getContextPath() %>/download.action?template_id="+str;
				$("#downloadTemplate").attr("href",val);
				alert(val);
			});
		});
	</script>
</head>
<body>
	<div id="lay" class="easyui-layout" style="width:100%;height:100%;">
		<div region="center">
			<table id="t_importdata"></table>
		</div>
	</div>
	<!-- 选择模板按钮 -->
	<div id="templateDialog" title="选择模版" modal=true draggable=false
		class="easyui-dialog" closed=true style="width:350px;height:220px;">
		<form action="">
			<table>
				<tr>
					<td>选择模版</td>
					<td>
						<input id="templates" name="templates" class="easyui-combobox"
							url="<%=request.getContextPath() %>/template_templates.action" valueField="template_id" textField="template_name" value="Om_cust_price_list"/>
						<a id="okBtn" class="easyui-linkbutton">确定</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 导入模板界面 -->
	<div id="importDialog" title="导入Excel" modal=true draggable=false
		class="easyui-dialog" closed=true style="width:350px;height:220px">
		<form action="">
			<table>
				<tr>
					<td>下载模版：</td>
					<td>
						<a id="downloadTemplate">导入模版</a>
					</td>
				</tr>
				<tr>
					<td>预览</td>
					<td>
						<input id="fileInput" name="fileInput" type="file"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="fileQueue"></div>
						<a id="uploadBtn" class="easyui-linkbutton">导入</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>