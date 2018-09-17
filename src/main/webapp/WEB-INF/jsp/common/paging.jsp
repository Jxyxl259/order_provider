<%@ page language="java" pageEncoding="UTF-8"%>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style> <!-- 未国际化，待修改 -->
  <div>
		 <input type="hidden" id="totalPage_input"/> 
				   
               <ul>  
                    <li><a href="javascript:doNavigate('first');" id="firstPage">首页</a> 
				       <a href="javascript:doNavigate('pre')" id="prePage">上一页</a> 
				       <a href="javascript:doNavigate('next')" id="nextPage">下一页</a> 
				       <a href="javascript:doNavigate('last')" id="lastPage">末页</a> 
				      &nbsp;第<lable id="currentPage"></lable>&nbsp;页  /&nbsp;共<lable id="totalPage"></lable>&nbsp;页 
				      &nbsp; 共<lable id="totalRows"></lable>&nbsp;条记录  
				  </ul>
	    
 </div>
 
<script type="text/javascript">
var currentPage = 1  ; 
var pageSize = 20 ; //初始化
var totalSize ;
var totalPage ;
function doNavigate(command)
    { 
    	 //首页
    	 if (command == "first"){
    		  currentPage=1;
    		  queryByPage(); 
    	 }else if (command =="pre"){
        	  if(currentPage==1){
 	            alert("已经到达第一页");
 	            return ;
 	          }else{
 	            currentPage--; 
 	            queryByPage(); 
 	          }
         }
    	 else if (command =="next"){
    		 if(currentPage==$("#totalPage_input").val()){
    	            alert("已经到达最后一页");
    	            return ;
    	          }else{ 
    	            currentPage++;
    	            queryByPage(); 
    	          }

    	 }else if (command ="last"){
             currentPage=$("#totalPage_input").val(); 
         	 queryByPage();  
    	 }
     }
 </script>