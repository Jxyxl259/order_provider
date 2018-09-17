$(document).ready(function() {
    
    validateForm();
    
    initAction(true);
    
    initActionDtl(true);
    
    $("#btnQuery").on("click", function () {
        reloadGridTable();
    });
    
    $("#btnSave").on("click", function () {
        dealShopOrderInfo();
    });
    
    $(function() {
        $(document).scroll(function() {
            $("#shopOrderInfoTable").setGridWidth($(window).width()-10);
        });
        $(window).resize(function() {
            $("#shopOrderInfoTable").setGridWidth($(window).width()-10);
        });
    });
});


function reloadDtlGridTable() {
    $("#orderMainTable").setGridParam({ 
        postData: {
            "orderMainId" : $("#searchOrderMainId").val(),
            "orderCode" : $("#searchOrderCode").val()
        },
        datatype : "json"
    }).trigger("reloadGrid", [{ page: 1}]);
}


var flagDtl = true ;  
function initActionDtl(btnFlag){
    if(flagDtl){
        loadTableDtl();
    }
    flagDtl = false;  
}

function showStatus(cellvalue, options, rowObject){
    if(cellvalue == "0") {
        return "初始状态";
    }else if(cellvalue == "1") {
        return "转投保成功";
    }else if(cellvalue == "2") {
        return "转投保失败";
    }else if(cellvalue == "3") {
        return "转保单成功";
    }else if(cellvalue == "4") {
        return "转保单失败";
    }else if(cellvalue == "5") {
        return "全单批退成功";
    }else if(cellvalue == "6") {
        return "批改成功";
    }else if(cellvalue == "7") {
        return "批改中";
    }else {
        return "批改失败";
    }
}

function loadTableDtl(){
    $("#orderMainTable").jqGrid( {
        url : contextPath + "shopOrderInfo/orderMain/list",
        mtype : 'post',
        datatype : "local",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
        	if($("#orderCodeSelect").val() == null || $("#orderCodeSelect").val() == "") {
                postData.orderCode = "1";
            }else {
                postData.orderCode = $("#orderCodeSelect").val();
            }
            return JSON.stringify(postData);
        },
        colNames : [ orderMainIdDesc, policyNoDesc, startDateDesc, endDateDesc, statusDesc , associatedNoDesc, synPolicyStatusDesc, synPolicySurrenderStatusDesc],
        colModel : [ 
                     {name : 'orderMainId',index : 'orderMainId',width : 130,align : "center"},
                     {name : 'policyNo',index : 'policyNo',width : 150,align : "center"},
                     {name : 'startDate',index : 'startDate',width : 110,align : "center"},
                     {name : 'endDate',index : 'endDate',width : 110,align : "center"},
                     {name : 'status',index : 'status',width : 100,align : "center", formatter: showStatus},
                     {name : 'associatedNo',index : 'associatedNo',width : 100,align : "center"},
                     {name : 'synPolicyStatus',index : 'synPolicyStatus',width : 100,align : "center", formatter: showSynPolicyStatus},
                     {name : 'synPolicySurrenderStatus',index : 'synPolicySurrenderStatus',width : 80,align : "center", formatter: showSynPolicyStatus}
                   ],
        rowNum : 10,
        rowList : [ 10, 20, 30, 50 ],
        sortname : 'orderMainId',
        autowidth : true,
        multiboxonly :true,
        multiselectWidth : 30,
        height : 'auto',
        viewrecords : true,
        sortorder : "desc",
        multiselect : true,
        viewrecords : true,
        recordpos : 'right',
        pager : '#orderMainGridPager'
    });
}

var validator;
function validateForm() {
    validator = $("#shopOrderInfoForm").validate({
        focusInvalid : false,
        onkeyup : false,
        rules : {
            orderCode:{
                required:true,
                byteRangeLength:[0,100]
            },
            userId:{
                required:true,
                byteRangeLength:[0,100]
            },
            orderStatus:{
                required:true,
                byteRangeLength:[0,100]
            },
            synPolicyStatus:{
                required:true,
                byteRangeLength:[0,100]
            }
        }
    });
}

