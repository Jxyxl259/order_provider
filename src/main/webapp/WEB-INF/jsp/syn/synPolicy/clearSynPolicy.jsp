<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<%@ include file="/WEB-INF/jsp/head.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row">
        	<div class="col-md-12">
        		<div class="widget">
        			<div class="widget-header">
        				<div class="form-group">
        					<div class="pull-left">
        						清除同步任务数据
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<form class="form-horizontal" method="post" role="form" id="queryConditionForm" action="">
        					<table class="table-query">
							    <tr>
							    	<td colspan="6">
        								<button type="button" id="btnManual" class="btn btn-primary"><i class="fa fa-user"></i>手工清除承保同步任务数据</button>
        								<button type="button" id="btnSurrenderManual" class="btn btn-primary"><i class="fa fa-user"></i>手工清除退保同步任务数据</button>
        							</td>
							    </tr>
        					</table>
        				</form>
        			</div>
        		</div>
        	</div>
        </div>
    </div>

    <%@include file="/WEB-INF/jsp/common/alertmodal.jsp" %>
    <%@include file="/WEB-INF/jsp/common/message.jsp" %>
    
    <script type="text/javascript">
    $(document).ready(function() {
    	$("#btnManual").on("click", function () {
    		clearSynPolicyDataManual();
        });
    	
    	$("#btnSurrenderManual").on("click", function () {
    		clearSynPolicySurrenderDataManual();
        });
    });
    
    function clearSynPolicyDataManual() {
    	alertMsg("手工清除承保同步任务数据吗？","confirm","manualClearSynPolicyDataSure()");
    }
    
    function manualClearSynPolicyDataSure(){
	    RestfulClient.post(contextPath + "synPolicy/clearSynPolicyPrpallData", {

	    }, function(data) {
	    	alertMsg(data, "success", "");
	    });
	}
    
    function clearSynPolicySurrenderDataManual() {
    	alertMsg("手工清除退保同步任务数据吗？","confirm","manualClearSynPolicySurrenderDataSure()");
    }
    
    function manualClearSynPolicySurrenderDataSure(){
	    RestfulClient.post(contextPath + "synPolicy/clearSynPolicySurrenderData", {

	    }, function(data) {
	    	alertMsg(data, "success", "");
	    });
	}
    
    </script>
</body>
</html>