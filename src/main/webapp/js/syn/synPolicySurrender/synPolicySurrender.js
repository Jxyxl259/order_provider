var jqGridUrl = contextPath + "synPolicySurrender/list";
$(document).ready(function() {
    
	if(processPage=="1") {
		jqGridUrl = contextPath + "synPolicySurrender/processList";
	}
	
    validateForm();
    
    initAction(true);
    
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
        dealSynPolicySurrender();
    });
    
    $(function() {
        $(document).scroll(function() {
            $("#synPolicySurrenderTable").setGridWidth($(window).width()-10);
        });
        $(window).resize(function() {
            $("#synPolicySurrenderTable").setGridWidth($(window).width()-10);
        });
    });
});

function refreshPage(){
    //reloadGridTable();
}

//---------------------------------------------------------------------------
function prepareProcessManualDeal(){
    var items=$("#synPolicySurrenderTable").jqGrid("getGridParam","selarrrow");
    if(items.length <= 0){
        alertMsg(selectAlert,"error","");
    }else{
        alertMsg("确认要手工同步所选记录吗？","confirm","manualProcessDealSure()"); //after sure manualDealSure()
    }
}

function manualProcessDealSure(){
    var list = new Array();
    var selectItems=$("#synPolicySurrenderTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicySurrenderTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderCode':rowData.orderCodeStr,
            'policyNo':rowData.policyNo,
            'dealCount':rowData.dealCount
        });
    }
    RestfulClient.post(contextPath + "synPolicySurrender/synPolicySurrenderProcessDealManual", {
        "extend" : {
            "synPolicySurrenderList" : JSON.stringify(list)
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
    var items=$("#synPolicySurrenderTable").jqGrid("getGridParam","selarrrow");
    if(items.length <= 0){
        alertMsg(selectAlert,"error","");
    }else{
        alertMsg("确认要手工同步所选记录吗？","confirm","manualDealSure()"); //after sure manualDealSure()
    }
}

function manualDealSure(){
    var list = new Array();
    var selectItems=$("#synPolicySurrenderTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicySurrenderTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderCode':rowData.orderCodeStr,
            'policyNo':rowData.policyNo
        });
    }
    RestfulClient.post(contextPath + "synPolicySurrender/synPolicySurrenderDealManual", {
        "extend" : {
            "synPolicySurrenderList" : JSON.stringify(list)
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

var validator;
function validateForm() {
    validator = $("#synPolicySurrenderForm").validate({
        focusInvalid : false,
        onkeyup : false,
        rules : {
            orderCode:{
                required:true,
                byteRangeLength:[0,100]
            },
            policyNo:{
                required:true,
                byteRangeLength:[0,100]
            },
            dealStatus:{
                required:true,
                byteRangeLength:[0,100]
            },
            dealCount:{
                required:true,
                byteRangeLength:[0,100]
            },
            underWriteInd:{
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
    $("#synPolicySurrenderTable").setGridParam({ 
        postData: {
            "orderCode" : $("#searchOrderCode").val(),
            "policyNo" : $("#searchPolicyNo").val(),
            "dealStatus" : $("#searchDealStatus").val(),
            "dealCount" : $("#searchDealCount").val(),
            "underWriteInd" : $("#searchUnderWriteInd").val(),
            "invalidFlag" : $("#searchInvalidFlag").val(),
            "createdUser" : $("#searchCreatedUser").val(),
            "createdDate" : $("#searchCreatedDate").val(),
            "updatedUser" : $("#searchUpdatedUser").val(),
            "updatedDate" : $("#searchUpdatedDate").val()
        },
        datatype : "json"
    }).trigger("reloadGrid", [{ page: 1}]);
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

function showDealStatus(cellvalue, options, rowObject){
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

function showUnderWriteInd(cellvalue, options, rowObject){
    if(cellvalue == "0") {
        return "初始状态";
    }else if(cellvalue == "1") {
        return "核保通过";
    }else if(cellvalue == "2") {
    	return "核保不通过";
    }else if(cellvalue == "3") {
    	return "自动核保";
    }else if(cellvalue == "4") {
    	return "拒保";
    }else if(cellvalue == "5") {
    	return "复核通过";
    }else if(cellvalue == "6") {
    	return "承保确认";
    }else if(cellvalue == "7") {
    	return "复核不通过";
    }else if(cellvalue == "8") {
    	return "待复核";
    }else if(cellvalue == "9") {
    	return "待核保";
    }else {
        return "-";
    }
}

function loadTable(){
    $("#synPolicySurrenderTable").jqGrid( {
        url : jqGridUrl,
        mtype : 'post',
        datatype : "local",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
            return JSON.stringify(postData);
        },
        colNames : [ orderCodeDesc, policyNoDesc, dealStatusDesc, dealCountDesc, underWriteIndDesc, invalidFlagDesc, createdUserDesc, createdDateDesc, updatedUserDesc, updatedDateDesc],
        colModel : [ 
                     {name : 'orderCodeStr',index : 'orderCode',width : 100,align : "center"},
                     {name : 'policyNo',index : 'policyNo',width : 150,align : "center"},
                     {name : 'dealStatus',index : 'dealStatus',width : 100,align : "center", formatter: showDealStatus},
                     {name : 'dealCount',index : 'dealCount',width : 45,align : "center"},
                     {name : 'underWriteInd',index : 'underWriteInd',width : 60,align : "center", formatter: showUnderWriteInd},
                     {name : 'invalidFlag',index : 'invalidFlag', hidden: true},
                     {name : 'createdUser',index : 'createdUser', hidden: true},
                     {name : 'createdDate',index : 'createdDate',width : 85,align : "center"},
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
        pager : '#synPolicySurrenderGridPager'
    });
}

function loadTableButtons(){
    $("#synPolicySurrenderTable")
    .navGrid('#synPolicySurrenderGridPager',{edit:false,add:false,del:false,search:false,refresh:false})
    .navButtonAdd('#synPolicySurrenderGridPager',{
        title:addBtnDesc,
        caption:'',
        buttonicon:"fa-plus",
        onClickButton: function(){
            prepareInsert();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicySurrenderGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicySurrenderGridPager',{
        title:editBtnDesc,
        caption:'',
        buttonicon:"fa-edit",
        onClickButton: function(){
            prepareUpdate();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicySurrenderGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicySurrenderGridPager',{
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
        contextPath + "synPolicySurrender/prepareInsert",
        {
            
        },
        function(data) {
            var synPolicySurrenderDto = data.synPolicySurrenderDto;
            for (attr in synPolicySurrenderDto) {
                $("#" + attr).val(synPolicySurrenderDto[attr]);
            }
            $("#manageModal").modal("show");
        }
    );
}

function prepareUpdate(){
    
    $("#actionType").val("U");
    
    var selectItems = $("#synPolicySurrenderTable").jqGrid("getGridParam","selarrrow");
    
    if(selectItems.length <= 0){
        alertMsg(editMsgDesc,"error","");
        return;
    }else if(selectItems.length > 1){
        alertMsg(editMsgDesc,"error","");
        return;
    }else{
        var rowData = $("#synPolicySurrenderTable").jqGrid("getRowData",selectItems[0]);
        
        RestfulClient.post(
            contextPath + "synPolicySurrender/prepareUpdate",
            {
                'orderCode':rowData.orderCode, 
                'policyNo':rowData.policyNo
            },
            function(data) {
                var synPolicySurrenderDto = data.synPolicySurrenderDto;
                for (attr in synPolicySurrenderDto) {
                    $("#" + attr).val(synPolicySurrenderDto[attr]);
                }
                $("#manageModal").modal("show");
            }
        );
    }
}

function dealSynPolicySurrender() {
    
    if(!$("#synPolicySurrenderForm").valid()){
        return;
    };
    
    var data = $('#synPolicySurrenderForm').serializeObject();
    var url = null;
    if($("#actionType").val() == "I") {
        url = contextPath + "synPolicySurrender/insert";
    }else {
        url = contextPath + "synPolicySurrender/update";
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
        var items=$("#synPolicySurrenderTable").jqGrid("getGridParam","selarrrow");
        if(items.length <= 0){
            alertMsg(selectMsgDesc,"error","");
        }else{
            alertMsg(deleteRowMsgSureDesc,"confirm","deleteSure()"); //after sure delRowSure()
        }
}

function deleteSure(){
    var list = new Array();
    var selectItems=$("#synPolicySurrenderTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicySurrenderTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderCode':rowData.orderCode, 
            'policyNo':rowData.policyNo
        });
    }
    RestfulClient.post(contextPath + "synPolicySurrender/delete", {
        "extend" : {
            "synPolicySurrenderList" : JSON.stringify(list)
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