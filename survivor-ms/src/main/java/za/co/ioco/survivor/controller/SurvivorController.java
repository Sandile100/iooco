package za.co.ioco.survivor.controller;

import za.co.ioco.survivor.domain.model.Location;
import za.co.ioco.survivor.domain.model.Survivor;
import za.co.ioco.survivor.domain.service.SurvivorService;
import za.co.ioco.survivor.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurvivorController
{
  final
  SurvivorService survivorService;

  public SurvivorController(SurvivorService survivorService)
  {
    this.survivorService = survivorService;
  }

  @GetMapping("/survivors/{id}")
  public ResponseEntity<Survivor> getSurvivorById(@PathVariable("id") long id) {
    Survivor survivor = survivorService.getSurvivorById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Survivor with id : %s was not found", id)));
    return new ResponseEntity<>(survivor, HttpStatus.OK);
  }

  @PostMapping("/survivors")
  public ResponseEntity<Survivor> createSurvivor(@RequestBody Survivor survivor) {
    return new ResponseEntity<>(survivorService.createSurvivor(survivor), HttpStatus.CREATED);
  }

  @PutMapping("/survivors/{id}")
  public ResponseEntity<Survivor> updateSurvivorLocation(@PathVariable("id") long id, @RequestBody Location location) {
    Location _location = survivorService.validateLocation(location).orElseThrow(() -> new ResourceNotFoundException("Invalid location supplied"));
    Survivor survivor = survivorService.getSurvivorById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Survivor with id : %s was not found", id)));
    return new ResponseEntity<>(survivorService.updateSurvivorLocation(survivor,_location), HttpStatus.OK);
  }
}
