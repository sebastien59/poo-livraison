<%-- 
    Document   : controller
    Created on : 6 avr. 2017, 10:51:57
    Author     : vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" http-equiv="Content-Type" content="initial-scale=1.0, user-scalable=no">
        <title>Best Solutions</title>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2y0e-JdpOMMgJkwiN16jZExQ2fINrq2E&sencor=false"></script>
        <script> var map;
            function initialize() {
              var mapOptions = {
                zoom: 8,
                center: new google.maps.LatLng(48.844471, 2.346896)
              };
              map = new google.maps.Map(document.getElementById('map'),
                  mapOptions);
            }

            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body onload="initialize()">
        <jsp:include page="../header.jsp"/>
        <div id="map"></div>      
        <jsp:include page="../footer.jsp"/>
    </body>
    
        
    
</html>
