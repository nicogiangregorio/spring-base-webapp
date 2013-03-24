<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Home</title>
        <style type="text/css">
	      html { height: 100% }
	      body { height: 100%; margin: 0; padding: 0 }
	      #map-canvas { height: 100% }
	    </style>
		<script src='/spring-base-webapp/dwr/engine.js'></script>
        <script src='/spring-base-webapp/dwr/interface/CitizenServiceDwr.js'></script>
        <script type="text/javascript" 
        	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbSCjuMfECjoa5q3TGzPPXDYg7A0GxNEQ&sensor=false"></script>
		<script type="text/javascript">
		window.onload = function() {
			CitizenServiceDwr.getCitizenLocations();
			
		};
		function initialize() {
	        var mapOptions = {
	          center: new google.maps.LatLng(-34.397, 150.644),
	          zoom: 8,
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        };
	        var map = new google.maps.Map(document.getElementById("map-canvas"),
	            mapOptions);
	      }
	      google.maps.event.addDomListener(window, 'load', initialize);
		</script>
    </head>
    <body>
        <div id="map-canvas"></div>
    </body>
</html>
