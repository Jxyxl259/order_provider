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
        						<s:message code='SynPolicyFilterCfgDto.queryTitle'/>------[此配置应用会跳过含有该协议订单的保单同步处理,请谨慎操作]
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<form class="form-horizontal" method="post" role="form" id="queryConditionForm" action="">
        					<table class="table-query">
							    <tr>
							      	<td class="title"><label><s:message code="SynPolicyFilterCfgDto.agrtCode" /> :</label></td>
        							<td>
        								<input type="text" id="searchAgrtCode" name="searchAgrtCode"
        									class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        							</td>
							        <td class="title"><label><s:message code="SynPolicyFilterCfgDto.invalidFlag" /> :</label></td>
        							<td>
        								<select id="searchInvalidFlag" name="searchInvalidFlag" class="form-control">
        									<option value=""><s:message code='commom.select.placeholder'/></option>
        									<option value="0">正常</option>
                                			<option value="1">作废 </option>		
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
        		<table id="synPolicyFilterCfgTable"></table>
 				<div id="synPolicyFilterCfgGridPager"></div>
        	</div>
        </div>
    </div>

	<!-- 管理窗口 -->
    <div id="manageModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 	<div class="modal-dialog">
 		<div class="modal-content">
 			<div class="modal-header">
 		   	<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick = "closeModal();">&times;</button>
 				<h4 class="modal-title" id="myModalLabel"><i class="fa fa-pencil-square-o"><s:message code="SynPolicyFilterCfgDto.manage" /></i></h4>
 		    </div>
 		   <div class="modal-body">
 		   <form id="synPolicyFilterCfgForm">
 		   		<input type="hidden" id="actionType" name="actionType"/>
 		   		
 		   		<input type="hidden" id="filterCfgId" name="filterCfgId"/>
 		   		
 		   		<input type="hidden" id="createdUser" name="createdUser"/>
 		   		<input type="hidden" id="createdDate" name="createdDate"/>
 		   		<input type="hidden" id="updatedUser" name="updatedUser"/>
 		   		<input type="hidden" id="updatedDate" name="updatedDate"/>
 		   		
 				<table class="table-query">
				    <tr>
				       	<td class="title8"><label class="required"><s:message code="SynPolicyFilterCfgDto.agrtCode" /> :</label></td>
        		 		<td>
        		 			<input type="text" id="agrtCode" name="agrtCode"
        		 				class="form-control" placeholder=" <s:message code='commom.input.placeholder' />" />
        		 		</td>
				    </tr>
				    <tr>
				       	<td class="title8"><label class="required"><s:message code="SynPolicyFilterCfgDto.invalidFlag" /> :</label></td>
        		 		<td>
        		 			<select id="invalidFlag" name="invalidFlag" class="form-control">
        						<option value="0">正常</option>
                                <option value="1">作废 </option>		
                            </select>
        		 		</td>
				    </tr>
				    <tr>
				        <td class="title8"><label class="unrequired"><s:message code="SynPolicyFilterCfgDto.remark" /> :</label></td>
        		 		<td>
        		 			<textarea id="remark"  name="remark" class="form-control" rows="2" cols="25" 
        		 				placeholder=" <s:message code='commom.input.placeholder' />"></textarea>
        		 		</td>
        		 	</tr>
        		 </table>
 			</form>
        	</div>
        	<div class="modal-footer">
        		[此有效配置应用会跳过含有该协议订单的保单同步处理,请谨慎操作]
 				<button type="button" id="btnSave" class="btn btn-primary"><s:message code="common.button.save"/></button>
 				<button type="button" class="btn btn-default" data-dismiss="modal" onclick = "closeModal();"><s:message code="common.button.close"/></button>
 			</div>
         </div>
      </div>
    </div>
    <%@include file="/WEB-INF/jsp/common/alertmodal.jsp" %>
    <%@include file="/WEB-INF/jsp/common/message.jsp" %>
    
    <script type="text/javascript">
    var filterCfgIdDesc='<s:message code="SynPolicyFilterCfgDto.filterCfgId" />';
    var agrtCodeDesc='<s:message code="SynPolicyFilterCfgDto.agrtCode" />';
    var remarkDesc='<s:message code="SynPolicyFilterCfgDto.remark" />';
    var invalidFlagDesc='<s:message code="SynPolicyFilterCfgDto.invalidFlag" />';
    var createdUserDesc='<s:message code="SynPolicyFilterCfgDto.createdUser" />';
    var createdDateDesc='<s:message code="SynPolicyFilterCfgDto.createdDate" />';
    var updatedUserDesc='<s:message code="SynPolicyFilterCfgDto.updatedUser" />';
    var updatedDateDesc='<s:message code="SynPolicyFilterCfgDto.updatedDate" />';
    </script>
    <script language="Javascript" src="${ctx}js/syn/synPolicyFilterCfg/synPolicyFilterCfg.js" ></script>
</body>
</html>