<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>  

<%
if(request.getContextPath().endsWith("/"))
{
	request.setAttribute("ctx",request.getContextPath());
	   
}
else
{
	request.setAttribute("ctx",request.getContextPath()+"/");
}
%>