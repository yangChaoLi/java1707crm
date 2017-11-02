<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery-easyui/jquery.edatagrid.js"></script>
<script type="text/javascript">
	$(function(){
		//查询指定id的销售机会
		$.post("${ctx}/customer/findById.action", 
				{id : '${param.customerId}'}, 
				function(result) {
					if(result.status==Util.SUCCESS) {
						$("#num").val(result.data.num);
						$("#name").val(result.data.name);
					}
					
				}, 
				"json");
		
		/*展示数据的datagrid表格*/
		$("#datagrid").edatagrid({
			url:'${ctx}/customerContact/findAll.action?customerId=${param.customerId}',//只查询已分配咨询师的
			saveUrl:'${ctx}/customerContact/add.action?customerId=${param.customerId}',
			updateUrl:'${ctx}/customerContact/update.action?customerId=${param.customerId}',
			destroyUrl:'${ctx}/customerContact/deleteById.action',
			method:'get',
			fit:true,
			singleSelect:false,
			toolbar:'#toolbar',
			rownumbers:true,
			fitColumns:true,
			pagination:true,
			columns:[[    
			      {field:'id',title:'编号',width:50,align:'center'},    
			     {field:'time',title:'交往时间',width:80,align:'center',editor:{type:'datebox',options:{required:true}}},    
			     {field:'address',title:'交往地址',width:80,align:'center',editor:{type:'validatebox',options:{required:true}}},    
			     {field:'overview',title:'职要',width:80,align:'center',editor:{type:'validatebox',options:{required:true}}}
			     ]]  
		});
	});
		
		function updateSaleChanceDevResult(devResult){
			 $.post("${ctx}/saleChance/updateDevResult.action",
					 {customerId:'${param.customerId}',devResult:devResult},
					 function(result){
						 if(result.status == Util.SUCCESS){
							 $.messager.alert("系统提示",result.msg);
						 }else{
							 $.messager.alert("系统提示",result.msg);
						 }
			 		},
			 		"json");
		 }
</script>
</head>
<body>
	<!-- 营销机会信息面板  开始 -->
	<div id="p" class="easyui-panel" title="客户基本信息" style="width: 700px;height: 400px;padding: 10px">
	 	<table cellspacing="8px">
	   		<tr>
	   			<td>客户编号：</td>
	   			<td><input type="text" id="num" name="num" readonly="readonly"/></td>
	   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	   			<td>客户名称：</td>
	   			<td><input type="text" id="name" name="name" readonly="readonly"/></td>
	   		</tr>
	   	</table>
	 </div>
	 <!-- 营销机会信息面板  结束  -->
	 
	<!-- 客户开发计划项table -->
	<table id="datagrid"></table>
	
	<!-- toolbar 开始 -->
	 <div id="toolbar">
	 	<c:if test="${param.show!='true' }">
		 	<div>
		 	<a href="javascript:$('#datagrid').edatagrid('addRow')" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		 	<a href="javascript:$('#datagrid').edatagrid('destroyRow')" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		 	<a href="javascript:$('#datagrid').edatagrid('cancelRow')" class="easyui-linkbutton" iconCls="icon-undo" plain="true">撤销行</a>
		 	<a href="javascript:$('#datagrid').edatagrid('saveRow');$('#datagrid').edatagrid('reload')" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
		 	</div>
	 	</c:if>
	 </div>
	<!-- toolbar 结束 -->
	


</body>
</html>