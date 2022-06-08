package za.co.ioco.survivor.domain.service;

import za.co.ioco.survivor.domain.model.Location;
import za.co.ioco.survivor.domain.model.Survivor;
import za.co.ioco.survivor.exception.ResourceNotFoundException;
import za.co.ioco.survivor.infrastructure.geolocation.GeoLocationService;
import za.co.ioco.survivor.infrastructure.repository.SurvivorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurvivorService
{
  final SurvivorRepository survivorRepository;
  final GeoLocationService geoLocationService;

  @Autowired
  public SurvivorService(SurvivorRepository survivorRepository, GeoLocationService geoLocationService)
  {
    this.survivorRepository = survivorRepository;
    this.geoLocationService = geoLocationService;
  }

  public Survivor createSurvivor(final Survivor survivor)
  {
    Location location = survivor.getLocation();
    Location _location = validateLocation(location).orElseThrow(() -> new ResourceNotFoundException("Invalid location supplied"));
    survivor.setLocation(_location);
    return survivorRepository.save(survivor);
  }

  public Optional<Survivor> getSurvivorById(final long id)
  {
   return survivorRepository.findById(id);
  }

  public Survivor updateSurvivorLocation(final Survivor survivor, final Location location)
  {
    survivor.setLocation(location);
    return survivorRepository.save(survivor);
  }

  public Optional<Location> validateLocation(final Location location)
  {
   return geoLocationService.validateLocation(location);
  }
}
