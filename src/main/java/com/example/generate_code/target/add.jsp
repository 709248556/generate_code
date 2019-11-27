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
</head>
<body>
<form id="FormSumbit" action="${ctx}/customer/address/addSub" method="post" class="form-horizontal">
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="custAddrId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="custAddrId" id="custAddrId" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="customerId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="customerId" id="customerId" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="contactsName"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="contactsName" id="contactsName" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="contactsPhone"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="contactsPhone" id="contactsPhone" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="contactsGender"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="contactsGender" id="contactsGender" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="provinceCode"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="provinceCode" id="provinceCode" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="provinceName"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="provinceName" id="provinceName" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="cityCode"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="cityCode" id="cityCode" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="cityName"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="cityName" id="cityName" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="districtCode"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="districtCode" id="districtCode" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="districtName"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="districtName" id="districtName" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="streetId"><span class="required">*</span>街道编号</label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="streetId" id="streetId" placeholder="请输入街道编号"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="streetName"><span class="required">*</span>街道名称</label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="streetName" id="streetName" placeholder="请输入街道名称"/>
        </div>
        <label class="col-sm-2 control-label" for="communityId"><span class="required">*</span>所属社区</label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="communityId" id="communityId" placeholder="请输入所属社区"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="address"><span class="required">*</span>详细地址</label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="address" id="address" placeholder="请输入详细地址"/>
        </div>
        <label class="col-sm-2 control-label" for="isDefault"><span class="required">*</span>默认地址</label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="isDefault" id="isDefault" placeholder="请输入默认地址"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="createTime"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="createTime" id="createTime" placeholder="请输入"/>
        </div>
        <label class="col-sm-2 control-label" for="lastTime"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="lastTime" id="lastTime" placeholder="请输入"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="extField1"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="extField1" id="extField1" placeholder="请输入"/>
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
<!-- END CORE PLUGINS -->
<!-- BEGIN CORE VALIDATE -->
<script src="${ctx}/static/lib/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/lib/jquery-validation/1.10.0/additional-methods.js" type="text/javascript"></script>
<script src="${ctx}/static/lib/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</body>
</html>