function reloadGridTable() {
    $("#shopOrderInfoTable").setGridParam({ 
        postData: {
            "orderCode" : $("#searchOrderCode").val(),
            "userId" : $("#searchUserId").val(),
            "orderStatus" : $("#searchOrderStatus").val(),
            "policyNo" : $("#searchPolicyNo").val(),
            "synPolicyStatus" : $("#searchSynPolicyStatus").val()
        },
        datatype : "json"
    }).trigger("reloadGrid", [{ page: 1}]);
    
    $("#orderCodeSelect").val("");
    $("#orderCodeInfo").html("");
    $("#orderMainTable").jqGrid().clearGridData();
}

var flag = true ;  
function initAction(btnFlag){
    if(flag){
        loadTable();
    }
    flag = false;  
}

function showDelFlag(cellvalue, options, rowObject){
    return cellvalue == "N" ? normalDesc:deleteDesc;
}

function showOrderStatus(cellvalue, options, rowObject){
    if(cellvalue == "0") {
        return "未确认";
    }else if(cellvalue == "1") {
        return "已确认";
    }else if(cellvalue == "2") {
    	return "已完成";
    }else if(cellvalue == "3") {
    	return "失败";
    }else if(cellvalue == "4") {
    	return "取消";
    }else {
        return "-";
    }
}

function showSynPolicyStatus(cellvalue, options, rowObject){
    if(cellvalue == "0") {
        return "已同步";
    }else {
        return "—";
    }
}

function loadTable(){
    $("#shopOrderInfoTable").jqGrid( {
        url : contextPath + "shopOrderInfo/list",
        mtype : 'post',
        datatype : "local",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
            return JSON.stringify(postData);
        },
        colNames : [ orderCodeDesc, userIdDesc, orderStatusDesc, orderAmountDesc, addTimeDesc, synPolicyStatusDesc, updatedDateDesc, '操作'],
        colModel : [ 
                     {name : 'orderCode',index : 'orderCode',width : 100,align : "center"},
                     {name : 'userId',index : 'userId',width : 100,align : "center"},
                     {name : 'orderStatus',index : 'orderStatus',width : 100,align : "center", formatter: showOrderStatus},
                     {name : 'orderAmount',index : 'orderAmount',width : 100,align : "center"},
                     {name : 'addTime',index : 'addTime',width : 100,align : "center"},
                     {name : 'synPolicyStatus',index : 'synPolicyStatus',width : 100,align : "center",sortable: false, formatter: showSynPolicyStatus},
                     {name : 'updatedDate',index : 'updatedDate', hidden: true},
                     {name : 'viewJson',index : 'viewJson',width : 80,align : "center",sortable: false,formatter:showJsonOrder}
                   ],
        rowNum : 10,
        rowList : [ 10, 20, 30, 50 ],
        sortname : 'updatedDate',
        autowidth : true,
        multiboxonly :true,
        multiselectWidth : 30,
        height : 218, //'auto'
        viewrecords : true,
        sortorder : "desc",
        multiselect : true,
        viewrecords : true,
        recordpos : 'right',
        pager : '#shopOrderInfoGridPager',
        onSelectRow : function(rowid,status){
            var rowData = $("#shopOrderInfoTable").jqGrid("getRowData",rowid);
            $("#orderCodeInfo").html("");
            $("#orderCodeInfo").html("&nbsp;-&nbsp;[订单号:"+ rowData.orderCode+"]");
            $("#orderCodeSelect").val(rowData.orderCode);
            reloadDtlGridTable();
        },
        onPaging : function(pgButton) {
        	$("#orderCodeSelect").val("");
            $("#orderCodeInfo").html("");
            $("#orderMainTable").jqGrid().clearGridData();
        }
    });
}

