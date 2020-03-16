<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Znalazłem zgubę!</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">
</head>
<body>
<div class="topnav">
    <form id="searchForm">
        <input id="searchBox" type="search" placeholder="Zgubiony przedmiot">
    </form>
    <a id="login">Zaloguj się</a>
</div>
<div id="map"></div>
<div id="myModal" class="modal">
    <div class="modal-content">
        <form:form id="markerForm" modelAttribute="markerForm" action="/znalazlemzgube/" method="post">
            <form:input type="hidden" path="geolocationLatitude"/>
            <form:input type="hidden" path="geolocationLongitude"/>
            <p>
                <form:input type="text" placeholder="Twoje imię" minlength="3" path="finderName"/>
                <c:if test="${pageContext.request.method=='POST'}"><form:errors path="finderName"/></c:if>
            </p>
            <p>
                <form:input type="email" placeholder="Twój email" path="finderEmail"/>
                <c:if test="${pageContext.request.method=='POST'}"><form:errors path="finderEmail"/></c:if>
            </p>
            <p>
                <form:input type="text" placeholder="Data znalezienia zguby" path="date"/>
                <c:if test="${pageContext.request.method=='POST'}"><form:errors path="date"/></c:if>
            </p>
            <p>
                <form:input type="text" placeholder="Opis przedmiotu" maxlength="100" path="foundObjectDescription"/>
                <c:if test="${pageContext.request.method=='POST'}"><form:errors path="foundObjectDescription"/></c:if>
            </p>
            <%-- Bootstrap Datepicker!--%>
            <p><input type="submit" value="Zapisz!"/></p>
        </form:form>
        <span class="close">Anuluj</span>
    </div>
</div>

<script>
    var map;
    var modal = document.getElementById("myModal");
    var spanToCloseModal = document.getElementsByClassName("close")[0];

    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 51.9537505, lng: 19.1343786},
            zoom: 6,
            fullscreenControl: false
        });

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                map.setCenter(pos);
                map.setZoom(12);
            });
        } else {
            map.getCenter();
        }

        var markers = addStoredMarkers();
        addNewMarker();
        findMarkersBySearchTerm(markers);

    }

    function addStoredMarkers() {
        var markers = [];
        $.getJSON("http://localhost:8080/znalazlemzgube/markers/json", function (markerList) {
            for (var i = 0; i < markerList.length; i++) {
                var marker = new google.maps.Marker({
                    position: {
                        lat: markerList[i].geolocationLatitude,
                        lng: markerList[i].geolocationLongitude
                    },
                    finderEmail: markerList[i].finderEmail,
                    finderName: markerList[i].finderName,
                    foundObjectDescription: markerList[i].foundObjectDescription,
                    map: map
                });
                addInfoWindow(marker);
                markers.push(marker);
            }
        });
        return markers;
    }

    function addInfoWindow(marker) {
        marker.infowindow = new google.maps.InfoWindow({
            content: marker.foundObjectDescription
        });
        google.maps.event.addListener(marker, 'click', function () {
            marker.infowindow.open(map, marker);
        });
    }

    function addNewMarker() {
        google.maps.event.addListener(map, 'rightclick', function (event) {
            var marker = createMarker(event.latLng, map);
            assignCoordsToMarkerForm(marker);
            openMarkerForm(marker);

        });
    }

    function createMarker(location, map) {
        return new google.maps.Marker({
            position: location,
            map: map
        });
    }

    function assignCoordsToMarkerForm(marker) {
        var markerFormObj = document.forms["markerForm"];
        markerFormObj.elements["geolocationLatitude"].value = marker.getPosition().lat();
        markerFormObj.elements["geolocationLongitude"].value = marker.getPosition().lng();
    }

    function openMarkerForm(marker) {
        modal.style.display = "block";
        spanToCloseModal.onclick = function () {
            modal.style.display = "none";
            marker.setMap(null);
        }
    }

    function findMarkersBySearchTerm(markers) {
        document.getElementById("searchForm").addEventListener('submit', function (evt) {
            var searchTerm = document.getElementById("searchBox").value;
            markers.forEach(function (marker) {
                if (marker.foundObjectDescription.toLowerCase().includes(searchTerm.toLowerCase())) {
                    marker.infowindow.open(map, marker);
                } else {
                    marker.infowindow.close();
                }
            });
            evt.preventDefault();
        });
    }

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABXzfkub1L3C_HWAeDD5LVQDyV_SvesJM&callback=initMap"
        async defer></script>
</body>
</html>
