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
        						<s:message code='SynPolicyMonitorCfgDto.queryTitle'/>
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<form class="form-horizontal" method="post" role="form" id="queryConditionForm" action="">
        					<table class="table-query">
							    <tr>
							   	    <td class="title"><label><s:message code="SynPolicyMonitorCfgDto.monitorType" /> :</label></td>
        							<td>
        								<select id="searchMonitorType" name="searchMonitorType" class="form-control">
			        		 				<option value=""><s:message code='commom.select.placeholder'/></option>
											<c:forEach var="synPolicyMonitorCfgDto" items="${synPolicyMonitorCfgList}">
			                                <option value="${synPolicyMonitorCfgDto.monitorType}">${synPolicyMonitorCfgDto.description}</option>
			                                </c:forEach>
			                        	</select>
        							</td>
        							<td>
        								<button type="button" id="btnQuery" class="btn btn-primary"><i class="fa fa-search"></i><s:message code="common.button.query" /></button>
        								<button type="reset" class="btn btn-primary"><i class="fa fa-retweet"></i><s:message code="common.button.reset" /></button>
        							</td>
							    </tr>
        					</table>
        				</form>
        			</div>
        		</div>
        		<table id="synPolicyMonitorCfgTable"></table>
 				<div id="synPolicyMonitorCfgGridPager"></div>
        	</div>
        </div>
    </div>

	<!-- 管理窗口 -->
    <div id="manageModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 	<div class="modal-dialog">
 		<div class="modal-content">
 			<div class="modal-header">
 		   	<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick = "closeModal();">&times;</button>
 				<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o"><s:message code="SynPolicyMonitorCfgDto.manage" /></i></h4>
 		    </div>
 		   <div class="modal-body">
 		   <form id="synPolicyMonitorCfgForm">
 		   		<input type="hidden" id="actionType" name="actionType"/>
 		   		
 		   		<input type="hidden" id="email" name="email"/>
 		   		<input type="hidden" id="emailSwitch" name="emailSwitch"/>
 		   		
 		   		<input type="hidden" id="invalidFlag" name="invalidFlag"/>
 		   		<input type="hidden" id="createdUser" name="createdUser"/>
 		   		<input type="hidden" id="createdDate" name="createdDate"/>
 		   		<input type="hidden" id="updatedUser" name="updatedUser"/>
 		   		<input type="hidden" id="updatedDate" name="updatedDate"/>
 		   		
 				<table class="table-query">
				    <tr>
				    	<td class="title8"><label class="required"><s:message code="SynPolicyMonitorCfgDto.monitorType" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="monitorType" name="monitorType"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
        		 	</tr>
				    <tr>
				       	<td class="title8"><label class="required"><s:message code="SynPolicyMonitorCfgDto.description" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="description" name="description"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title8"><label class="required"><s:message code="SynPolicyMonitorCfgDto.threshold" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="threshold" name="threshold"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
        		 	</tr>
				    <tr>
				       	<td class="title8"><label class="required"><s:message code="SynPolicyMonitorCfgDto.warnMsg" /> :</label></td>
        		 		<td>
        		 			<textarea id="warnMsg"  name="warnMsg" class="form-control" rows="2" cols="25" 
        		 				placeholder=" <s:message code='commom.input.placeholder' />"></textarea>
        		 		</td>
				    </tr>
				    <tr>
				       	<td class="title8"><label class="required"><s:message code="SynPolicyMonitorCfgDto.smsSwitch" /> :</label></td>
        		 		<td>
        		 			<select id="smsSwitch" name="smsSwitch" class="form-control">
			        		 	<option value="0">开启</option>
			        		 	<option value="1">关闭</option>
			                </select>
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title8"><label class="required"><s:message code="SynPolicyMonitorCfgDto.mobile" /> :</label></td>
        		 		<td>
        		 			<textarea id="mobile"  name="mobile" class="form-control" rows="2" cols="25" 
        		 				placeholder=" <s:message code='commom.input.placeholder' />"></textarea>
        		 		</td>
        		 	</tr>
        		 </table>
 			</form>
        	</div>
        	<div class="modal-footer">
 				<button type="button" id="btnSave" class="btn btn-primary"><s:message code="common.button.save"/></button>
 				<button type="button" class="btn btn-default" data-dismiss="modal" onclick = "closeModal();"><s:message code="common.button.close"/></button>
 			</div>
         </div>
      </div>
    </div>
    <%@include file="/WEB-INF/jsp/common/alertmodal.jsp" %>
    <%@include file="/WEB-INF/jsp/common/message.jsp" %>
    
    <script type="text/javascript">
    var monitorTypeDesc='<s:message code="SynPolicyMonitorCfgDto.monitorType" />';
    var descriptionDesc='<s:message code="SynPolicyMonitorCfgDto.description" />';
    var thresholdDesc='<s:message code="SynPolicyMonitorCfgDto.threshold" />';
    var warnMsgDesc='<s:message code="SynPolicyMonitorCfgDto.warnMsg" />';
    var mobileDesc='<s:message code="SynPolicyMonitorCfgDto.mobile" />';
    var smsSwitchDesc='<s:message code="SynPolicyMonitorCfgDto.smsSwitch" />';
    var emailDesc='<s:message code="SynPolicyMonitorCfgDto.email" />';
    var emailSwitchDesc='<s:message code="SynPolicyMonitorCfgDto.emailSwitch" />';
    var invalidFlagDesc='<s:message code="SynPolicyMonitorCfgDto.invalidFlag" />';
    var createdUserDesc='<s:message code="SynPolicyMonitorCfgDto.createdUser" />';
    var createdDateDesc='<s:message code="SynPolicyMonitorCfgDto.createdDate" />';
    var updatedUserDesc='<s:message code="SynPolicyMonitorCfgDto.updatedUser" />';
    var updatedDateDesc='<s:message code="SynPolicyMonitorCfgDto.updatedDate" />';
    </script>
    <script language="Javascript" src="${ctx}js/syn/synPolicyMonitorCfg/synPolicyMonitorCfg.js" ></script>
</body>
</html>