(function(global, $) {
    var RestfulClient = function() {
        this.options = {
            async : true,
            cache : false,
            complete : function(xhr, status) {

            },
            contentType : 'application/json',
            // context : this,
            // data : '',
            // dataFilter : function() {},
            dataType : 'json',
            error : function(xhr, status, error) {
            },
            // global : true,
            // ifModified : false,
            // jsonp : '',
            // jsonpCallback : '',
            username : '',
            password : '',
            // processData : true,
            // scriptCharset : '',
            success : function(data, status, xhr) {
            },
            // traditional : false,
            //timeout : 10000,
            url : '',
            // xhr : function(xhr) {},
            type : 'POST'
        };
    };

    RestfulClient.prototype.get = function(url, callback) {
        this.options['url'] = url;
        this.options['type'] = 'GET';
        this.options['success'] = callback;
        $.ajax(this.options);
    };

    RestfulClient.prototype.post = function(url, data, callback, errorCallback) {
        this.options['url'] = url;
        this.options['type'] = 'POST';
        this.options['data'] = JSON.stringify(data);
        this.options['success'] = callback;
        this.options['error'] = errorCallback;
        $.ajax(this.options);
    };

    RestfulClient.prototype.config = function(opts) {
        this.options = $.extend(this.options, opts || {});
        return this;
    };

    global.RestfulClient = new RestfulClient();
    
})(window, jQuery);


if($.SF_WAPPERED_AJAX==null)
{
    $.SF_WAPPERED_AJAX=true;
    $.SF_ORIG_AJAX=$.ajax;
    var loadi ;
    
    $.ajax=function(origSettings)
    {
        if(origSettings.SF_REQ_PROXY==true)
        {
            origSettings.SF_SESSION_INVALIDATE=false;
            $.SF_ORIG_AJAX(origSettings);
            return ;
        }
        origSettings.cache=false;
        origSettings.SF_ORIG_beforeSend=origSettings.beforeSend;
        origSettings.SF_ORIG_dataFilter=origSettings.dataFilter;
        origSettings.SF_ORIG_success=origSettings.success;
        origSettings.SF_ORIG_error=origSettings.error;
        origSettings.SF_ORIG_complete=origSettings.complete;
        origSettings.SF_SESSION_INVALIDATE=false;
        origSettings.SF_REQ_PROXY=true;
        
        origSettings.beforeSend=function(XMLHttpRequest)
        {
            XMLHttpRequest.setRequestHeader("SF_AJAX", "true");
            if(origSettings.SF_ORIG_beforeSend!=null)
            {
                 origSettings.SF_ORIG_beforeSend(XMLHttpRequest);
            } 
        
            loadi = layer.load(1,0);
        };
        
        
        origSettings.dataFilter=function(data, type)
        { 
            if('SF_SESSION_INVALIDATE'==data)
            {
                 origSettings.SF_SESSION_INVALIDATE=true;
                 handSessionInvalidate(origSettings); 
            }
            else
            {
                if(data!=null)
                {
                      if(data.substring(0,48)=="<html><head><title>FA-FrameworkException</title>")
                      {
                          showErrorInfoWindow(data);
                          return ;
                      }
                }
                if(origSettings.SF_ORIG_dataFilter!=null)
                {
                     return origSettings.SF_ORIG_dataFilter(data, type);
                }
                else
                {
                     return data;
                }
            }
     
        };
        
         origSettings.success=function(data, textStatus)
         {
             if(origSettings.SF_SESSION_INVALIDATE==false)
            {
                 if(origSettings.SF_ORIG_success!=null)
                 {
                     origSettings.SF_ORIG_success(data, textStatus);
                 }
            }
         };
         
         origSettings.error=function(XMLHttpRequest, textStatus, errorThrown)
         {
                if(origSettings.SF_SESSION_INVALIDATE==false)
                {
                    if(origSettings.SF_ORIG_error!=null)
                    {
                        origSettings.SF_ORIG_error(XMLHttpRequest, textStatus, errorThrown);
                    }
                }
                
         };
         
         origSettings.complete=function(XMLHttpRequest, textStatus)
         {
        	    layer.close(loadi);
                if(origSettings.SF_SESSION_INVALIDATE==false)
                {
                    if(origSettings.SF_ORIG_complete!=null)
                    {
                        origSettings.SF_ORIG_complete(XMLHttpRequest, textStatus);
                    }
                }
                
         };
         
        
         $.SF_ORIG_AJAX(origSettings);
    };
    
};

function GetJSON(url, data, onSucess, onError) {
    $.ajax({
        type : 'GET',
        url : url,
        data : data,
        success : function(rtd) {
            if (onSucess != null) {
                onSucess(rtd);
            }
        },
        dataType : 'json',
        async : false,
        cache : false,
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            if (onError != null) {
                onError(errorThrown);
            }
        }
    });
}

