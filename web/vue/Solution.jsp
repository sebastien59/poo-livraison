<%-- 
    Document   : controller
    Created on : 6 avr. 2017, 10:51:57
    Author     : vincent
--%>

<jsp:include page="../header.jsp"/>
<div id="map"></div>
<script>
    var map;
    function initMap() {
      map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 8
      });
    }
    
    initMap();
</script>


<jsp:include page="../footer.jsp"/>
