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
	<link href="<#noparse>${ctx}</#noparse>/static/lib/layui/css/layui.css" rel="stylesheet" />
	<link href="<#noparse>${ctx}</#noparse>/static/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
      //将当前操制器名赋到js变量
      var newaction = "${tableNameFormatOnCase}Index";
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
			<form method="get" id="SearchF" action="<#noparse>${ctx}</#noparse>${URL}">
				<div class="search_nav">
					<ul>//2
						<#list searchVos as searchVo >
						<#if searchVo.type == "input">
						<input class="inputtext" id="${searchVo.name}" name="${searchVo.name}" placeholder="${searchVo.placeholder}" value="<#noparse>${query.</#noparse>${searchVo.name}}"/>
						<#else>
						<select class="select" style="min-width: 100px" name="${searchVo.name}" id="${searchVo.name}">
                            <option value="">${searchVo.placeholder}</option>
                            <c:forEach items="<#noparse>${</#noparse>${searchVo.items}}" var="item">
                                <option value="<#noparse>${item.</#noparse>${searchVo.value}}" <c:if
                                    test="<#noparse>${query.</#noparse>${searchVo.name} == item.${searchVo.value}"> selected</c:if> ><#noparse>${item.</#noparse>${searchVo.desc}}</option>
                            </c:forEach>
                        </select>
						</#if>
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
                                    <th width="50">操作</th>
                                    <th width="50">功能</th>
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
                                <td class="notitle">
                                    <input name="Item_Check" type="checkbox" value="<#noparse>${entity.</#noparse>${fristColumnName}}" />
                                </td>
                                <td>
									<span>
										<a href='javascript:void(0)' class="detail-btn" onClick="detail('<#noparse>${entity.</#noparse>${fristColumnName}}')">详情</a>
									</span>
                                </td>
                                <#list baseResultMapVoList as baseResultMapVo >
								<#if baseResultMapVo.jdbcType == "DATE">
                                <td><fmt:formatDate value="<#noparse>${entity.</#noparse>${baseResultMapVo.property}}" pattern="yyyy-MM-dd" /></td>
								<#else>
								<td><#noparse>${entity.</#noparse>${baseResultMapVo.property}}</td>
								</#if>
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
	<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/lib/layui/layui.js"></script>
	<script src="<#noparse>${ctx}</#noparse>/static/js/commonflag.js" type="text/javascript"></script>
    <script src="<#noparse>${ctx}</#noparse>/static/lib/select2/select2.min.js"></script>
	<script src="<#noparse>${ctx}</#noparse>/static/js/jquery.blockui.min.js"></script>
	<script src="<#noparse>${ctx}</#noparse>/static/js/blockui.js"></script>
	<script type="text/javascript">
        $(function(){
		<#list searchVos as searchVo >
			<#if searchVo.type == "select">
			$("#${searchVo.name}").select2({
				allowClear : true,
				placeholder: '${searchVo.placeholder}'
			});
			</#if>
		</#list>
        });
        function detail(id) {
            if(id){
                layerOpen("详情","/detailView?id=" + id);
            }
        }
        function add() {
            layerOpen("新增","/addView");
        }
        function edit() {
            var id = ItemCheck_ID();
            if(id){
                layerOpen("编辑","/editView?id="+id);
			}
        }
        function delete${tableNameFormat}() {
            var id = ItemCheck_ID();
            if(id){
                parent.layer.confirm('您确定要删除选择的数据吗?该数据删除后不可恢复！请谨慎操作!', {
                    icon: 3,
                    btn: ['确定','取消'] //按钮
                }, function(){
                    AjaxConfirm("post","<#noparse>${ctx}</#noparse>${URL}/delete${tableNameFormat}?id=" + id);
                });
            }
        }

        //冻结
        function freeze${tableNameFormat}() {
            var id = ItemCheck_ID();
            if(id){
                parent.layer.confirm('您确定要冻结选择的数据吗?请谨慎操作!', {
                    icon: 3,
                    btn: ['确定','取消'] //按钮
                }, function(){
                    AjaxConfirm("post","<#noparse>${ctx}</#noparse>${URL}/freeze${tableNameFormat}?id=" + id);
                });
            }
        }

        //解冻
        function thaw${tableNameFormat}() {
            var id = ItemCheck_ID();
            if(id){
                parent.layer.confirm('您确定要解冻选择的数据吗?请谨慎操作!', {
                    icon: 3,
                    btn: ['确定','取消'] //按钮
                }, function(){
                    AjaxConfirm("post","<#noparse>${ctx}</#noparse>${URL}/thaw${tableNameFormat}?id=" + id);
                });
            }
        }
        parent.layer.close(parent.all_parent_load);
	</script>
	</body>
</html>
