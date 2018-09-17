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
        						<s:message code='SynPolicyCfgDto.queryTitle'/>
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<form class="form-horizontal" method="post" role="form" id="queryConditionForm" action="">
        					<table class="table-query">
							    <tr>
							   	    <td class="title"><label><s:message code="SynPolicyCfgDto.dealType" /> :</label></td>
        							<td>
        								<select id="searchDealType" name="searchDealType" class="form-control">
			        		 				<option value=""><s:message code='commom.select.placeholder'/></option>
											<c:forEach var="synPolicyCfgDto" items="${synPolicyCfgList}">
			                                <option value="${synPolicyCfgDto.dealType}">${synPolicyCfgDto.description}</option>
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
        		<table id="synPolicyCfgTable"></table>
 				<div id="synPolicyCfgGridPager"></div>
        	</div>
        </div>
    </div>

	<!-- 管理窗口 -->
    <div id="manageModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 	<div class="modal-dialog">
 		<div class="modal-content">
 			<div class="modal-header">
 		   	<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick = "closeModal();">&times;</button>
 				<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o"><s:message code="SynPolicyCfgDto.manage" /></i></h4>
 		    </div>
 		   <div class="modal-body">
 		   <form id="synPolicyCfgForm">
 		   		<input type="hidden" id="actionType" name="actionType"/>
 		   		
 		   		<input type="hidden" id="invalidFlag" name="invalidFlag"/>
 		   		<input type="hidden" id="createdUser" name="createdUser"/>
 		   		<input type="hidden" id="createdDate" name="createdDate"/>
 		   		<input type="hidden" id="updatedUser" name="updatedUser"/>
 		   		<input type="hidden" id="updatedDate" name="updatedDate"/>
 		   		
 				<table class="table-query">
				    <tr>
				    	<td class="title8"><label class="required"><s:message code="SynPolicyCfgDto.dealType" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="dealType" name="dealType"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
        		 	</tr>
				    <tr>
				       	<td class="title8"><label class="required"><s:message code="SynPolicyCfgDto.description" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="description" name="description"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title8"><label class="required"><s:message code="SynPolicyCfgDto.failRetryCount" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="failRetryCount" name="failRetryCount"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
        		 	</tr>
				    <tr>
				       	<td class="title8"><label class="required"><s:message code="SynPolicyCfgDto.dealBeforeDate" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="dealBeforeDate" name="dealBeforeDate"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title8"><label class="required"><s:message code="SynPolicyCfgDto.limitCount" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="limitCount" name="limitCount"
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
    var dealTypeDesc='<s:message code="SynPolicyCfgDto.dealType" />';
    var descriptionDesc='<s:message code="SynPolicyCfgDto.description" />';
    var failRetryCountDesc='<s:message code="SynPolicyCfgDto.failRetryCount" />';
    var dealBeforeDateDesc='<s:message code="SynPolicyCfgDto.dealBeforeDate" />';
    var limitCountDesc='<s:message code="SynPolicyCfgDto.limitCount" />';
    var invalidFlagDesc='<s:message code="SynPolicyCfgDto.invalidFlag" />';
    var createdUserDesc='<s:message code="SynPolicyCfgDto.createdUser" />';
    var createdDateDesc='<s:message code="SynPolicyCfgDto.createdDate" />';
    var updatedUserDesc='<s:message code="SynPolicyCfgDto.updatedUser" />';
    var updatedDateDesc='<s:message code="SynPolicyCfgDto.updatedDate" />';
    </script>
    <script language="Javascript" src="${ctx}js/syn/synPolicyCfg/synPolicyCfg.js" ></script>
</body>
</html>