function showJsonOrder(cellvalue, options, rowObject){
    return '<a onclick="javascript:viewOrderJsonData('+"'"+rowObject.orderCode+"'"+')">查看</a>';
}

var iTop = (window.screen.availHeight-30-630)/2;       
var iLeft = (window.screen.availWidth-10-1000)/2;
function viewOrderJsonData(orderCode) {
    window.open(contextPath + "viewOrderJsonData?orderCode="+orderCode,"订单详情","height=620, width=1000, top="+iTop+", left="+iLeft+", toolbar=no, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no");                          
}

function prepareInsert(){
    
    $("#actionType").val("I");
    
    RestfulClient.post(
        contextPath + "shopOrderInfo/prepareInsert",
        {
            
        },
        function(data) {
            var shopOrderInfoDto = data.shopOrderInfoDto;
            for (attr in shopOrderInfoDto) {
                $("#" + attr).val(shopOrderInfoDto[attr]);
            }
            $("#manageModal").modal("show");
        }
    );
}

function prepareUpdate(){
    
    $("#actionType").val("U");
    
    var selectItems = $("#shopOrderInfoTable").jqGrid("getGridParam","selarrrow");
    
    if(selectItems.length <= 0){
        alertMsg(editMsgDesc,"error","");
        return;
    }else if(selectItems.length > 1){
        alertMsg(editMsgDesc,"error","");
        return;
    }else{
        var rowData = $("#shopOrderInfoTable").jqGrid("getRowData",selectItems[0]);
        
        RestfulClient.post(
            contextPath + "shopOrderInfo/prepareUpdate",
            {
                'orderCode':rowData.orderCode, 
                'createdDate':rowData.createdDate
            },
            function(data) {
                var shopOrderInfoDto = data.shopOrderInfoDto;
                for (attr in shopOrderInfoDto) {
                    $("#" + attr).val(shopOrderInfoDto[attr]);
                }
                $("#manageModal").modal("show");
            }
        );
    }
}

function dealShopOrderInfo() {
    
    if(!$("#shopOrderInfoForm").valid()){
        return;
    };
    
    var data = $('#shopOrderInfoForm').serializeObject();
    var url = null;
    if($("#actionType").val() == "I") {
        url = contextPath + "shopOrderInfo/insert";
    }else {
        url = contextPath + "shopOrderInfo/update";
    }
    RestfulClient.post(
            url , 
            data ,
            function(data) {
                if(data.flag == "N") {
                    alertMsg(data.msg, "error", "");
                }else {
                    alertMsg(data.msg, "success", "");
                    $("#manageModal").modal("hide");
                    reloadGridTable();
                    validator.resetForm();
                }
            }
    );
}

function prepareDelete(){
        var items=$("#shopOrderInfoTable").jqGrid("getGridParam","selarrrow");
        if(items.length <= 0){
            alertMsg(selectAlert,"error","");
        }else{
            alertMsg(deleteRowMsgSureDesc,"confirm","deleteSure()"); //after sure delRowSure()
        }
}

function deleteSure(){
    var list = new Array();
    var selectItems=$("#shopOrderInfoTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#shopOrderInfoTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderCode':rowData.orderCode, 
            'createdDate':rowData.createdDate
        });
    }
    RestfulClient.post(contextPath + "shopOrderInfo/delete", {
        "extend" : {
            "shopOrderInfoList" : JSON.stringify(list)
        }
    }, function(data) {
        if(data.flag == "N") {
            alertMsg(data.msg, "error", "");
        }else {
            alertMsg(data.msg, "success", "");
            $("#manageModal").modal("hide");
            reloadGridTable();
        }
    });
}

$("#manageModal").draggable({
    handle: ".modal-header",   
    cursor: 'move',   
    refreshPositions: false  
});

function closeModal() {
    validator.resetForm();
}