<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="${ctx}/static/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/static/lib/jquery-validation/1.10.0/validate.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/style.css">
    <link rel="stylesheet" href="${ctx}/static/lib/select2/select2.min.css">
</head>
<body>
<form id="FormSumbit" action="${ctx}/liquidation/his/addSub" method="post" class="form-horizontal">
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="liquidationId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="liquidationId" id="liquidationId" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="orderId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="orderId" id="orderId" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="accountId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="accountId" id="accountId" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="accountCode"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="accountCode" id="accountCode" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="accountName"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="accountName" id="accountName" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="termCode"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="termCode" id="termCode" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="accountType"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="accountType" id="accountType" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="organLevel"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organLevel" id="organLevel" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="organId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organId" id="organId" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="productId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="productId" id="productId" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="transType"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="transType" id="transType" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="transKind"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="transKind" id="transKind" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="clearType"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="clearType" id="clearType" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="feeType"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="feeType" id="feeType" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="cashType"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="cashType" id="cashType" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="cashAccountId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="cashAccountId" id="cashAccountId" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="cardNo"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="cardNo" id="cardNo" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="clearState"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="clearState" id="clearState" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="clearDate"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="clearDate" id="clearDate" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="settlePeriod"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="settlePeriod" id="settlePeriod" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="createTime"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="createTime" id="createTime" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="orderTime"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="orderTime" id="orderTime" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="clearTime"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="clearTime" id="clearTime" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="amount"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="amount" id="amount" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="orgAmount"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="orgAmount" id="orgAmount" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="accountRate"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="accountRate" id="accountRate" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="accountFee"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="accountFee" id="accountFee" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="organ2Id"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organ2Id" id="organ2Id" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="organ2Rate"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organ2Rate" id="organ2Rate" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="organ2Fee"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organ2Fee" id="organ2Fee" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="organ1Id"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organ1Id" id="organ1Id" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="organ1Rate"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organ1Rate" id="organ1Rate" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="organ1Fee"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="organ1Fee" id="organ1Fee" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="gorganId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="gorganId" id="gorganId" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="gorganFee"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="gorganFee" id="gorganFee" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="channelId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="channelId" id="channelId" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="channelRate"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="channelRate" id="channelRate" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="channelCost"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="channelCost" id="channelCost" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="settleFlag"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="settleFlag" id="settleFlag" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="settleBatchno"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="settleBatchno" id="settleBatchno" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="affiliateTransFlag"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="affiliateTransFlag" id="affiliateTransFlag" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="extField1"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="extField1" id="extField1" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="extField2"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="extField2" id="extField2" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="extField3"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="extField3" id="extField3" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="extField4"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="extField4" id="extField4" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="splitColumn"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="splitColumn" id="splitColumn" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm last">

    </div>
    <div class="form-actions">
        <button class="btn btn-primary submit" type="submit"><i class="icon-ok"></i> 提 交</button>
        <button type="button" class="btn cancel">取 消</button>
    </div>
</form>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.form.js" type="text/javascript"></script>
<script src="${ctx}/static/js/commonflag.js" type="text/javascript"></script>
<script src="${ctx}/static/js/from-common.js" type="text/javascript"></script>
<script src="${ctx}/static/lib/select2/select2.min.js"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN CORE VALIDATE -->
<script src="${ctx}/static/lib/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/lib/jquery-validation/1.10.0/additional-methods.js" type="text/javascript"></script>
<script src="${ctx}/static/lib/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</body>
</html>


