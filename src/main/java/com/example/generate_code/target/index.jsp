<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
	<head>
	<!-- css -->
	<link rel="stylesheet" href="${ctx}/static/css/reset.css">
	<link rel="stylesheet" href="${ctx}/static/lib/jquery.mCustomScrollbar/jquery.mCustomScrollbar.css">
	<link rel="stylesheet" href="${ctx}/static/css/index.css">
	<link rel="stylesheet" href="${ctx}/static/css/main.css">
	<link rel="stylesheet" href="${ctx}/static/lib/select2/select2.min.css">
	<link rel="stylesheet" href="${ctx}/static/img/splashy/splashy.css">
	<link href="${ctx}/static/lib/layui/css/layui.css" rel="stylesheet" />
	<link href="${ctx}/static/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
      //将当前操制器名赋到js变量
      var newaction = "liquidationHisIndex";
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
				<div class="operation_info">${menuRight}</div>
			</div>
		</div>
		<div class="search_box">
			<form method="get" id="SearchF" action="${ctx}/liquidation/his">
				<div class="search_nav">
					<ul>//2
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
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
                                    <th width="100" class="change"></th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="tablelist_tbody" data-mcs-theme="dark">
					<table>
						<tbody>
							<c:forEach items="${source.results}" var="entity">
							<tr>//4
                                <td class="notitle">
                                    <input name="Item_Check" type="checkbox" value="${entity.liquidationId}" />
                                </td>
                                <td>
									<span>
										<a href='javascript:void(0)' class="detail-btn" onClick="detail('${entity.liquidationId}')">详情</a>
									</span>
                                </td>
								<td>${entity.liquidationId}</td>
								<td>${entity.orderId}</td>
								<td>${entity.accountId}</td>
								<td>${entity.accountCode}</td>
								<td>${entity.accountName}</td>
								<td>${entity.termCode}</td>
								<td>${entity.accountType}</td>
								<td>${entity.organLevel}</td>
								<td>${entity.organId}</td>
								<td>${entity.productId}</td>
								<td>${entity.transType}</td>
								<td>${entity.transKind}</td>
								<td>${entity.clearType}</td>
								<td>${entity.feeType}</td>
								<td>${entity.cashType}</td>
								<td>${entity.cashAccountId}</td>
								<td>${entity.cardNo}</td>
								<td>${entity.clearState}</td>
								<td>${entity.clearDate}</td>
								<td>${entity.settlePeriod}</td>
                                <td><fmt:formatDate value="${entity.createTime}" pattern="yyyy-MM-dd" /></td>
                                <td><fmt:formatDate value="${entity.orderTime}" pattern="yyyy-MM-dd" /></td>
                                <td><fmt:formatDate value="${entity.clearTime}" pattern="yyyy-MM-dd" /></td>
								<td>${entity.amount}</td>
								<td>${entity.orgAmount}</td>
								<td>${entity.accountRate}</td>
								<td>${entity.accountFee}</td>
								<td>${entity.organ2Id}</td>
								<td>${entity.organ2Rate}</td>
								<td>${entity.organ2Fee}</td>
								<td>${entity.organ1Id}</td>
								<td>${entity.organ1Rate}</td>
								<td>${entity.organ1Fee}</td>
								<td>${entity.gorganId}</td>
								<td>${entity.gorganFee}</td>
								<td>${entity.channelId}</td>
								<td>${entity.channelRate}</td>
								<td>${entity.channelCost}</td>
								<td>${entity.settleFlag}</td>
								<td>${entity.settleBatchno}</td>
								<td>${entity.affiliateTransFlag}</td>
								<td>${entity.extField1}</td>
								<td>${entity.extField2}</td>
								<td>${entity.extField3}</td>
								<td>${entity.extField4}</td>
								<td>${entity.splitColumn}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="page_box">
			<tags:pagination page="${source}" paginationSize="5" />
		</div>
		
	</div>
		<!-- js -->
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.12.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/lib/jquery.mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/jquery.mousewheel.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/lib/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/common.js"></script>
	<script type="text/javascript" src="${ctx}/static/lib/layui/layui.js"></script>
	<script src="${ctx}/static/js/commonflag.js" type="text/javascript"></script>
    <script src="${ctx}/static/lib/select2/select2.min.js"></script>
	<script src="${ctx}/static/js/jquery.blockui.min.js"></script>
	<script src="${ctx}/static/js/blockui.js"></script>
	<script type="text/javascript">
        $(function(){
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
        function deleteLiquidationHis() {
            var id = ItemCheck_ID();
            if(id){
                parent.layer.confirm('您确定要删除选择的数据吗?该数据删除后不可恢复！请谨慎操作!', {
                    icon: 3,
                    btn: ['确定','取消'] //按钮
                }, function(){
                    AjaxConfirm("post","${ctx}/liquidation/his/deleteLiquidationHis?id=" + id);
                });
            }
        }

        //冻结
        function freezeLiquidationHis() {
            var id = ItemCheck_ID();
            if(id){
                parent.layer.confirm('您确定要冻结选择的数据吗?请谨慎操作!', {
                    icon: 3,
                    btn: ['确定','取消'] //按钮
                }, function(){
                    AjaxConfirm("post","${ctx}/liquidation/his/freezeLiquidationHis?id=" + id);
                });
            }
        }

        //解冻
        function thawLiquidationHis() {
            var id = ItemCheck_ID();
            if(id){
                parent.layer.confirm('您确定要解冻选择的数据吗?请谨慎操作!', {
                    icon: 3,
                    btn: ['确定','取消'] //按钮
                }, function(){
                    AjaxConfirm("post","${ctx}/liquidation/his/thawLiquidationHis?id=" + id);
                });
            }
        }
        parent.layer.close(parent.all_parent_load);
	</script>
	</body>
</html>
