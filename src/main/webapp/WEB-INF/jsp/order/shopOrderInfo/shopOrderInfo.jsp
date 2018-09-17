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
        						<s:message code='ShopOrderInfoDto.queryTitle'/>
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<form class="form-horizontal" method="post" role="form" id="queryConditionForm" action="">
        					<table class="table-query">
							    <tr>
							   	    <td class="title"><label><s:message code="ShopOrderInfoDto.orderCode" /> :</label></td>
        							<td>
        								<input type="text" id="searchOrderCode" name="searchOrderCode"
        									onkeyup="this.value=this.value.replace(/\D/g,'')" 
        								    onafterpaste="this.value=this.value.replace(/\D/g,'')"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							      	<td class="title"><label><s:message code="ShopOrderInfoDto.userId" /> :</label></td>
        							<td>
        								<input type="text" id="searchUserId" name="searchUserId"
        									onkeyup="this.value=this.value.replace(/\D/g,'')" 
        								    onafterpaste="this.value=this.value.replace(/\D/g,'')"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							      	<td class="title"><label><s:message code="ShopOrderInfoDto.orderStatus" /> :</label></td>
        							<td>
        								<select id="searchOrderStatus" name="searchOrderStatus" class="form-control">
        									<option value="">---请选择---</option>
                                    		<option value="0">未确认</option>
                                    		<option value="1">已确认</option>
                                    		<option value="2">已完成</option>
                                    		<option value="3">失败</option>
                                    		<option value="4">取消</option>
                                		</select>
        							</td>
							    </tr>
							    <tr>
							    	<td class="title"><label><s:message code="ShopOrderInfoDto.policyNo.associatedNo" /> :</label></td>
        							<td>
        								<input type="text" id="searchPolicyNo" name="searchPolicyNo"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
        							<td class="title"><label><s:message code="ShopOrderInfoDto.synPolicyStatus" /> :</label></td>
        							<td>
        								<select id="searchSynPolicyStatus" name="searchSynPolicyStatus" class="form-control">
        									<option value="">---请选择---</option>
                                    		<option value="1">未同步</option>
                                    		<option value="0">已同步</option>
                                    	</select>
        							</td>
        							<td colspan="2">
        								<div class="table-query-action">
        									<button type="button" id="btnQuery" class="btn btn-primary"><i class="fa fa-search"></i><s:message code="common.button.query" /></button>
        									<button type="reset" class="btn btn-primary"><i class="fa fa-retweet"></i><s:message code="common.button.reset" /></button>
        								</div>
        							</td>
							    </tr>
        					</table>
        				</form>
        			</div>
        		</div>
        		<table id="shopOrderInfoTable"></table>
 				<div id="shopOrderInfoGridPager"></div>
        	</div>
        	
        	<div class="col-md-12">
        		<div class="widget">
        			<div class="widget-header">
        				<div class="form-group">
        					<div class="pull-left">
        						<s:message code='OrderMainDto.queryTitle'/>
        						<div id="orderCodeInfo" class="pull-right"></div>
        						<input type="hidden" id="orderCodeSelect" name="orderCodeSelect"/>
        					</div>
        				</div>
        			</div>
        		</div>
        		<table id="orderMainTable"></table>
 				<div id="orderMainGridPager"></div>
        	</div>
        </div>
    </div>

	<!-- 管理窗口 -->
    <div id="manageModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 	<div class="modal-dialog">
 		<div class="modal-content">
 			<div class="modal-header">
 		   	<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick = "closeModal();">&times;</button>
 				<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o"><s:message code="ShopOrderInfoDto.manage" /></i></h4>
 		    </div>
 		   <div class="modal-body">
 		   <form id="shopOrderInfoForm">
 		   		<input type="hidden" id="actionType" name="actionType"/>
 				<table class="table-query">
				    <tr>
				    	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.orderCode" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="orderCode" name="orderCode"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.userId" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="userId" name="userId"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.orderStatus" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="orderStatus" name="orderStatus"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.invFlag" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="invFlag" name="invFlag"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.invType" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="invType" name="invType"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.invPayee" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="invPayee" name="invPayee"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.invContent" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="invContent" name="invContent"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.goodsAmount" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="goodsAmount" name="goodsAmount"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.orderAmount" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="orderAmount" name="orderAmount"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.referer" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="referer" name="referer"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.addTime" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="addTime" name="addTime"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.confirmTime" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="confirmTime" name="confirmTime"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.discount" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="discount" name="discount"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.createdUser" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="createdUser" name="createdUser"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.createdDate" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="createdDate" name="createdDate"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.updatedUser" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="updatedUser" name="updatedUser"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.updatedDate" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="updatedDate" name="updatedDate"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.invalidFlag" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="invalidFlag" name="invalidFlag"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.recommendedCode" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="recommendedCode" name="recommendedCode"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				       	<td class="title"><label class="required"><s:message code="ShopOrderInfoDto.appId" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="appId" name="appId"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title"><label class="required"><s:message code="ShopOrderInfoDto.synPolicyStatus" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="synPolicyStatus" name="synPolicyStatus"
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
    var orderCodeDesc='<s:message code="ShopOrderInfoDto.orderCode" />';
    var userIdDesc='<s:message code="ShopOrderInfoDto.userId" />';
    var orderStatusDesc='<s:message code="ShopOrderInfoDto.orderStatus" />';
    var invFlagDesc='<s:message code="ShopOrderInfoDto.invFlag" />';
    var invTypeDesc='<s:message code="ShopOrderInfoDto.invType" />';
    var invPayeeDesc='<s:message code="ShopOrderInfoDto.invPayee" />';
    var invContentDesc='<s:message code="ShopOrderInfoDto.invContent" />';
    var goodsAmountDesc='<s:message code="ShopOrderInfoDto.goodsAmount" />';
    var orderAmountDesc='<s:message code="ShopOrderInfoDto.orderAmount" />';
    var refererDesc='<s:message code="ShopOrderInfoDto.referer" />';
    var addTimeDesc='<s:message code="ShopOrderInfoDto.addTime" />';
    var confirmTimeDesc='<s:message code="ShopOrderInfoDto.confirmTime" />';
    var discountDesc='<s:message code="ShopOrderInfoDto.discount" />';
    var createdUserDesc='<s:message code="ShopOrderInfoDto.createdUser" />';
    var createdDateDesc='<s:message code="ShopOrderInfoDto.createdDate" />';
    var updatedUserDesc='<s:message code="ShopOrderInfoDto.updatedUser" />';
    var updatedDateDesc='<s:message code="ShopOrderInfoDto.updatedDate" />';
    var invalidFlagDesc='<s:message code="ShopOrderInfoDto.invalidFlag" />';
    var recommendedCodeDesc='<s:message code="ShopOrderInfoDto.recommendedCode" />';
    var appIdDesc='<s:message code="ShopOrderInfoDto.appId" />';
    var synPolicyStatusDesc='<s:message code="ShopOrderInfoDto.synPolicyStatus" />';
    </script>
    <script type="text/javascript">
    var orderMainIdDesc='<s:message code="OrderMainDto.orderMainId" />';
    var orderCodeDesc='<s:message code="OrderMainDto.orderCode" />';
    var orderDateDesc='<s:message code="OrderMainDto.orderDate" />';
    var businessSourceIdDesc='<s:message code="OrderMainDto.businessSourceId" />';
    var proposalNoDesc='<s:message code="OrderMainDto.proposalNo" />';
    var orderCityDesc='<s:message code="OrderMainDto.orderCity" />';
    var policyNoDesc='<s:message code="OrderMainDto.policyNo" />';
    var startDateDesc='<s:message code="OrderMainDto.startDate" />';
    var endDateDesc='<s:message code="OrderMainDto.endDate" />';
    var statusDesc='<s:message code="OrderMainDto.status" />';
    var createdUserDesc='<s:message code="OrderMainDto.createdUser" />';
    var createdDateDesc='<s:message code="OrderMainDto.createdDate" />';
    var updatedUserDesc='<s:message code="OrderMainDto.updatedUser" />';
    var updatedDateDesc='<s:message code="OrderMainDto.updatedDate" />';
    var invalidFlagDesc='<s:message code="OrderMainDto.invalidFlag" />';
    var argueSolutionDesc='<s:message code="OrderMainDto.argueSolution" />';
    var poaSerialNoDesc='<s:message code="OrderMainDto.poaSerialNo" />';
    var agrtCodeDesc='<s:message code="OrderMainDto.agrtCode" />';
    var orgIdDesc='<s:message code="OrderMainDto.orgId" />';
    var agreementNoSubDesc='<s:message code="OrderMainDto.agreementNoSub" />';
    var businessModeDesc='<s:message code="OrderMainDto.businessMode" />';
    var businessSourceDesc='<s:message code="OrderMainDto.businessSource" />';
    var channelDetailCodeDesc='<s:message code="OrderMainDto.channelDetailCode" />';
    var channelTipDesc='<s:message code="OrderMainDto.channelTip" />';
    var companyCodeDesc='<s:message code="OrderMainDto.companyCode" />';
    var salesmanCodeDesc='<s:message code="OrderMainDto.salesmanCode" />';
    var salesmanNameDesc='<s:message code="OrderMainDto.salesmanName" />';
    var teamCodeDesc='<s:message code="OrderMainDto.teamCode" />';
    var teamNameDesc='<s:message code="OrderMainDto.teamName" />';
    var intermediaryCodeDesc='<s:message code="OrderMainDto.intermediaryCode" />';
    var agreementNoDesc='<s:message code="OrderMainDto.agreementNo" />';
    var solutionCodeDesc='<s:message code="OrderMainDto.solutionCode" />';
    var creditPeriodDesc='<s:message code="OrderMainDto.creditPeriod" />';
    var projectCodeDesc='<s:message code="OrderMainDto.projectCode" />';
    var codIndDesc='<s:message code="OrderMainDto.codInd" />';
    var associatedNoDesc='<s:message code="OrderMainDto.associatedNo" />';
    var rationTypeDesc='<s:message code="OrderMainDto.rationType" />';
    var dataSourceDesc='<s:message code="OrderMainDto.dataSource" />';
    var productNameDesc='<s:message code="OrderMainDto.productName" />';
    var othPolicyNoDesc='<s:message code="OrderMainDto.othPolicyNo" />';
    var surrenderValidDateDesc='<s:message code="OrderMainDto.surrenderValidDate" />';
    var endorDateDesc='<s:message code="OrderMainDto.endorDate" />';
    var synPolicyStatusDesc='<s:message code="OrderMainDto.synPolicyStatus" />';
    var synPolicySurrenderStatusDesc='<s:message code="OrderMainDto.synPolicySurrenderStatus" />';
    var issueCompanyDesc='<s:message code="OrderMainDto.issueCompany" />';
    </script>
    <script language="Javascript" src="${ctx}js/order/shopOrderInfo/shopOrderInfo.js" ></script>
</body>
</html>