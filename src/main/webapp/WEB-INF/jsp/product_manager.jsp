<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="../common/head.jsp" %>
</head>
 <script type="text/javascript">
	 function remove() {
		var ids = Util.getSelectionsIds("#datagrid");
		if (ids.length == 0) {
			$.messager.layer("系统提示","请选择要删除的信息");
			return;
		}
		
		$.messager.layer("系统提示","确定要删除吗",function (r) {
			if (r) {
				$.post(
					"${ctx}/product/delete.action",
					{ids:ids},
					function (result) {
						if (result.status == Util.SUCCESS) {
							$.messager.layer(result.msg);
							$("#datagrid").datagrid('reload');
						} else {
							$.messager.layer(result.msg);
						}
					},
					"json"
				);
			}
		})
	} 
	 function doSearch (value) {
			$("#datagrid").datagrid("load",{
				"name":value
			})
		}
	 var url;
	 function openAddDialog() {
		 $("#dialog").dialog("open").dialog("setTitle","添加");
		 $("#form").form("clear");
		 url="$(ctx)/product/add.action"
	 }
	 function openUpdateDialog() {
		 var selected = $("#datagrid").datagrid("getSelections");
		 if (selected.length == 0) {
			 $.messager.layer("系统提示","请选择要修改的信息");
			 return;
		 }
		 $("#dialog").dialog("open").dialog("setTitle","修改");
		 $("#form").form("load",selected[0]);
		 url = '${ctx}/product/update.action';
	 }
	 
	 function doSave() {
		 $("#form").form("submit",{
			 url:url,
			 onSubmit: function () {
				 return $(this).form("validate");                                                                                                                                                                                                                                                                                                           
			 },
			   
			 success:function (result) {
				 var result = eval('('+ result +')');
				 if (result.status == Util.SUCCESS) {
					 $.messager.layer(result.msg);
					 $("#dialog").dialog("close");
					 $("#datagrid").datagrid("reload");
				 } else {
					 $.messager.layer(result.msg);
				 }
			 }
		 })
	 }
		 function clear() {
			 $("#form").form("clear");
		 }
</script> 
<body>
	<!-- 数据表格 -->
		<table id="datagrid" class="easyui-datagrid" rownumbers="true" fitColumns="true"
		pagination="true"
		checkOnSelect="true"
		data-options="fit:true,singleSelect:false,url:'${ctx}/product/pageList.action',method:'get',toolbar:'#toolbar'">
		<thead>
			<thead>
				<tr>
					<th data-options="field:'cb',align:'center',checkbox:true" ></th>
					<th data-options="field:'id',align:'center',width:100" >编号</th>
					<th data-options="field:'name',align:'center',width:100" >产品名称</th>
					<th data-options="field:'model',align:'center',width:100" >型号</th>
					<th data-options="field:'unit',align:'center',width:100" >单位</th>
					<th data-options="field:'price',align:'center',width:100" >价格</th>
					<th data-options="field:'store',align:'center',width:100" >库存</th>
					<th data-options="field:'remarks  ',align:'center',width:100" >备注</th>
				</tr>
			</thead>
		</table>
		<!-- 表格按钮 -->
		<div id="toolbar">
			 <a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >添加</a>
			<a href="javascript:openUpdateDialog()" class="easyui-linkbutton" iconCls="icon-edit" >修改</a>
			<a href="javascript:remove()" class="easyui-linkbutton" iconCls="icon-remove" >删除</a>
			<input class="easyui-searchbox" data-options="prompt:'产品名',searcher:doSearch" style="width:300px"></input> 
		 </div>
		 
		 <!-- 对话窗口 -->
		 <div class="easyui-dialog" buttons="#dialog-button" closed="true" closable="true" style="width:400px">
		 	<form action="" id="form" method="post">
		 		<table>
		 			<tr>
					<td>
		      			  产品名称: 
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
					        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" /><font color="red">*</font>   
					</td>
					 <td>型号:</td> 
					 <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>  
		        	<td><input class="easyui-validatebox" type="text" name="model" data-options="required:true" /><font color="red">*</font></td>   
				</tr>
		 			<tr>
					<td>
		      			  单位: 
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
					        <input class="easyui-validatebox" type="text" name="unit" data-options="required:true" /><font color="red">*</font>   
					</td>
					 <td>价格:</td> 
					 <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>  
		        	<td><input class="easyui-validatebox" type="text" name="price" data-options="required:true" /><font color="red">*</font></td>   
				</tr>
		 			<tr>
					<td>
		      			  库存: 
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
					        <input class="easyui-validatebox" type="text" name="store" data-options="required:true" /><font color="red">*</font>   
					</td>
					 <td>备注:</td> 
					 <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>  
		        	<td><input class="easyui-validatebox" type="text" name="remarks" data-options="required:true" /><font color="red">*</font></td>   
				</tr>
		 		</table>
		 	</form>
		 </div>
		 
		 <div id="dialog-button">
		 	<a class="easyui-linkbutton" data-options="iconCls:'icon-ok',text:'提交'" href="javascript:doSave()"></a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',text:'清空'" href="javascript:clear()"></a>
		 </div>
</body>
</html>