function handSessionInvalidate(origSettings)
{
    GetJSON(
    'SsoGetSrvInfo.sso?format=json&callback=?',
    {},
    function(Response)
    {
        if(Response.returnObject.SF_LOGIN_MODE=='LOCAL')
        {
                 var rt= window.showModalDialog("SsoLogin.sso?SF_AJAX=Y" ,"UM","resizable:no;scroll:no;dialogWidth:900px;dialogHeight:550px");
                 if(rt!=null)
                 { 
                    try
                    {
                         var topWindow=getTopWindow();
                        if(topWindow.SF_CURRENT_USER!=null)
                        {
                            if(rt.SF_CURRENT_USER!=null)
                            {
                                if(rt.SF_CURRENT_USER!=topWindow.SF_CURRENT_USER)
                                {
                                    alert('当前浏览器页面的用户'+topWindow.SF_CURRENT_USER+'与会话的用户'+rt.SF_CURRENT_USER+'不同,点确定后跳转到会话用户页面');
                                    topWindow.location.reload();
                                    return ;
                                }
                            }
                        }
                    }
                    catch(e)
                    {
                    }
                   
                    $.ajax(origSettings);
                 }
        }
        else
        {
                handSsoLogin(origSettings,Response.returnObject);
        }
    },
    function(error)
    {
        alert('Session Invalidate');
    }
    );
}


function handSsoLogin(origSettings,BizSrvInfo)
{
    GetJSON(
     BizSrvInfo.SF_BIZ_SRV+"/SsoLogin.sso?format=json&callback=?",
    {
        SF_OP:'OP_AQUIRE_TOKEN_4_LOGIN'
    },
    function(Response)
    {
        GetJSON(
        BizSrvInfo.SF_SSO_SRV+"/Ajax.sso?format=json&callback=?",
        {
        SF_OP:'GetBizSrvLoginInfo',
        SF_SYSTEM_ID:Response.returnObject.SF_SYSTEM_ID,
        SF_BIZ_SRV:Response.returnObject.SF_BIZ_SRV,
        SF_TOKEN:Response.returnObject.SF_TOKEN
        },
        function(Response)
        {
            if(Response.status)
            {
                GetJSON(
                BizSrvInfo.SF_BIZ_SRV+"/SsoLogin.sso?format=json&callback=?",
                {
                    SF_OP:'OP_SET_LOGIN_INFO',
                    LOGIN_INFO:Response.returnObject
                },
                function(Response)
                {
                    if(Response.status)
                    {
                        var rt=Response.returnObject;
                        
                        try
                        {
                            var topWindow=getTopWindow();
                            if(topWindow.SF_CURRENT_USER!=null)
                            {
                                if(rt!=null)
                                {
                                    if(rt.SF_CURRENT_USER!=null)
                                    {
                                        if(rt.SF_CURRENT_USER!=topWindow.SF_CURRENT_USER)
                                        {
                                            alert('当前浏览器页面的用户'+topWindow.SF_CURRENT_USER+'与会话的用户'+rt.SF_CURRENT_USER+'不同,点确定后跳转到会话用户页面');
                                            topWindow.location.reload();
                                            return ;
                                        }
                                    }
                              
                                }
                            } 
                        }
                        catch(e)
                        {
                        }
                        
                        $.ajax(origSettings);
                    }
                    else
                    {
                        alert('When Recover Session Find Error:'+Response.message);
                    }
                },
                function(error)
                {
                    alert('Session Invalidate');
                }
                );
            }
            else
            {
                 var rt= window.showModalDialog(BizSrvInfo.SF_BIZ_SRV+"/SsoLogin.sso?SF_AJAX=Y" ,"UM","resizable:no;scroll:no;dialogWidth:900px;dialogHeight:550px");
                 if(rt!=null)
                 { 
                 
                    try
                    {
                         var topWindow=getTopWindow();
                        if(topWindow.SF_CURRENT_USER!=null)
                        {
                            if(rt.SF_CURRENT_USER!=null)
                            {
                                if(rt.SF_CURRENT_USER!=topWindow.SF_CURRENT_USER)
                                {
                                        alert('当前浏览器页面的用户'+topWindow.SF_CURRENT_USER+'与会话的用户'+rt.SF_CURRENT_USER+'不同,点确定后跳转到会话用户页面');
                                        topWindow.location.reload();
                                        return ;
                                }
                            }
                        }
                    }catch(e)
                    {
                    }
                   
                    $.ajax(origSettings);
                 }
            }
        },
        function(error)
        {
            alert('Session Invalidate');
        }
        );
    },
    function(error)
    {
        alert('Session Invalidate');
    }
    );
}


var newWindow;
function makeNewWindow() {
    //获得窗口的垂直位置
    var iTop = (window.screen.availHeight-550)/2;
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth-900-20)/2;
    newWindow = window.open ('', 'newWindow', 'height=550, width=900, top='+iTop+', left='+iLeft+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no');
}

function showErrorInfoWindow(str) {
    if (newWindow == null || newWindow == undefined || newWindow.closed) {
        makeNewWindow();
    }
    newWindow.document.write(str);
    newWindow.document.close();
}

function getTopWindow() {
    var tempWin = window;
    var lastWin = tempWin.parent;
    while ((lastWin != null) && (tempWin != lastWin)) {
        tempWin = lastWin;
        lastWin = tempWin.parent;
    }
    return tempWin;
}