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
        						<c:if test="${processPage=='0'}">
        						<s:message code='SynPolicyDto.queryTitle'/>
        						</c:if>
        						<c:if test="${processPage=='1'}">
        						<s:message code='SynPolicyDto.process.queryTitle'/>
        						</c:if>
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<form class="form-horizontal" method="post" role="form" id="queryConditionForm" action="">
        					<table class="table-query">
							    <tr>
							   	    <td class="title"><label><s:message code="SynPolicyDto.orderCode" /> :</label></td>
        							<td>
        								<input type="text" id="searchOrderCode" name="searchOrderCode"
        									onkeyup="this.value=this.value.replace(/\D/g,'')" 
        								    onafterpaste="this.value=this.value.replace(/\D/g,'')"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
        							<td class="title"><label><s:message code="SynPolicySurrenderDto.policyNo" /> :</label></td>
        							<td>
        								<input type="text" id="searchPolicyNo" name="searchPolicyNo"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
        							<c:if test="${processPage=='0'}">
							      	<td class="title"><label><s:message code="SynPolicyDto.dealStatus" /> :</label></td>
        							<td>
        								<select id="searchDealStatus" name="searchDealStatus" class="form-control">
        									<option value="">---请选择---</option>
                                    		<option value="0">未处理</option>
                                    		<option value="1">处理中</option>
                                    		<option value="2">处理成功</option>
                                    		<option value="3">处理失败</option>
                                		</select>
        							</td>
        							</c:if>
							    </tr>
							    <tr>
							    	<td colspan="6">
        								<div class="table-query-action">
        									<c:if test="${processPage=='0'}">
        										<button type="button" id="btnQuery" class="btn btn-primary"><i class="fa fa-search"></i><s:message code="common.button.query" /></button>
        										<button type="button" id="btnManual" class="btn btn-primary"><i class="fa fa-user"></i>手工同步</button>
        									</c:if>
        									<c:if test="${processPage=='1'}">
        										<button type="button" id="btnProcessQuery" class="btn btn-primary"><i class="fa fa-search"></i><s:message code="common.button.query" /></button>
        										<button type="button" id="btnProcessManual" class="btn btn-primary"><i class="fa fa-user"></i>手工同步</button>
        									</c:if>
        										<button type="reset" class="btn btn-primary"><i class="fa fa-retweet"></i><s:message code="common.button.reset" /></button>
        								</div>
        							</td>
							    </tr>
        					</table>
        					
        				</form>
        			</div>
        		</div>
        		<table id="synPolicyTable"></table>
 				<div id="synPolicyGridPager"></div>
        	</div>
        	
        	<div class="col-md-12">
        		<div class="widget">
        			<div class="widget-header">
        				<div class="form-group">
        					<div class="pull-left">
        						<s:message code='SynPolicyDtlDto.queryTitle'/>
        						<div id="orderCodeInfo" class="pull-right"></div>
        						<input type="hidden" id="orderCodeSelect" name="orderCodeSelect"/>
        					</div>
        				</div>
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
 				<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o"><s:message code="SynPolicyDto.manage" /></i></h4>
 		    </div>
 		   <div class="modal-body">
 		   <form id="synPolicyForm">
 		   		<input type="hidden" id="actionType" name="actionType"/>
 				<table class="table-query">
				    <tr>
				    	<td class="title"><label class="required"><s:message code="SynPolicyDto.orderCode" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="orderCode" name="orderCode"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="SynPolicyDto.detailCount" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="detailCount" name="detailCount"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="SynPolicyDto.dealStatus" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="dealStatus" name="dealStatus"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="SynPolicyDto.invalidFlag" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="invalidFlag" name="invalidFlag"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="SynPolicyDto.createdUser" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="createdUser" name="createdUser"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="SynPolicyDto.createdDate" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="createdDate" name="createdDate"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="SynPolicyDto.updatedUser" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="updatedUser" name="updatedUser"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				        <td class="title"><label class="required"><s:message code="SynPolicyDto.updatedDate" /> :</label></td>
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
    var processPage = ${processPage};
    var orderCodeDesc='<s:message code="SynPolicyDto.orderCode" />';
    var detailCountDesc='<s:message code="SynPolicyDto.detailCount" />';
    var dealCountDesc='<s:message code="SynPolicyDto.dealCount" />';
    var dealStatusDesc='<s:message code="SynPolicyDto.dealStatus" />';
    var invalidFlagDesc='<s:message code="SynPolicyDto.invalidFlag" />';
    var createdUserDesc='<s:message code="SynPolicyDto.createdUser" />';
    var createdDateDesc='<s:message code="SynPolicyDto.createdDate" />';
    var updatedUserDesc='<s:message code="SynPolicyDto.updatedUser" />';
    var updatedDateDesc='<s:message code="SynPolicyDto.updatedDate" />';
    
    var orderMainIdDesc='<s:message code="SynPolicyDtlDto.orderMainId" />';
    var orderCodeDesc='<s:message code="SynPolicyDtlDto.orderCode" />';
    var policyNoDesc='<s:message code="SynPolicyDtlDto.policyNo" />';
    var agrtCodeDesc='<s:message code="SynPolicyDtlDto.agrtCode" />';
    var dealStatusDesc='<s:message code="SynPolicyDtlDto.dealStatus" />';
    var invalidFlagDesc='<s:message code="SynPolicyDtlDto.invalidFlag" />';
    var createdUserDesc='<s:message code="SynPolicyDtlDto.createdUser" />';
    var createdDateDesc='<s:message code="SynPolicyDtlDto.createdDate" />';
    var updatedUserDesc='<s:message code="SynPolicyDtlDto.updatedUser" />';
    var updatedDateDesc='<s:message code="SynPolicyDtlDto.updatedDate" />';
    </script>
    <script language="Javascript" src="${ctx}js/syn/synPolicy/synPolicy.js" ></script>
</body>
</html>