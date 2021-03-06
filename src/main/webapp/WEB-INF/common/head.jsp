<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript">  
     var ctx="${pageContext.request.contextPath}";  
</script>

<!-- 自定义js -->
<script type="text/javascript" src="${ctx}/resources/js/common.js"></script>

<!-- eCharts -->
<script type="text/javascript" src="${ctx}/resources/thirdlib/echarts.common.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/thirdlib/echarts.min.js"></script>
<%-- <script type="text/javascript" src="${ctx}/resources/js/common.js"></script> --%>
<!--主题样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/thirdlib/jquery-easyui/themes/default/easyui.css">
<!--图标样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/thirdlib/jquery-easyui/themes/icon.css">
<!--jquery核心库-->
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery-easyui/jquery.min.js"></script>
<!-- easyui核心库 -->
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery-easyui/jquery.easyui.min.js"></script>
<!-- 国际化语言 -->
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>