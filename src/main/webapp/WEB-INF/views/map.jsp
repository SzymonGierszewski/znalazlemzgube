<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Znalazłem zgubę!</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">
</head>
<body>
<div id="map"></div>
<script>
    var map;

    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 51.9537505, lng: 19.1343786},
            zoom: 6,
            fullscreenControl: false
        });

        google.maps.event.addListener(map, 'rightclick', function (event) {
            addMarker(event.latLng, map);
        });

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
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
