var jqGridUrl = contextPath + "synPolicy/list";
$(document).ready(function() {
    
	if(processPage=="1") {
		jqGridUrl = contextPath + "synPolicy/processList";
	}
	
    validateForm();
    
    initAction(true);
    
    initDtlAction(true);
    
    $("#btnQuery").on("click", function () {
        reloadGridTable();
    });
    
    $("#btnManual").on("click", function () {
    	prepareManualDeal();
    });
    
    $("#btnProcessQuery").on("click", function () {
        reloadGridTable();
    });
    
    $("#btnProcessManual").on("click", function () {
    	prepareProcessManualDeal();
    });
    
    $("#btnSave").on("click", function () {
        dealSynPolicy();
    });
    
    $(function() {
        $(document).scroll(function() {
            $("#synPolicyTable").setGridWidth($(window).width()-10);
        });
        $(window).resize(function() {
            $("#synPolicyTable").setGridWidth($(window).width()-10);
        });
    });
});

function refreshPage(){
    //reloadGridTable();
}

//---------------------------------------------------------------------------
function prepareProcessManualDeal(){
    var items=$("#synPolicyTable").jqGrid("getGridParam","selarrrow");
    if(items.length <= 0){
        alertMsg(selectAlert,"error","");
    }else{
        alertMsg("确认要手工同步所选记录吗？","confirm","manualProcessDealSure()"); //after sure manualDealSure()
    }
}

function manualProcessDealSure(){
    var list = new Array();
    var selectItems=$("#synPolicyTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicyTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderCode':rowData.orderCodeStr,
            'detailCount':rowData.detailCount,
            'dealCount':rowData.dealCount
        });
    }
    RestfulClient.post(contextPath + "synPolicy/synPolicyProcessDealManual", {
        "extend" : {
            "synPolicyList" : JSON.stringify(list)
        }
    }, function(data) {
        if(data.flag == "N") {
            alertMsg(data.msg, "error", "");
        }else {
            alertMsg(data.msg, "success", "");
            reloadGridTable();
        }
    });
}

//---------------------------------------------------------------------------
function prepareManualDeal(){
    var items=$("#synPolicyTable").jqGrid("getGridParam","selarrrow");
    if(items.length <= 0){
        alertMsg(selectAlert,"error","");
    }else{
        alertMsg("确认要手工同步所选记录吗？","confirm","manualDealSure()"); //after sure manualDealSure()
    }
}

function manualDealSure(){
    var list = new Array();
    var selectItems=$("#synPolicyTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicyTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderCode':rowData.orderCodeStr
        });
    }
    RestfulClient.post(contextPath + "synPolicy/synPolicyDealManual", {
        "extend" : {
            "synPolicyList" : JSON.stringify(list)
        }
    }, function(data) {
        if(data.flag == "N") {
            alertMsg(data.msg, "error", "");
        }else {
            alertMsg(data.msg, "success", "");
            reloadGridTable();
        }
    });
}

//---------------------------------------------------------------------------
function reloadDtlGridTable() {
    $("#synPolicyDtlTable").setGridParam({ 
        postData: {
            "orderMainId" : $("#searchOrderMainId").val(),
            "orderCode" : $("#searchOrderCode").val()
        },
        datatype : "json"
    }).trigger("reloadGrid", [{ page: 1}]);
}

var flagDtl = true ;  
function initDtlAction(btnFlag){
    if(flagDtl){
        loadDtlTable();
    }
    flagDtl = false;  
}

