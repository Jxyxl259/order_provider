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
        						<s:message code='SynPolicyDtlDto.queryTitle'/>
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<form class="form-horizontal" method="post" role="form" id="queryConditionForm" action="">
        					<table class="table-query">
							    <tr>
							   	    <td class="title"><label><s:message code="SynPolicyDtlDto.orderMainId" /> :</label></td>
        							<td>
        								<input type="text" id="searchOrderMainId" name="searchOrderMainId"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							      	<td class="title"><label><s:message code="SynPolicyDtlDto.orderCode" /> :</label></td>
        							<td>
        								<input type="text" id="searchOrderCode" name="searchOrderCode"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							      	<td class="title"><label><s:message code="SynPolicyDtlDto.dealStatus" /> :</label></td>
        							<td>
        								<input type="text" id="searchDealStatus" name="searchDealStatus"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							    </tr>
							    <tr>
							        <td class="title"><label><s:message code="SynPolicyDtlDto.invalidFlag" /> :</label></td>
        							<td>
        								<input type="text" id="searchInvalidFlag" name="searchInvalidFlag"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							      	<td class="title"><label><s:message code="SynPolicyDtlDto.createdUser" /> :</label></td>
        							<td>
        								<input type="text" id="searchCreatedUser" name="searchCreatedUser"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							      	<td class="title"><label><s:message code="SynPolicyDtlDto.createdDate" /> :</label></td>
        							<td>
        								<input type="text" id="searchCreatedDate" name="searchCreatedDate"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							    </tr>
							    <tr>
							        <td class="title"><label><s:message code="SynPolicyDtlDto.updatedUser" /> :</label></td>
        							<td>
        								<input type="text" id="searchUpdatedUser" name="searchUpdatedUser"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							        <td class="title"><label><s:message code="SynPolicyDtlDto.updatedDate" /> :</label></td>
        							<td>
        								<input type="text" id="searchUpdatedDate" name="searchUpdatedDate"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
						        </tr> 
        					</table>
        					<div class="table-query-action">
        						<button type="button" id="btnQuery" class="btn btn-primary"><i class="fa fa-search"></i><s:message code="common.button.query" /></button>
        						<button type="reset" class="btn btn-primary"><i class="fa fa-retweet"></i><s:message code="common.button.reset" /></button>
        					</div>
        				</form>
        			</div>
        		</div>
        		<table id="synPolicyDtlTable"></table>
 				<div id="synPolicyDtlGridPager"></div>
        	</div>
        </div>
    </div>

	<!-- 管理窗口 -->
    <div id="manageModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 	<div class="modal-dialog">
 		<div class="modal-content">
 			<div class="modal-header">
 		   	<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick = "closeModal();">&times;</button>
 				<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o"><s:message code="SynPolicyDtlDto.manage" /></i></h4>
 		    </div>
 		   <div class="modal-body">
 		   <form id="synPolicyDtlForm">
 		   		<input type="hidden" id="actionType" name="actionType"/>
 				<table class="table-query">
				    <tr>
				    	<td class="title"><label class="required"><s:message code="SynPolicyDtlDto.orderMainId" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="orderMainId" name="orderMainId"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="SynPolicyDtlDto.orderCode" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="orderCode" name="orderCode"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="SynPolicyDtlDto.dealStatus" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="dealStatus" name="dealStatus"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="SynPolicyDtlDto.invalidFlag" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="invalidFlag" name="invalidFlag"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="SynPolicyDtlDto.createdUser" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="createdUser" name="createdUser"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="SynPolicyDtlDto.createdDate" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="createdDate" name="createdDate"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="SynPolicyDtlDto.updatedUser" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="updatedUser" name="updatedUser"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				        <td class="title"><label class="required"><s:message code="SynPolicyDtlDto.updatedDate" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="updatedDate" name="updatedDate"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
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
    var orderMainIdDesc='<s:message code="SynPolicyDtlDto.orderMainId" />';
    var orderCodeDesc='<s:message code="SynPolicyDtlDto.orderCode" />';
    var dealStatusDesc='<s:message code="SynPolicyDtlDto.dealStatus" />';
    var invalidFlagDesc='<s:message code="SynPolicyDtlDto.invalidFlag" />';
    var createdUserDesc='<s:message code="SynPolicyDtlDto.createdUser" />';
    var createdDateDesc='<s:message code="SynPolicyDtlDto.createdDate" />';
    var updatedUserDesc='<s:message code="SynPolicyDtlDto.updatedUser" />';
    var updatedDateDesc='<s:message code="SynPolicyDtlDto.updatedDate" />';
    </script>
    <script language="Javascript" src="${ctx}js/syn/synPolicyDtl/synPolicyDtl.js" ></script>
</body>
</html>