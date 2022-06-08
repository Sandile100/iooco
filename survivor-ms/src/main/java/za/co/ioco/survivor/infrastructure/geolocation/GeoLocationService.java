package za.co.ioco.survivor.infrastructure.geolocation;

import za.co.ioco.survivor.domain.model.Location;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeoLocationService
{
  @Value("${services.geolocation.api.key}")
  private String API_KEY;


  public Optional<Location> validateLocation(Location location)
  {
    Optional<Location> locationOptional = Optional.empty();
    String address = location.getAddress();

    if (location.getLatitude() != 0 && location.getLongitude() != 0 || location.getLatitude() != null && location.getLongitude() != 0)
    {
      locationOptional = Optional.of(getLocationFromCoordinates(location.getLatitude(), location.getLongitude()));
    }
    if (!address.isEmpty() && !locationOptional.isPresent())
    {
      locationOptional = Optional.of(getLocationFromAddress(location.getAddress()));
    }
    return locationOptional;
  }

  private Location getLocationFromCoordinates(final Double latitude, final Double longitude)
  {
    JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(API_KEY);
    Location validatedLocation = new Location();
    JOpenCageReverseRequest request = new JOpenCageReverseRequest(latitude, longitude);
    request.setLanguage("es");
    request.setNoDedupe(true);
    request.setLimit(5);
    request.setNoAnnotations(true);
    request.setMinConfidence(4);

    JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
    String formattedAddress = response.getResults().get(0).getFormatted();

    validatedLocation.setLatitude(latitude);
    validatedLocation.setLongitude(longitude);
    validatedLocation.setAddress(formattedAddress);

    return validatedLocation;
  }

  private Location getLocationFromAddress(final String address)
  {
    JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(API_KEY);
    Location validatedLocation = new Location();
    JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
    JOpenCageResponse response = jOpenCageGeocoder.forward(request);
    JOpenCageLatLng firstResultLatLng = response.getFirstPosition();

    validatedLocation.setLatitude(firstResultLatLng.getLat());
    validatedLocation.setLongitude(firstResultLatLng.getLng());
    validatedLocation.setAddress(address);

    return validatedLocation;
  }
}
