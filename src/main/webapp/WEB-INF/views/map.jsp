<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Znalazłem zgubę!</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 100%;
        }
        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div id="map"></div>
<script>
    var map;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 51.9537505, lng: 19.1343786},
            zoom: 6
        });

        google.maps.event.addListener(map, 'click', function(event) {
            addMarker(event.latLng, map);
        });

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                map.setCenter(pos);
                map.setZoom(10);
            });
        } else {
            map.getCenter();
        }
    }

    function addMarker(location, map) {
        var marker = new google.maps.Marker({
            position: location,
            // label:
            map: map
        });
    }

</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABXzfkub1L3C_HWAeDD5LVQDyV_SvesJM&callback=initMap"
        async defer></script>
</body>
</html>
