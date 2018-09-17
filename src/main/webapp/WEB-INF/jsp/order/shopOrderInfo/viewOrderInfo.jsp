<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<%@ include file="/WEB-INF/jsp/head.jsp"%>
<link href="${ctx}common/js/plugins/jsonformater/jsonFormater.css"  rel="stylesheet" type="text/css">
<script language="Javascript" src="${ctx}common/js/plugins/jsonformater/jsonFormater.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
        	<div class="col-md-12">
        		<div class="widget">
        			<div class="widget-header">
        				<div class="form-group">
        					<div class="pull-left">
        						<s:message code='ShopOrderInfoDto.manage'/>
        					</div>
        				</div>
        			</div>
					<div class="widget-content">
        				<div id='container'></div>
        			</div>
        		</div>
        	</div>
        </div>
    </div>
    <script>
    var jsonData=${orderDetailInfoJsonData};
    $(document).ready(function() {
    	var options = {
    	        dom : '#container' //对应容器的css选择器
    	    };
    	    var jf = new JsonFormater(options); //创建对象
    	    jf.doFormat(jsonData); //格式化json
    });
    	
    </script>
</body>
</html>