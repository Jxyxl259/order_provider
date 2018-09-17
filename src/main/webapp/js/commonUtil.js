/**
 * 统计字符串长度
 * @param str
 * @returns {Number}
 */
function strlen(str){
    var len = 0;
    for (var i=0; i<str.length; i++) { 
	     var c = str.charCodeAt(i); 
	     //单字节加1 
	     if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) { 
	    	 len++; 
	     } else { 
	    	 len+=2; 
	     } 
    } 
    return len;
}

// eg:options={url:'login',name:'登录',tabId:'0000',className:'fa fa-key fa-fw'}
function openTab(options){
    window.parent.multiIframeTabs.open(options);
}
//关闭tab页
function closeTab(tabId){
    window.parent.multiIframeTabs.close(tabId);
}