function showDtlStatus(cellvalue, options, rowObject){
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

function loadDtlTable(){
    $("#synPolicyDtlTable").jqGrid( {
        url : contextPath + "synPolicyDtl/list",
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
        colNames : [ orderMainIdDesc, orderCodeDesc, policyNoDesc, agrtCodeDesc, dealStatusDesc, invalidFlagDesc, createdUserDesc, createdDateDesc, updatedUserDesc, updatedDateDesc],
        colModel : [ 
                     {name : 'orderMainIdStr',index : 'orderMainId',width : 100,align : "center"},
                     {name : 'orderCodeStr',index : 'orderCode',width : 100,align : "center"},
                     {name : 'policyNo',index : 'policyNo',width : 100,align : "center"},
                     {name : 'agrtCode',index : 'agrtCode',width : 100,align : "center"},
                     {name : 'dealStatus',index : 'dealStatus',width : 80,align : "center", formatter: showDtlStatus},
                     {name : 'invalidFlag',index : 'invalidFlag', hidden: true},
                     {name : 'createdUser',index : 'createdUser', hidden: true},
                     {name : 'createdDate',index : 'createdDate',width : 80,align : "center"},
                     {name : 'updatedUser',index : 'updatedUser', hidden: true},
                     {name : 'updatedDate',index : 'updatedDate',width : 80,align : "center"}
                   ],
        rowNum : 10,
        rowList : [ 10, 20, 30, 50 ],
        sortname : 'updatedDate',
        autowidth : true,
        multiboxonly :true,
        multiselectWidth : 30,
        height : 'auto',
        viewrecords : true,
        sortorder : "desc",
        multiselect : true,
        viewrecords : true,
        recordpos : 'right',
        pager : '#synPolicyDtlGridPager'
    });
}
//---------------------------------------------------------------------------

var validator;
function validateForm() {
    validator = $("#synPolicyForm").validate({
        focusInvalid : false,
        onkeyup : false,
        rules : {
            orderCode:{
                required:true,
                byteRangeLength:[0,100]
            },
            detailCount:{
                required:true,
                byteRangeLength:[0,100]
            },
            dealStatus:{
                required:true,
                byteRangeLength:[0,100]
            },
            invalidFlag:{
                required:true,
                byteRangeLength:[0,100]
            },
            createdUser:{
                required:true,
                byteRangeLength:[0,100]
            },
            createdDate:{
                required:true,
                byteRangeLength:[0,100]
            },
            updatedUser:{
                required:true,
                byteRangeLength:[0,100]
            },
            updatedDate:{
                required:true,
                byteRangeLength:[0,100]
            }
        }
    });
}

function reloadGridTable() {
    $("#synPolicyTable").setGridParam({ 
        postData: {
            "orderCode" : $("#searchOrderCode").val(),
            "policyNo" : $("#searchPolicyNo").val(),
            "detailCount" : $("#searchDetailCount").val(),
            "dealStatus" : $("#searchDealStatus").val(),
            "invalidFlag" : $("#searchInvalidFlag").val(),
            "createdUser" : $("#searchCreatedUser").val(),
            "createdDate" : $("#searchCreatedDate").val(),
            "updatedUser" : $("#searchUpdatedUser").val(),
            "updatedDate" : $("#searchUpdatedDate").val()
        },
        datatype : "json"
    }).trigger("reloadGrid", [{ page: 1}]);
    
    $("#orderCodeSelect").val("");
    $("#orderCodeInfo").html("");
    $("#synPolicyDtlTable").jqGrid().clearGridData();
}

var flag = true ;  
function initAction(btnFlag){
    if(flag){
        loadTable();
        /*if(btnFlag){
            loadTableButtons();
        }*/
    }
    flag = false;  
}

function showStatus(cellvalue, options, rowObject){
    if(cellvalue == "0") {
        return "未处理";
    }else if(cellvalue == "1") {
        return "处理中";
    }else if(cellvalue == "2") {
    	return "处理成功";
    }else {
        return "处理失败";
    }
}

function loadTable(){
    $("#synPolicyTable").jqGrid( {
        url : jqGridUrl,
        mtype : 'post',
        datatype : "local",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
            return JSON.stringify(postData);
        },
        colNames : [ orderCodeDesc, detailCountDesc, dealCountDesc, dealStatusDesc, invalidFlagDesc, createdUserDesc, createdDateDesc, updatedUserDesc, updatedDateDesc, '操作'],
        colModel : [ 
                     {name : 'orderCodeStr',index : 'orderCode',width : 100,align : "center"},
                     {name : 'detailCount',index : 'detailCount',width : 100,align : "center"},
                     {name : 'dealCount',index : 'dealCount',width : 100,align : "center"},
                     {name : 'dealStatus',index : 'dealStatus',width : 100,align : "center", formatter: showStatus},
                     {name : 'invalidFlag',index : 'invalidFlag', hidden: true},
                     {name : 'createdUser',index : 'createdUser', hidden: true},
                     {name : 'createdDate',index : 'createdDate',width : 100,align : "center"},
                     {name : 'updatedUser',index : 'updatedUser', hidden: true},
                     {name : 'updatedDate',index : 'updatedDate',width : 100,align : "center"},
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
        pager : '#synPolicyGridPager',
        onSelectRow : function(rowid,status){
            var rowData = $("#synPolicyTable").jqGrid("getRowData",rowid);
            $("#orderCodeInfo").html("");
            $("#orderCodeInfo").html("&nbsp;-&nbsp;[订单号:"+ rowData.orderCodeStr+"]");
            $("#orderCodeSelect").val(rowData.orderCodeStr);
            reloadDtlGridTable();
        },
        onPaging : function(pgButton) {
        	$("#orderCodeSelect").val("");
            $("#orderCodeInfo").html("");
            $("#synPolicyDtlTable").jqGrid().clearGridData();
        }
    });
}

function showJsonOrder(cellvalue, options, rowObject){
    return '<a onclick="javascript:viewOrderJsonData('+"'"+rowObject.orderCodeStr+"'"+')">查看</a>';
}

var iTop = (window.screen.availHeight-30-630)/2;       
var iLeft = (window.screen.availWidth-10-1000)/2;
function viewOrderJsonData(orderCode) {
    window.open(contextPath + "viewOrderJsonData?orderCode="+orderCode,"订单详情","height=620, width=1000, top="+iTop+", left="+iLeft+", toolbar=no, menubar=no, scrollbars=yes, resizable=yes, location=no, status=no");                          
}

function loadTableButtons(){
    $("#synPolicyTable")
    .navGrid('#synPolicyGridPager',{edit:false,add:false,del:false,search:false,refresh:false})
    .navButtonAdd('#synPolicyGridPager',{
        title:addBtnDesc,
        caption:'',
        buttonicon:"fa-plus",
        onClickButton: function(){
            prepareInsert();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyGridPager',{
        title:editBtnDesc,
        caption:'',
        buttonicon:"fa-edit",
        onClickButton: function(){
            prepareUpdate();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyGridPager',{
        title:delBtnDesc,
        caption:'',
        buttonicon:"fa-trash",
        onClickButton: function(){
            prepareDelete();
        },
        position:"last"
    }); 
}

function prepareInsert(){
    
    $("#actionType").val("I");
    
    RestfulClient.post(
        contextPath + "synPolicy/prepareInsert",
        {
            
        },
        function(data) {
            var synPolicyDto = data.synPolicyDto;
            for (attr in synPolicyDto) {
                $("#" + attr).val(synPolicyDto[attr]);
            }
            $("#manageModal").modal("show");
        }
    );
}

function prepareUpdate(){
    
    $("#actionType").val("U");
    
    var selectItems = $("#synPolicyTable").jqGrid("getGridParam","selarrrow");
    
    if(selectItems.length <= 0){
        alertMsg(editMsgDesc,"error","");
        return;
    }else if(selectItems.length > 1){
        alertMsg(editMsgDesc,"error","");
        return;
    }else{
        var rowData = $("#synPolicyTable").jqGrid("getRowData",selectItems[0]);
        
        RestfulClient.post(
            contextPath + "synPolicy/prepareUpdate",
            {
                'orderCode':rowData.orderCode
            },
            function(data) {
                var synPolicyDto = data.synPolicyDto;
                for (attr in synPolicyDto) {
                    $("#" + attr).val(synPolicyDto[attr]);
                }
                $("#manageModal").modal("show");
            }
        );
    }
}

function dealSynPolicy() {
    
    if(!$("#synPolicyForm").valid()){
        return;
    };
    
    var data = $('#synPolicyForm').serializeObject();
    var url = null;
    if($("#actionType").val() == "I") {
        url = contextPath + "synPolicy/insert";
    }else {
        url = contextPath + "synPolicy/update";
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
        var items=$("#synPolicyTable").jqGrid("getGridParam","selarrrow");
        if(items.length <= 0){
            alertMsg(selectAlert,"error","");
        }else{
            alertMsg(deleteRowMsgSureDesc,"confirm","deleteSure()"); //after sure delRowSure()
        }
}

function deleteSure(){
    var list = new Array();
    var selectItems=$("#synPolicyTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicyTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderCode':rowData.orderCode
        });
    }
    RestfulClient.post(contextPath + "synPolicy/delete", {
        "extend" : {
            "synPolicyList" : JSON.stringify(list)
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