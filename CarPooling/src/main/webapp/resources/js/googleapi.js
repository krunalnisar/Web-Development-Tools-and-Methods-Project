function initialize() {
        var address = (document.getElementById('sourceid'));
         var address1 = (document.getElementById('destid'));
        var autocomplete = new google.maps.places.Autocomplete(address);
       var autocomplete1 = new google.maps.places.Autocomplete(address1);
        autocomplete.setTypes(['geocode']);
        google.maps.event.addListener(autocomplete, 'place_changed', function() {
            var place = autocomplete.getPlace();
            if (!place.geometry) {
                return;
            }
         autocomplete1.setTypes(['geocode']);
        google.maps.event.addListener(autocomplete1, 'place_changed', function() {
            var place = autocomplete1.getPlace();
            if (!place.geometry) {
                return;
            }
        var address = '';
        if (place.address_components) {
            address = [
                (place.address_components[0] && place.address_components[0].short_name || ''),
                (place.address_components[1] && place.address_components[1].short_name || ''),
                (place.address_components[2] && place.address_components[2].short_name || '')
                ].join(' ');
	
        }
		
		
      });
    var address1 = '';
        if (place.address_components) {
            address1 = [
                (place.address_components[0] && place.address_components[0].short_name || ''),
                (place.address_components[1] && place.address_components[1].short_name || ''),
                (place.address_components[2] && place.address_components[2].short_name || '')
                ].join(' ');
        }
      });
}
 
 google.maps.event.addDomListener(window, 'load', initialize);
 
 
function codeAddress() {
    geocoder = new google.maps.Geocoder();
    var address = document.getElementById("sourceid").value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
         fromlat = parseFloat(results[0].geometry.location.lat());
         fromlong = parseFloat(results[0].geometry.location.lng());
         document.getElementById("slat").setAttribute("value",fromlat);
         document.getElementById("slong").setAttribute("value",fromlong);
		 
}
      else {
        alert("Geocode was not successful for the following reason1: " + status);
      }
    });
  }
function codeAddress1() {
    geocoder = new google.maps.Geocoder();
    var address = document.getElementById("destid").value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
          tolat =parseFloat(results[0].geometry.location.lat());
         tolong =parseFloat(results[0].geometry.location.lng());
         document.getElementById("dlat").setAttribute("value",tolat);
         document.getElementById("dlong").setAttribute("value",tolong);
         
         
      } 
      else {
        alert("Geocode was not successful for the following reason2: " + status);
      }
    });
  }