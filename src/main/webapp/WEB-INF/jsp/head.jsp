<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>

<link href="${ctx}common/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
<link href="${ctx}common/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
<link href="${ctx}common/css/common.css"  rel="stylesheet" type="text/css">
<link href="${ctx}common/js/plugins/ztree/metro.css"  rel="stylesheet" type="text/css">

<script language="Javascript" src="${ctx}common/js/jquery/jquery-1.11.1.min.js"></script>
<script language="Javascript" src="${ctx}common/js/bootstrap/bootstrap.min.js"></script>

<script language="Javascript" src="${ctx}common/js/json2.js"></script>
<script language="Javascript" src="${ctx}common/js/yafa-restful-client.js"></script>

<script language="Javascript" src="${ctx}common/js/plugins/jqgrid/jquery.jqGrid.min.js"></script>
<script language="Javascript" src="${ctx}common/js/plugins/jqgrid/i18n/grid.locale-cn.js"></script>

<script language="Javascript"  src="${ctx}common/js/plugins/jquery-validation/jquery.validate.js" ></script>
<script language="Javascript"  src="${ctx}common/js/plugins/jquery-validation/validation_zh.js" ></script>

<script language="Javascript" src="${ctx}common/js/plugins/jquery-autocomplete/jq-ac.js"></script>
<script language="Javascript" src="${ctx}common/js/plugins/jquery-autocomplete/jq-ac-custom.js"></script>

<script language="Javascript" src="${ctx}common/js/jquery-ui/jquery-ui-1.10.4.custom.min.js"></script>

<script language="Javascript" src="${ctx}common/js/plugins/laydate/laydate.dev.js"></script>
<script language="Javascript" src="${ctx}common/js/plugins/ztree/jquery.ztree.all-3.5.min.js"></script>
<script language="Javascript" src="${ctx}common/js/plugins/layer/layer.js"></script>

<script language="Javascript" src="${ctx}common/js/commonUtil.js" charset="UTF-8"></script>
<script type="text/javascript">

	var contextPath = '${ctx}';
	
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
	
	function alertMsg(msg,type,fn){
	 $("#alertMsg").html(msg);
	 switch(type.toLowerCase()){
	 	case "confirm":		//confirm
	 		$("#alertInfo").html(confirmMsgDesc);
		 	if($("#alertOk").hasClass("hide")){
		 		$("#alertOk").removeClass("hide");
		 		$("#alertOk").attr("class","btn btn-primary");
		 	}
		 	if($("#alertOk").has("onclick")){
		 		$("#alertOk").removeAttr("onclick");
		 		$("#alertOk").attr("onclick","javascript:" + fn + ";");
		 	}else{
		 		$("#alertOk").attr("onclick","javascript:" + fn + ";");
		 	}
	 		break;
	 	case "error":		//error
	 		$("#alertInfo").html(errorMsgDesc);
	 		$("#alertOk").attr("class","hide");	 		
	 		$("#alertOk").removeAttr("onclick");	 		
	 		break;
	 	case "warn":		//warn
	 		$("#alertInfo").html(warnMsgDesc);
	 		$("#alertOk").attr("class","hide");
	 		$("#alertOk").removeAttr("onclick");	
	 		break;
	 	case "success":		//success
	 		$("#alertInfo").html(successMsgDesc);
	 		$("#alertOk").attr("class","hide");
	 		$("#alertOk").removeAttr("onclick");	
	 		break;
	 	case "info":		//info
	 		$("#alertInfo").html(infoMsgDesc);
	 		$("#alertOk").attr("class","hide");
	 		$("#alertOk").removeAttr("onclick");	
	 		break;
	 	default:;
	 }
	 $("#alertModal").modal("show");
	}
</script>