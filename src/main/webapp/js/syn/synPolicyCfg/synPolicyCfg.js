$(document).ready(function() {
    
    validateForm();
    
    initAction(true);
    
    $("#btnQuery").on("click", function () {
        reloadGridTable();
    });
    
    $("#btnSave").on("click", function () {
        dealSynPolicyCfg();
    });
    
    $(function() {
        $(document).scroll(function() {
            $("#synPolicyCfgTable").setGridWidth($(window).width()-10);
        });
        $(window).resize(function() {
            $("#synPolicyCfgTable").setGridWidth($(window).width()-10);
        });
    });
});

var validator;
function validateForm() {
    validator = $("#synPolicyCfgForm").validate({
        focusInvalid : false,
        onkeyup : false,
        rules : {
            dealType:{
                required:true,
                byteRangeLength:[0,100]
            },
            description:{
                required:true,
                byteRangeLength:[0,100]
            },
            failRetryCount:{
                required:true,
                byteRangeLength:[0,100]
            },
            dealBeforeDate:{
                required:true,
                byteRangeLength:[0,100]
            },
            limitCount:{
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
    $("#synPolicyCfgTable").setGridParam({ 
        postData: {
            "dealType" : $("#searchDealType").val(),
            "description" : $("#searchDescription").val(),
            "failRetryCount" : $("#searchFailRetryCount").val(),
            "dealBeforeDate" : $("#searchDealBeforeDate").val(),
            "limitCount" : $("#searchLimitCount").val(),
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
    $("#synPolicyCfgTable").jqGrid( {
        url : contextPath + "synPolicyCfg/list",
        mtype : 'post',
        datatype : "json",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
            return JSON.stringify(postData);
        },
        colNames : [ dealTypeDesc, descriptionDesc, failRetryCountDesc, dealBeforeDateDesc, limitCountDesc, invalidFlagDesc, createdUserDesc, createdDateDesc, updatedUserDesc, updatedDateDesc],
        colModel : [ 
                     {name : 'dealType',index : 'dealType',width : 100,align : "center"},
                     {name : 'description',index : 'description',width : 100,align : "center"},
                     {name : 'failRetryCount',index : 'failRetryCount',width : 100,align : "center"},
                     {name : 'dealBeforeDate',index : 'dealBeforeDate',width : 100,align : "center"},
                     {name : 'limitCount',index : 'limitCount',width : 100,align : "center"},
                     {name : 'invalidFlag',index : 'invalidFlag', hidden: true},
                     {name : 'createdUser',index : 'createdUser',width : 100,align : "center"},
                     {name : 'createdDate',index : 'createdDate',width : 100,align : "center"},
                     {name : 'updatedUser',index : 'updatedUser',width : 100,align : "center"},
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
        pager : '#synPolicyCfgGridPager'
    });
}

function loadTableButtons(){
    $("#synPolicyCfgTable")
    .navGrid('#synPolicyCfgGridPager',{edit:false,add:false,del:false,search:false,refresh:false})
    .navButtonAdd('#synPolicyCfgGridPager',{
        title:addBtnDesc,
        caption:'',
        buttonicon:"fa-plus",
        onClickButton: function(){
            prepareInsert();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyCfgGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyCfgGridPager',{
        title:editBtnDesc,
        caption:'',
        buttonicon:"fa-edit",
        onClickButton: function(){
            prepareUpdate();
        },
        position:"last"
    })
    /*.navSeparatorAdd("#synPolicyCfgGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyCfgGridPager',{
        title:delBtnDesc,
        caption:'',
        buttonicon:"fa-trash",
        onClickButton: function(){
            prepareDelete();
        },
        position:"last"
    })*/;
}

function prepareInsert(){
    
    $("#actionType").val("I");
    
    RestfulClient.post(
        contextPath + "synPolicyCfg/prepareInsert",
        {
            
        },
        function(data) {
            var synPolicyCfgDto = data.synPolicyCfgDto;
            for (attr in synPolicyCfgDto) {
                $("#" + attr).val(synPolicyCfgDto[attr]);
            }
            undoSetReadonlyOfElement(document.getElementById("dealType"));
            $("#manageModal").modal("show");
        }
    );
}

function prepareUpdate(){
    
    $("#actionType").val("U");
    
    var selectItems = $("#synPolicyCfgTable").jqGrid("getGridParam","selarrrow");
    
    if(selectItems.length <= 0){
        alertMsg(editMsgDesc,"error","");
        return;
    }else if(selectItems.length > 1){
        alertMsg(editMsgDesc,"error","");
        return;
    }else{
        var rowData = $("#synPolicyCfgTable").jqGrid("getRowData",selectItems[0]);
        
        RestfulClient.post(
            contextPath + "synPolicyCfg/prepareUpdate",
            {
                'dealType':rowData.dealType
            },
            function(data) {
                var synPolicyCfgDto = data.synPolicyCfgDto;
                for (attr in synPolicyCfgDto) {
                    $("#" + attr).val(synPolicyCfgDto[attr]);
                }
                setReadonlyOfElement(document.getElementById("dealType"));
                $("#manageModal").modal("show");
            }
        );
    }
}

function dealSynPolicyCfg() {
    
    if(!$("#synPolicyCfgForm").valid()){
        return;
    };
    
    var data = $('#synPolicyCfgForm').serializeObject();
    var url = null;
    if($("#actionType").val() == "I") {
        url = contextPath + "synPolicyCfg/insert";
    }else {
        url = contextPath + "synPolicyCfg/update";
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
        var items=$("#synPolicyCfgTable").jqGrid("getGridParam","selarrrow");
        if(items.length <= 0){
            alertMsg(selectAlert,"error","");
        }else{
            alertMsg(deleteRowMsgSureDesc,"confirm","deleteSure()"); //after sure delRowSure()
        }
}

function deleteSure(){
    var list = new Array();
    var selectItems=$("#synPolicyCfgTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicyCfgTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'dealType':rowData.dealType
        });
    }
    RestfulClient.post(contextPath + "synPolicyCfg/delete", {
        "extend" : {
            "synPolicyCfgList" : JSON.stringify(list)
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