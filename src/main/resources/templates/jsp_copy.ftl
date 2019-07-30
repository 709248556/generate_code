<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<c:set var="ctx" value="<#noparse>${pageContext.request.contextPath}</#noparse>" />
<!DOCTYPE html>
	<head>
	<!-- css -->
	<link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/css/reset.css">
	<link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/lib/jquery.mCustomScrollbar/jquery.mCustomScrollbar.css">
	<link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/css/index.css">
	<link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/css/main.css">
	<link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/lib/select2/select2.min.css">
	<link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/img/splashy/splashy.css">
	<link href="<#noparse>${ctx}</#noparse>/static/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
      //将当前操制器名赋到js变量
      var newaction = "${tableNameFormatOnCase}";
    </script>
	</head>
	<body>
		<div class="main_con">
		<div class="operation_box">
			<div class="operation_con">
				<div class="currenttit">
					<!-- 面包屑、根据当前菜单获取生成不可删除 -->
					<i></i><span></span>
				</div>
				<div class="operation_info"><#noparse>${menuRight}</#noparse></div>
			</div>
		</div>
		<div class="search_box">
			<form method="get" id="SearchF" action="<#noparse>${ctx}</#noparse>/${tableNameFormatOnCase}">//1
				<div class="search_nav">
					<ul>
						//2
						<li>
							<input class="inputtext" id="settleDate" name="settleDate" placeholder="结算日期" value="<#noparse>${query.settleDate }</#noparse>" />
						</li>
						<#list searchList as search >
						<li>
							<th width="100" class="change">${baseResultMapVo.columnComment}</th>
                            <input class="inputtext" id="settleDate" name="settleDate" placeholder="结算日期" value="<#noparse>${query.settleDate }</#noparse>" />
                        </li>
						</#list>
					</ul>
				</div>
				<div class="search_btncon">
					<button class="btn add_btn search-btn" type="button">
						<i class="minicon search_icon"></i><span>查询</span>
					</button>
					<button type="button" class="btn export_btn  reset_button">
						<i class="minicon reload_icon"></i><span>重置</span>
					</button>
				</div>
			</form>
		</div>
		<div class="tablelist_box tablelistboxH">
			<div class="tablelist_con" id="Multiple" data-mcs-theme="dark">
				<div class="tablelist_theadbox">
					<div class="tablelist_thead">
						<table>
							<tbody>
								<tr>//3
                                    <#list baseResultMapVoList as baseResultMapVo >
                                    <th width="100" class="change">${baseResultMapVo.columnComment}</th>
                                    </#list>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="tablelist_tbody" data-mcs-theme="dark">
					<table>
						<tbody>
							<c:forEach items="<#noparse>${source.results}</#noparse>" var="entity">
							<tr>//4
                                <#list baseResultMapVoList as baseResultMapVo >
                                <td><#noparse>${entity.</#noparse>${baseResultMapVo.property}}</td>
                                </#list>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="page_box">
			<tags:pagination page="<#noparse>${source}</#noparse>" paginationSize="5" />
		</div>
		
	</div>
		<!-- js -->
	<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/js/jquery-1.12.1.min.js"></script>
	<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/lib/jquery.mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/js/jquery.mousewheel.min.js"></script>
	<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/lib/laydate/laydate.js"></script>
	<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/js/common.js"></script>
	<script src="<#noparse>${ctx}</#noparse>/static/js/commonflag.js" type="text/javascript"></script>
    <script src="<#noparse>${ctx}</#noparse>/static/lib/select2/select2.min.js"></script>
	<script type="text/javascript">

	</script>
	</body>
</html>
