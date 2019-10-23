<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="<#noparse>${pageContext.request.contextPath}</#noparse>"/>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/lib/jquery-validation/1.10.0/validate.css"/>
    <link rel="stylesheet" href="<#noparse>${ctx}</#noparse>/static/css/style.css">
</head>
<body>
<form id="FormSumbit" action="<#noparse>${ctx}</#noparse>${URL}/addSub" method="post" class="form-horizontal">
		<#list baseResultMapVoList as baseResultMapVo >
        <#if baseResultMapVo?is_odd_item>
    <div class="form-group form-group-sm">
		<label class="col-sm-2 control-label" for="${baseResultMapVo.property}"><span class="required">*</span>${baseResultMapVo.columnComment}</label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="${baseResultMapVo.property}" id="${baseResultMapVo.property}" placeholder="请输入${baseResultMapVo.columnComment}" value="<#noparse>${</#noparse>${tableNameFormatOnCase}.${baseResultMapVo.property}}" disabled="disabled"/>
        </div>
        <#else>
        <label class="col-sm-2 control-label" for="${baseResultMapVo.property}"><span class="required">*</span>${baseResultMapVo.columnComment}</label>
        <div class="col-sm-3">
            <input type="text" class="form-control required" name="${baseResultMapVo.property}" id="${baseResultMapVo.property}" placeholder="请输入${baseResultMapVo.columnComment}" value="<#noparse>${</#noparse>${tableNameFormatOnCase}.${baseResultMapVo.property}}" disabled="disabled"/>
        </div>
    </div>
        </#if>
		</#list>
    <div class="form-group form-group-sm last">

    </div>
    <div class="form-actions">
        <button class="btn btn-primary submit" type="submit"><i class="icon-ok"></i> 提 交</button>
        <button type="button" class="btn cancel">取 消</button>
    </div>
</form>
<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<#noparse>${ctx}</#noparse>/static/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="<#noparse>${ctx}</#noparse>/static/js/jquery.form.js" type="text/javascript"></script>
<script src="<#noparse>${ctx}</#noparse>/static/js/commonflag.js" type="text/javascript"></script>
<script src="<#noparse>${ctx}</#noparse>/static/js/from-common.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN CORE VALIDATE -->
<script src="<#noparse>${ctx}</#noparse>/static/lib/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="<#noparse>${ctx}</#noparse>/static/lib/jquery-validation/1.10.0/additional-methods.js" type="text/javascript"></script>
<script src="<#noparse>${ctx}</#noparse>/static/lib/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</body>
</html>


