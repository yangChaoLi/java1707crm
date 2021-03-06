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
			url:'${ctx}/customerOrder/findAll.action?customerId=${param.customerId}',//只查询已分配咨询师的
			saveUrl:'${ctx}/customerOrder/add.action?customerId=${param.customerId}',
			updateUrl:'${ctx}/customerOrder/update.action?customerId=${param.customerId}',
			destroyUrl:'${ctx}/customerOrder/deleteById.action',
			method:'get',
			fit:true,
			singleSelect:false,
			rownumbers:true,
			fitColumns:true,
			pagination:true,
			columns:[[    
			      {field:'id',title:'编号',width:50,align:'center'},    
			     {field:'orderNo',title:'订单号',width:50,align:'center'},    
			     {field:'time',title:'订单日期',width:50,align:'center'},    
			     {field:'address',title:'送货地址',width:50,align:'center'},
			     {field:'status',title:'状态',width:50,align:'center',
			    	formatter:function (value,row,index) {
			    		if (value == 0) {
			    			return '未回款';
			    		} else if (value == 1) {
			    			return '已回款';
			    		}
			    	}	 
			     },
			     {field:'a',title:'操作',width:50,align:'center',
			    	formatter:function (value,row,index) {
			    		return "<a href='javascript:orderItems("+ row.id +")'>查看订单明细</a>"
			    	}	 
			     }
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
		$(function () {
			$("dialog").dialog({
				closed:true,
	 			closable:true,
	 			buttons:[
	 			 	{
	 			 		text:'关闭',
	 			 		iconCls:'icon-remove',
	 			 		handler:function () {
	 			 			$("#dialog").dialog("close");
	 			 		}
	 			 	}
	 			 ]
			})
		});
		
		function orderItems(orderId) {
			$.ajax({
				url:"${ctx}/customerOrder/findById.action",
				data:'orderId='+orderId,
				dataType:"json",
				success:function (data) {
					if (data.status == Util.SUCCESS) {
						$("#dialog").dialog("open");
						$("#form").form("load",data.data);
					} else {
						$.messager.alert(data.msg);
					}
				}
			});
		};
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
	<!-- toolbar 结束 -->
	<div id="dialog" modal="true" style="width:650;height:280,padding: 10px 20px">
		<form action="" id="form" method="post">
			<input type="hidden" id="id" name="id"/>
			<table cellspacing="8px">
		   		<tr>
		   			<td>编号：</td>
		   			<td><input type="text" id="id" name="id" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>商品名称</td>
		   			<td><input type="text" id="productName" name="productName" /></td>
		   		</tr>
		   		<tr>
		   			<td>商品数量：</td>
		   			<td><input type="text" id="productNum" name="productNum" /></td>
		   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			<td>单位：</td>
		   			<td><input type="text" id="unit" name="unit" /></td>
		   		</tr>
		   		<tr>
		   			<td>价格：</td>
		   			<td><input type="text" id="price" name="price" class="easyui-numberbox" data-options="min:0,max:100" required="true"/>&nbsp;<font color="red">*</font></td>
		   			<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			
		   		</tr>
		   		<tr>
		   			<td>总金额：</td>
		   			<td colspan="4"><input type="text" id="sum" name="sum" style="width: 420px"/></td>
		   		</tr>
		   	</table>
		</form>
	</div>


</body>
</html>