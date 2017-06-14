<%-- 
    Document   : Header.jsp
    Created on : 6 juin 2017, 10:58:08
    Author     : Vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Swap Location Project</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2y0e-JdpOMMgJkwiN16jZExQ2fINrq2E&sencor=false"></script>
	<script src="../lib/angular.min.js"></script>
	<script src="../lib/angular-route.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../css/myStyle.css">
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <Link rel="stylesheet" type="text/css" href="./css/myStyle.css">
        
        <script>
            var data = [{
                          "longEvent": "8.42227",
                          "lattEvent": "49.45044"
                        },
                        {
                          "longEvent": "7.59357",
                          "lattEvent": "49.79115"
                        },
                        {
                          "longEvent": "8.41184",
                          "lattEvent": "49.01208"
                        },
                        {
                          "longEvent": "8.45037",
                          "lattEvent": "49.50463"
                        },
                        {
                          "longEvent": "8.42227",
                          "lattEvent": "49.45044"
                        }
                        
                    ];
            
            function initialize() {
                var request = {
	  	  		travelMode: google.maps.TravelMode.WALKING
	  		};
                var marker;
                var map;
                var directionsService = new google.maps.DirectionsService;
                var directionsDisplay = new google.maps.DirectionsRenderer;
                var mapOptions = {
                  zoom: 8,
                  center: new google.maps.LatLng(48.844471, 2.346896)
                };
                map = new google.maps.Map(document.getElementById('map'),
                  mapOptions);
                directionsDisplay.setMap(map);
                 
                angular.forEach(data, function(val,i){
                    marker = new google.maps.Marker({
	      		position: new google.maps.LatLng(val.lattEvent, val.longEvent),
                    });
                    console.log(val);
                    if (i == 0){
                        request.origin = marker.getPosition();
                    }else if (i == data.length - 1) {
                        request.destination = marker.getPosition();
                    }else{
                        if (!request.waypoints) request.waypoints = [];
                        request.waypoints.push({
                                location: marker.getPosition(),
                                stopover: true
                             });
                    }
                });
                directionsService.route(request, function(result, status) {
                    if (status == google.maps.DirectionsStatus.OK) {
                        directionsDisplay.setDirections(result);
                    }
                });
            };
                 
            //google.maps.event.addDomListener(window, 'onload', initialize);
        </script>
    </head>
       
    <body onload="initialize()">
    
        <nav class="navbar navbar-default">
            <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header navbar-brand">
                    Best Solution
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="http://localhost:8080/poo-livraison/">Home</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>