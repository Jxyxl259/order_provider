$(document).ready(function() {
    
    validateForm();
    
    initAction(true);
    
    $("#btnQuery").on("click", function () {
        reloadGridTable();
    });
    
    $("#btnSave").on("click", function () {
        dealSynPolicyDtl();
    });
    
    $(function() {
        $(document).scroll(function() {
            $("#synPolicyDtlTable").setGridWidth($(window).width()-10);
        });
        $(window).resize(function() {
            $("#synPolicyDtlTable").setGridWidth($(window).width()-10);
        });
    });
});

var validator;
function validateForm() {
    validator = $("#synPolicyDtlForm").validate({
        focusInvalid : false,
        onkeyup : false,
        rules : {
            orderMainId:{
                required:true,
                byteRangeLength:[0,100]
            },
            orderCode:{
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
    $("#synPolicyDtlTable").setGridParam({ 
        postData: {
            "orderMainId" : $("#searchOrderMainId").val(),
            "orderCode" : $("#searchOrderCode").val(),
            "dealStatus" : $("#searchDealStatus").val(),
            "invalidFlag" : $("#searchInvalidFlag").val(),
            "createdUser" : $("#searchCreatedUser").val(),
            "createdDate" : $("#searchCreatedDate").val(),
            "updatedUser" : $("#searchUpdatedUser").val(),
            "updatedDate" : $("#searchUpdatedDate").val()
        }
    }).trigger("reloadGrid", [{ page: 1}]);
}

var flag = true ;  
function initAction(btnFlag){
    if(flag){
        loadTable();
        if(btnFlag){
            loadTableButtons();
        }
    }
    flag = false;  
}

function showDelFlag(cellvalue, options, rowObject){
    return cellvalue == "N" ? normalDesc:deleteDesc;
}

function loadTable(){
    $("#synPolicyDtlTable").jqGrid( {
        url : contextPath + "synPolicyDtl/list",
        mtype : 'post',
        datatype : "json",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
            return JSON.stringify(postData);
        },
        colNames : [ orderMainIdDesc, orderCodeDesc, dealStatusDesc, invalidFlagDesc, createdUserDesc, createdDateDesc, updatedUserDesc, updatedDateDesc],
        colModel : [ 
                     {name : 'orderMainId',index : 'orderMainId',width : 100,align : "center"},
                     {name : 'orderCode',index : 'orderCode',width : 100,align : "center"},
                     {name : 'dealStatus',index : 'dealStatus',width : 100,align : "center"},
                     {name : 'invalidFlag',index : 'invalidFlag',width : 100,align : "center"},
                     {name : 'createdUser',index : 'createdUser',width : 100,align : "center"},
                     {name : 'createdDate',index : 'createdDate',width : 100,align : "center"},
                     {name : 'updatedUser',index : 'updatedUser',width : 100,align : "center"},
                     {name : 'updatedDate',index : 'updatedDate',width : 100,align : "center"}
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
        pager : '#synPolicyDtlGridPager'
    });
}

function loadTableButtons(){
    $("#synPolicyDtlTable")
    .navGrid('#synPolicyDtlGridPager',{edit:false,add:false,del:false,search:false,refresh:false})
    .navButtonAdd('#synPolicyDtlGridPager',{
        title:addBtnDesc,
        caption:'',
        buttonicon:"fa-plus",
        onClickButton: function(){
            prepareInsert();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyDtlGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyDtlGridPager',{
        title:editBtnDesc,
        caption:'',
        buttonicon:"fa-edit",
        onClickButton: function(){
            prepareUpdate();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyDtlGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyDtlGridPager',{
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
        contextPath + "synPolicyDtl/prepareInsert",
        {
            
        },
        function(data) {
            var synPolicyDtlDto = data.synPolicyDtlDto;
            for (attr in synPolicyDtlDto) {
                $("#" + attr).val(synPolicyDtlDto[attr]);
            }
            $("#manageModal").modal("show");
        }
    );
}

function prepareUpdate(){
    
    $("#actionType").val("U");
    
    var selectItems = $("#synPolicyDtlTable").jqGrid("getGridParam","selarrrow");
    
    if(selectItems.length <= 0){
        alertMsg(editMsgDesc,"error","");
        return;
    }else if(selectItems.length > 1){
        alertMsg(editMsgDesc,"error","");
        return;
    }else{
        var rowData = $("#synPolicyDtlTable").jqGrid("getRowData",selectItems[0]);
        
        RestfulClient.post(
            contextPath + "synPolicyDtl/prepareUpdate",
            {
                'orderMainId':rowData.orderMainId
            },
            function(data) {
                var synPolicyDtlDto = data.synPolicyDtlDto;
                for (attr in synPolicyDtlDto) {
                    $("#" + attr).val(synPolicyDtlDto[attr]);
                }
                $("#manageModal").modal("show");
            }
        );
    }
}

function dealSynPolicyDtl() {
    
    if(!$("#synPolicyDtlForm").valid()){
        return;
    };
    
    var data = $('#synPolicyDtlForm').serializeObject();
    var url = null;
    if($("#actionType").val() == "I") {
        url = contextPath + "synPolicyDtl/insert";
    }else {
        url = contextPath + "synPolicyDtl/update";
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
        var items=$("#synPolicyDtlTable").jqGrid("getGridParam","selarrrow");
        if(items.length <= 0){
            alertMsg(selectMsgDesc,"error","");
        }else{
            alertMsg(deleteRowMsgSureDesc,"confirm","deleteSure()"); //after sure delRowSure()
        }
}

function deleteSure(){
    var list = new Array();
    var selectItems=$("#synPolicyDtlTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicyDtlTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'orderMainId':rowData.orderMainId
        });
    }
    RestfulClient.post(contextPath + "synPolicyDtl/delete", {
        "extend" : {
            "synPolicyDtlList" : JSON.stringify(list)
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