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
			$("a[title]").click(function(){
				var src = $(this).attr("title");
				var title = $(this).html();
				if($("#tt").tabs("exists",title)){
					$("#tt").tabs("select",title);
				}else{
					$("#tt").tabs("add",{
						title:title,
						content:"<iframe frameborder='0' style='width:100%;height:100%;background-color:#eee;' src='"+src+"'></iframe>",
						closable:true
					});
				}
			});
		});
	</script>
</head>
<body>
	<div id="cc" class="easyui-layout" fit="true" style="width:100%;height:100%;">
		<div region="west" split="true" title="菜单" style="width:200px;">
			<div id="aa" class="easyui-accordion" fit="true">
				<div title="Excel导入导出" selected="true" style="overflow:auto;padding:5px;">
					<a title="<%=request.getContextPath() %>/customer_list.action?page=1&rows=10">数据导入</a><br/>
				</div>
			</div>
		</div>
		<div region="canter" title="主界面" style="padding:5px;">
			<div id="tt" class="easyui-tabs" fit="true" style="width:500px;height:250px;padding-left:200px;">
			
			</div>
		</div>
	</div>
</body>
</html>