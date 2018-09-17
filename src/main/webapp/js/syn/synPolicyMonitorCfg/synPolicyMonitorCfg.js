$(document).ready(function() {
    
    validateForm();
    
    initAction(true);
    
    $("#btnQuery").on("click", function () {
        reloadGridTable();
    });
    
    $("#btnSave").on("click", function () {
        dealSynPolicyMonitorCfg();
    });
    
    $(function() {
        $(document).scroll(function() {
            $("#synPolicyMonitorCfgTable").setGridWidth($(window).width()-10);
        });
        $(window).resize(function() {
            $("#synPolicyMonitorCfgTable").setGridWidth($(window).width()-10);
        });
    });
});

var validator;
function validateForm() {
    validator = $("#synPolicyMonitorCfgForm").validate({
        focusInvalid : false,
        onkeyup : false,
        rules : {
            monitorType:{
                required:true,
                byteRangeLength:[0,100]
            },
            description:{
                required:true,
                byteRangeLength:[0,100]
            },
            threshold:{
                required:true,
                byteRangeLength:[0,100]
            },
            warnMsg:{
                required:true,
                byteRangeLength:[0,100]
            },
            mobile:{
                required:true,
                byteRangeLength:[0,100]
            },
            smsSwitch:{
                required:true,
                byteRangeLength:[0,100]
            },
            email:{
                required:true,
                byteRangeLength:[0,100]
            },
            emailSwitch:{
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
    $("#synPolicyMonitorCfgTable").setGridParam({ 
        postData: {
            "monitorType" : $("#searchMonitorType").val(),
            "description" : $("#searchDescription").val(),
            "threshold" : $("#searchThreshold").val(),
            "warnMsg" : $("#searchWarnMsg").val(),
            "mobile" : $("#searchMobile").val(),
            "smsSwitch" : $("#searchSmsSwitch").val(),
            "email" : $("#searchEmail").val(),
            "emailSwitch" : $("#searchEmailSwitch").val(),
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

function showSwitch(cellvalue, options, rowObject){
    return cellvalue == 0 ? "开启":"关闭";
}

function loadTable(){
    $("#synPolicyMonitorCfgTable").jqGrid( {
        url : contextPath + "synPolicyMonitorCfg/list",
        mtype : 'post',
        datatype : "json",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
            return JSON.stringify(postData);
        },
        colNames : [ monitorTypeDesc, descriptionDesc, thresholdDesc, warnMsgDesc, smsSwitchDesc, mobileDesc, emailDesc, emailSwitchDesc, invalidFlagDesc, createdUserDesc, createdDateDesc, updatedUserDesc, updatedDateDesc],
        colModel : [ 
                     {name : 'monitorType',index : 'monitorType',width : 100,align : "center"},
                     {name : 'description',index : 'description',width : 100,align : "center"},
                     {name : 'threshold',index : 'threshold',width : 100,align : "center"},
                     {name : 'warnMsg',index : 'warnMsg', hidden: true},
                     {name : 'smsSwitch',index : 'smsSwitch',width : 100,align : "center", formatter: showSwitch},
                     {name : 'mobile',index : 'mobile',width : 100,align : "center"},
                     {name : 'email',index : 'email', hidden: true},
                     {name : 'emailSwitch',index : 'emailSwitch', hidden: true},
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
        pager : '#synPolicyMonitorCfgGridPager'
    });
}

function loadTableButtons(){
    $("#synPolicyMonitorCfgTable")
    .navGrid('#synPolicyMonitorCfgGridPager',{edit:false,add:false,del:false,search:false,refresh:false})
    .navButtonAdd('#synPolicyMonitorCfgGridPager',{
        title:addBtnDesc,
        caption:'',
        buttonicon:"fa-plus",
        onClickButton: function(){
            prepareInsert();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyMonitorCfgGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyMonitorCfgGridPager',{
        title:editBtnDesc,
        caption:'',
        buttonicon:"fa-edit",
        onClickButton: function(){
            prepareUpdate();
        },
        position:"last"
    })
    /*.navSeparatorAdd("#synPolicyMonitorCfgGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyMonitorCfgGridPager',{
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
        contextPath + "synPolicyMonitorCfg/prepareInsert",
        {
            
        },
        function(data) {
            var synPolicyMonitorCfgDto = data.synPolicyMonitorCfgDto;
            for (attr in synPolicyMonitorCfgDto) {
                $("#" + attr).val(synPolicyMonitorCfgDto[attr]);
            }
            undoSetReadonlyOfElement(document.getElementById("monitorType"));
            $("#manageModal").modal("show");
        }
    );
}

function prepareUpdate(){
    
    $("#actionType").val("U");
    
    var selectItems = $("#synPolicyMonitorCfgTable").jqGrid("getGridParam","selarrrow");
    
    if(selectItems.length <= 0){
        alertMsg(editMsgDesc,"error","");
        return;
    }else if(selectItems.length > 1){
        alertMsg(editMsgDesc,"error","");
        return;
    }else{
        var rowData = $("#synPolicyMonitorCfgTable").jqGrid("getRowData",selectItems[0]);
        
        RestfulClient.post(
            contextPath + "synPolicyMonitorCfg/prepareUpdate",
            {
                'monitorType':rowData.monitorType
            },
            function(data) {
                var synPolicyMonitorCfgDto = data.synPolicyMonitorCfgDto;
                for (attr in synPolicyMonitorCfgDto) {
                    $("#" + attr).val(synPolicyMonitorCfgDto[attr]);
                }
                setReadonlyOfElement(document.getElementById("monitorType"));
                $("#manageModal").modal("show");
            }
        );
    }
}

function dealSynPolicyMonitorCfg() {
    
    if(!$("#synPolicyMonitorCfgForm").valid()){
        return;
    };
    
    var data = $('#synPolicyMonitorCfgForm').serializeObject();
    var url = null;
    if($("#actionType").val() == "I") {
        url = contextPath + "synPolicyMonitorCfg/insert";
    }else {
        url = contextPath + "synPolicyMonitorCfg/update";
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
        var items=$("#synPolicyMonitorCfgTable").jqGrid("getGridParam","selarrrow");
        if(items.length <= 0){
            alertMsg(selectAlert,"error","");
        }else{
            alertMsg(deleteRowMsgSureDesc,"confirm","deleteSure()"); //after sure delRowSure()
        }
}

function deleteSure(){
    var list = new Array();
    var selectItems=$("#synPolicyMonitorCfgTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicyMonitorCfgTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'monitorType':rowData.monitorType
        });
    }
    RestfulClient.post(contextPath + "synPolicyMonitorCfg/delete", {
        "extend" : {
            "synPolicyMonitorCfgList" : JSON.stringify(list)
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