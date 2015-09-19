<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta content="no-cache" http-equiv="pragma">
	<meta content="no-cache" http-equiv="cache-control">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/jquery-2.1.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/themes/icon.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
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
				url:"<%=request.getContextPath() %>/customer_list.action?page=1&rows=10",
				fitColumns:true,
				striped:true,
				loadMsg:"数据正在加载，请耐心等待...",
				rownumbers:true,
				frozenColumn:[[//冻结列特性，不要与fitColumns特性一致
					{
						field:"ck",
						width:50,
						checkbox:true
					}
				]],
				columns:[[
					{
						field:"customer_id",
						title:"CustomerID",
						width:100,
						hidden:true
					},{
						field:"first_name",
						title:"firstName",
						width:100,
						sortable:true
					},{
						field:"last_name",
						title:"lastName",
						width:100,
						sortable:true
					},{
						field:"email",
						title:"Email",
						width:100
					},{
						field:"last_update",
						title:"lastUpdate",
						width:100
					},{
						field:"importStatus",
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
						width:100,
						formatter:function(value,record,index){
							if(value == 1){
								return "已处理";
							}else if(value == 0){
								return "未处理";
							}
						}
					}
				]],
				pagination:true,
				pageSize:10,
				pageList:[5,10,15,20,50],
				toolbar:[
					{
						text:"导入模版",
						iconClos:"icon-add",
						handler:function(){
							$("#templateDialog").dialog("open");
						}
					}
				]
			});
			
			$("#okBtn").click(function(){
				//获取选择模版ID
				var str = $("#templates").combobox("getValue");
				$("#templateDialog").dialog("close");
				$("#importDialog").dialog("open");
				var val = "download.action?template_id="+str;
				$("$downloadTemplate").attr("href",val);
			});
		});
	</script>
</head>
<body>
	<div id="lay" class="easyui-layout" style="width:100%;height:100%;">
		<div region="center">
			<table id="t_importdata">
			
			</table>
		</div>
	</div>
	<div id="templateDialog" title="选择模版" modal="true" draggable="false"
		class="easyui-combobox" closed="true" style="width:350px;height:220px;">
		<form action="">
			<table>
				<tr>
					<td>选择模版</td>
					<td>
						<input id="templates" name="templates" class="easyui-combobox"
							url="<%=request.getContextPath() %>/templates.action" valueFisld="templateId" textField="templateName" value=""/>
						<a id="okBtn" class="easyui-linkbutton">确定</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="importDialog" title="导入Excel" modal="true" draggable="false"
		class="easyui-dialog" style="width:350px;height:220px">
		<form action="">
			<table>
				<tr>
					<td>下载模版：</td>
					<td>
						<a id="dowmloadTemplate.action">导入模版</a>
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