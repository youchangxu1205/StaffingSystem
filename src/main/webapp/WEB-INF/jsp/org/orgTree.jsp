<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    <jsp:include page="/resources/inc/footer.jsp" flush="true"/>
    <script>
        var setting = {
            async:{
                enable:true,
                url:'${bastPath}/org/orgTree?orgId=1'
            },
            data: {
                key: {
                    title:"t"
                },

                simpleData: {
                    enable: true
                }
            }
        };
        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting);
        });

    </script>
</head>
<body>
    <ul id="treeDemo" class="ztree"></ul>
</body>
</html>
