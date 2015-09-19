<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		$("#t_customer").datagrid({
			idField:"id",
			title:"Om_cust_price_list信息列表",
			fit:true,
			height:450,
			url:"<%=request.getContextPath() %>/Om_cust_price_list.action?page=1&rows=10",
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
					field:"PL_YH_ITEM",
					title:"PL_YH_ITEM",
					width:100,
					hidden:true
				},{
					field:"effective_date_from",
					title:"effective_date_from",
					width:100,
					sortable:true
				},{
					field:"effective_date_to",
					title:"effective_date_to",
					width:100,
					sortable:true
				},{
					field:"user_def1",
					title:"user_def1",
					width:100,
					sortable:true
				},{
					field:"user_def2",
					title:"user_def2",
					width:100,
					sortable:true
				},{
					field:"user_def3",
					title:"user_def3",
					width:100,
					sortable:true
				},{
					field:"user_def4",
					title:"user_def4",
					width:100,
					sortable:true
				},{
					field:"user_def5",
					title:"user_def5",
					hidden:true
				},{
					field:"user_def6",
					title:"user_def6",
					hidden:true
				},{
					field:"user_def7",
					title:"user_def7",
					width:100,
					hidden:true
				},{
					field:"user_def8",
					title:"user_def8",
					width:100,
					hidden:true
				},{
					field:"user_def9",
					title:"user_def9",
					width:100,
					hidden:true
				},{
					field:"user_def10",
					title:"user_def10",
					width:100,
					hidden:true
				},{
					field:"user_def11",
					title:"user_def11",
					hidden:true
				},{
					field:"user_def12",
					title:"user_def12",
					hidden:true
				},{
					field:"user_def13",
					title:"user_def13",
					width:100,
					hidden:true
				},{
					field:"user_def14",
					title:"user_def14",
					width:100,
					hidden:true
				},{
					field:"user_def15",
					title:"user_def15",
					width:100,
					hidden:true
				},{
					field:"user_def16",
					title:"user_def16",
					width:100,
					hidden:true
				},{
					field:"user_def17",
					title:"user_def17",
					hidden:true
				},{
					field:"user_def18",
					title:"user_def18",
					hidden:true
				},{
					field:"user_def19",
					title:"user_def19",
					width:100,
					hidden:true
				},{
					field:"user_def20",
					title:"user_def20",
					width:100,
					hidden:true
				},{
					field:"user_def21",
					title:"user_def21",
					width:100,
					hidden:true
				},{
					field:"user_def22",
					title:"user_def22",
					width:100,
					hidden:true
				},{
					field:"user_def23",
					title:"user_def23",
					hidden:true
				},{
					field:"user_def24",
					title:"user_def24",
					hidden:true
				},{
					field:"user_def25",
					title:"user_def25",
					width:100,
					hidden:true
				},{
					field:"user_def26",
					title:"user_def26",
					width:100,
					hidden:true
				},{
					field:"user_def27",
					title:"user_def27",
					width:100,
					hidden:true
				},{
					field:"user_def28",
					title:"user_def28",
					width:100,
					hidden:true
				},{
					field:"user_def29",
					title:"user_def29",
					hidden:true
				},{
					field:"user_def30",
					title:"user_def30",
					hidden:true
				}
			]],
			pagination:true,
			pageSize:10,
			pageList:[5,10,15,20,50],
			toolbar:[
				{
					text:"导出Excel",
					iconCls:"icon-save",
					handler:function(){
						//获取后台传递className,methodName
						debugger
						var className = $("#t_customer").datagrid("getData").className;
						var methodName = $("#t_customer").datagrid("getData").methodName;
						debugger
						//获取表头信息
						var header = $("#t_customer").datagrid("options").columns[0];
						var fields = "";
						var titles = "";
						for(var i=0; i<header.length; i++){
							var field = header[i].field;
							var title = header[i].title;
							var hiddenFlag = header[i].hidden;
							if(!hiddenFlag){
								var dh = i == (header.length - 1)?"":",";
								fields += field + dh;
								titles += title + dh;
							}
						}
						//向后台发送请求
						var form = $("<form>");//定义一个form表单
						form.attr("style","display:none");
						form.attr("target","");
						form.attr("method","post");
						form.attr("action","<%=request.getContextPath() %>/customer_export.action");
						//添加input
						var input1 = $("<input>");
						input1.attr("type","hidden");
						input1.attr("name","fields");
						input1.attr("value",fields);
						var input1 = $("<input>");
						input1.attr("type","hidden");
						input1.attr("name","fields");
						input1.attr("value",fields);
						var input2 = $("<input>");
						input2.attr("type","hidden");
						input2.attr("name","titles");
						input2.attr("value",titles);
						var input3 = $("<input>");
						input3.attr("type","hidden");
						input3.attr("name","className");
						input3.attr("value",className);
						var input4 = $("<input>");
						input4.attr("type","hidden");
						input4.attr("name","methodName");
						input4.attr("value",methodName);
						//将表单放到body中
						$("body").append(form);
						form.append(input1);
						form.append(input2);
						form.append(input3);
						form.append(input4);
						form.submit();
					}
				}
			]
		});
	});
	</script>
</head>
<body>
	<div id="lay" class="easyui-layout" style="width:100%;height:700px;">
		<div region="center">
			<table id="t_customer"></table>
		</div>
	</div>
</body>
</html>