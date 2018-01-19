<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- Meta Tags
        ========================== -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <meta name="author" content="feidi">
        <!-- Site Title
        ========================== -->
        <title>Security</title>

        <!-- Favicon
                ===========================-->
        <link rel="shortcut icon" type="image/x-icon" href="images/fav.png">


        <!-- Web Fonts
        ========================== -->
        <link href="https://fonts.googleapis.com/css?family=Titillium+Web:400,700" rel="stylesheet">         
        <!-- Base & Vendors
        ========================== -->
        <link href="<spring:url value="/css/bootstrap.css"/> " rel="stylesheet">
        <link href="<spring:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
        <!-- Site Style
        ========================== -->
        <link rel="stylesheet" href="<spring:url value="/css/style.css"/>">

        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <ul class="header">
            <li class="active">
                <a href="#content"  role="tab" data-toggle="tab">
                    Logo
                </a>
            </li>
            <li>
                <a href="#fair"  role="tab" data-toggle="tab">
                    <i class="fa fa-long-arrow-right"></i>
                    play fair
                </a>
            </li>
            <li>
                <a href="#hell"  role="tab" data-toggle="tab">
                    <i class="fa fa-long-arrow-right"></i>
                    hell cipher
                </a>
            </li>
            <li>
                <a href="#combination"  role="tab" data-toggle="tab">
                    <i class="fa fa-long-arrow-right"></i>
                    combination 
                </a>
            </li>
        </ul>

        <div class="tab-content move active">
            <i class="fa fa-bars"></i>
            <div role="tabpanel" class="tab-pane fade " id="content">
                11111111
            </div> <!-- End content -->

            <jsp:include page="pages/playFair.jsp"></jsp:include>

            <jsp:include page="pages/hellCipher.jsp" ></jsp:include>

            <jsp:include page="pages/combination.jsp" ></jsp:include>

            <div align=center>

            </div>

            </div> <!-- End tab-content -->

            <script src="<spring:url value="/js/jquery.js"/>"></script>
        <script src="<spring:url value="/js/bootstrap.js"/>"></script>
        <script src="<spring:url value="/js/main.js"/>"></script>
        <script src="<spring:url value="/js/ajax.js"/>"></script>

    </body>
</html>