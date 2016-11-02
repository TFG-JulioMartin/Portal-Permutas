<html>
  <head>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<!-- 1. Load libraries -->
     <!-- Polyfill(s) for older browsers -->
    <script src="node_modules/core-js/client/shim.min.js"></script>
    <script src="node_modules/zone.js/dist/zone.js"></script>
    <script src="node_modules/reflect-metadata/Reflect.js"></script>
    <script src="node_modules/systemjs/dist/system.src.js"></script>
    <!-- 2. Configure SystemJS -->
    <script src="systemjs.config.js"></script>
    <script>
      System.import('app').catch(function(err){ console.error(err); });
    </script>
    
    <script type="text/javascript">
		var theJsonString = '<c:out value="${json}" />';
		var theJsonObj = JSON.parse(theJsonString);
	</script>
	
	
	<script
    src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
var map;
var geocoder;
var address = "Escuela Técnica Superior de Ingeniería Informática, Universidad de Sevilla, 41012 Sevilla";
function initialize() {
  geocoder = new google.maps.Geocoder();
  var mapOptions = {
    zoom: 16,
    center: new google.maps.LatLng(37.3824, -5.9965)
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  
  if (geocoder) {
	    geocoder.geocode({
	      'address': address
	    }, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {
	        if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
	          map.setCenter(results[0].geometry.location);
	          var infowindow = new google.maps.InfoWindow({
	            content: '<b>' + address + '</b>',
	            size: new google.maps.Size(150, 50)
	          });
	          var marker = new google.maps.Marker({
	            position: results[0].geometry.location,
	            map: map,
	            title: address
	          });
	          google.maps.event.addListener(marker, 'click', function() {
	            infowindow.open(map, marker);
	          });
	        } else {
	          alert("No results found");
	        }
	      } else {
	        alert("Geocode was not successful for the following reason: " + status);
	      }
	    });
	  }
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
	
	
  </head>
  
 <!-- 3. Display the application -->
  <body>
   
    <my-app>Loading...</my-app>
    
    <p><spring:message code="welcome.greeting.current.time" /> ${moment}</p>
    
    <div id="map-canvas" style="height:300px; width:500px"></div>

	<script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0Bx2IH546c7E3E5mqtSwQq8z-inqpWts&callback=initMap">
    </script>
    
    
    
       
  </body>
</html> 
