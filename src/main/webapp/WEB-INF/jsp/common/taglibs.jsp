<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>  

<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<fmt:setLocale value="${header['accept-language']}"/>
<fmt:setBundle basename="i18n/messages"/>
<script type="text/javascript">
  //for global use
  var contextRootPath = "${ctx}";
</script>
