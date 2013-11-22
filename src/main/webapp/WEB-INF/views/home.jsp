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
        <script src='static/js/jquery-1.9.1.min.js'></script>
        <script type="text/javascript" src='https://maps.googleapis.com/maps/api/js?key=AIzaSyBbSCjuMfECjoa5q3TGzPPXDYg7A0GxNEQ&sensor=false'></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
			initialize();
			$("#header").load("header");
			//CitizenServiceDwr.getCitizenLocations(dwrCallback);
		});
		
		function dwrCallback(data) {
			for (var ii = 0, len = data.length; ii < len; ii++ ) {
				MARKER_UTIL.setMarker(data[ii]);
			}
		}
		function initialize() {
	        var mapOptions = {
	          center: new google.maps.LatLng(41.9, 12.483333),
	          zoom: 6,
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        };
	        map = new google.maps.Map(document.getElementById("map-canvas"),mapOptions);
	      }
		
		var MARKER_UTIL = function () {
			return {
				setMarker: function(singleLocation) {
					var marker = new google.maps.Marker({
					    position: new google.maps.LatLng(singleLocation.latitude, singleLocation.longitude),
					    map: map,
					});
					var infowindow = new google.maps.InfoWindow({
					    content: '<p><b>Name:</b> ' + singleLocation.name + '</p>'
					    	+	 '<p><b>Last name:</b> ' + singleLocation.surname + '</p>'
					    	+	 '<p><b>Region:</b> ' + singleLocation.dscRegione + '</p>'
					    	+	 '<p><b>city:</b> ' + singleLocation.dscCity + '</p>'
					});
					google.maps.event.addListener(marker, 'mouseover', function() {
						infowindow.open(map,marker);
					});
					google.maps.event.addListener(marker, 'mouseout', function() {
						infowindow.close(map,marker);
					});
				}				
			};
		}();
		
		</script>
    </head>
    <body>
    	<div id="header"></div>
        <div id="map-canvas" class=row-fluid></div>
    </body>
</html>
