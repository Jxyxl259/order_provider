$(document).ready(function() {
    
    validateForm();
    
    initAction(true);
    
    $("#btnQuery").on("click", function () {
        reloadGridTable();
    });
    
    $("#btnSave").on("click", function () {
        dealSynPolicyFilterCfg();
    });
    
    $(function() {
        $(document).scroll(function() {
            $("#synPolicyFilterCfgTable").setGridWidth($(window).width()-10);
        });
        $(window).resize(function() {
            $("#synPolicyFilterCfgTable").setGridWidth($(window).width()-10);
        });
    });
});

var validator;
function validateForm() {
    validator = $("#synPolicyFilterCfgForm").validate({
        focusInvalid : false,
        onkeyup : false,
        rules : {
            filterCfgId:{
                required:true,
                byteRangeLength:[0,100]
            },
            agrtCode:{
                required:true,
                byteRangeLength:[0,100]
            },
            remark:{
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
    $("#synPolicyFilterCfgTable").setGridParam({ 
        postData: {
            "filterCfgId" : $("#searchFilterCfgId").val(),
            "agrtCode" : $("#searchAgrtCode").val(),
            "remark" : $("#searchRemark").val(),
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
    return cellvalue == "0" ? normalDesc:deleteDesc;
}

function loadTable(){
    $("#synPolicyFilterCfgTable").jqGrid( {
        url : contextPath + "synPolicyFilterCfg/list",
        mtype : 'post',
        datatype : "json",
        ajaxGridOptions : { contentType : 'application/json; charset=utf-8' },
        serializeGridData : function (postData)
        {
            return JSON.stringify(postData);
        },
        colNames : [ filterCfgIdDesc, agrtCodeDesc, remarkDesc, invalidFlagDesc, createdUserDesc, createdDateDesc, updatedUserDesc, updatedDateDesc],
        colModel : [ 
                     {name : 'filterCfgId',index : 'filterCfgId', hidden: true},
                     {name : 'agrtCode',index : 'agrtCode',width : 100,align : "center"},
                     {name : 'remark',index : 'remark',width : 100,align : "center"},
                     {name : 'invalidFlag',index : 'invalidFlag',width : 100,align : "center", formatter: showDelFlag},
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
        pager : '#synPolicyFilterCfgGridPager'
    });
}

function loadTableButtons(){
    $("#synPolicyFilterCfgTable")
    .navGrid('#synPolicyFilterCfgGridPager',{edit:false,add:false,del:false,search:false,refresh:false})
    .navButtonAdd('#synPolicyFilterCfgGridPager',{
        title:addBtnDesc,
        caption:'',
        buttonicon:"fa-plus",
        onClickButton: function(){
            prepareInsert();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyFilterCfgGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyFilterCfgGridPager',{
        title:editBtnDesc,
        caption:'',
        buttonicon:"fa-edit",
        onClickButton: function(){
            prepareUpdate();
        },
        position:"last"
    })
    .navSeparatorAdd("#synPolicyFilterCfgGridPager",{sepclass : 'ui-separator',sepcontent: ''})
    .navButtonAdd('#synPolicyFilterCfgGridPager',{
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
        contextPath + "synPolicyFilterCfg/prepareInsert",
        {
            
        },
        function(data) {
            var synPolicyFilterCfgDto = data.synPolicyFilterCfgDto;
            for (attr in synPolicyFilterCfgDto) {
                $("#" + attr).val(synPolicyFilterCfgDto[attr]);
            }
            $("#manageModal").modal("show");
        }
    );
}

function prepareUpdate(){
    
    $("#actionType").val("U");
    
    var selectItems = $("#synPolicyFilterCfgTable").jqGrid("getGridParam","selarrrow");
    
    if(selectItems.length <= 0){
        alertMsg(editMsgDesc,"error","");
        return;
    }else if(selectItems.length > 1){
        alertMsg(editMsgDesc,"error","");
        return;
    }else{
        var rowData = $("#synPolicyFilterCfgTable").jqGrid("getRowData",selectItems[0]);
        
        RestfulClient.post(
            contextPath + "synPolicyFilterCfg/prepareUpdate",
            {
                'filterCfgId':rowData.filterCfgId
            },
            function(data) {
                var synPolicyFilterCfgDto = data.synPolicyFilterCfgDto;
                for (attr in synPolicyFilterCfgDto) {
                    $("#" + attr).val(synPolicyFilterCfgDto[attr]);
                }
                $("#manageModal").modal("show");
            }
        );
    }
}

function dealSynPolicyFilterCfg() {
    
    if(!$("#synPolicyFilterCfgForm").valid()){
        return;
    };
    
    var data = $('#synPolicyFilterCfgForm').serializeObject();
    var url = null;
    if($("#actionType").val() == "I") {
        url = contextPath + "synPolicyFilterCfg/insert";
    }else {
        url = contextPath + "synPolicyFilterCfg/update";
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
        var items=$("#synPolicyFilterCfgTable").jqGrid("getGridParam","selarrrow");
        if(items.length <= 0){
            alertMsg(selectAlert,"error","");
        }else{
            alertMsg(deleteRowMsgSureDesc,"confirm","deleteSure()"); //after sure delRowSure()
        }
}

function deleteSure(){
    var list = new Array();
    var selectItems=$("#synPolicyFilterCfgTable").jqGrid("getGridParam","selarrrow");
    for(var i = 0;i < selectItems.length;i++){
        var rowData = $("#synPolicyFilterCfgTable").jqGrid("getRowData",selectItems[i]);
        list.push( {
            'filterCfgId':rowData.filterCfgId
        });
    }
    RestfulClient.post(contextPath + "synPolicyFilterCfg/delete", {
        "extend" : {
            "synPolicyFilterCfgList" : JSON.stringify(list)
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