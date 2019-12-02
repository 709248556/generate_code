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
<form id="FormSumbit" action="${ctx}/garbage/editSub" method="post" class="form-horizontal">
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="id"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="id" id="id" placeholder="请输入" value="${garbage.id}"/>
        </div>
    </div>
        <label class="col-sm-2 control-label" for="parentId"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="parentId" id="parentId" placeholder="请输入" value="${garbage.parentId}"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="name"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="name" id="name" placeholder="请输入" value="${garbage.name}"/>
        </div>
    </div>
        <label class="col-sm-2 control-label" for="price"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="price" id="price" placeholder="请输入" value="${garbage.price}"/>
        </div>
    </div>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="lastTime"><span class="required">*</span></label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="lastTime" id="lastTime" placeholder="请输入" value="${garbage.lastTime}"/>
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


