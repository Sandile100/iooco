package za.co.ioco.robot.controller;

import za.co.ioco.robot.domain.model.Category;
import za.co.ioco.robot.domain.model.Robot;
import za.co.ioco.robot.domain.service.RobotService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RobotController
{

  final RobotService robotService;

  public RobotController(RobotService robotService)
  {
    this.robotService = robotService;
  }

  @GetMapping("/robots")
  public ResponseEntity<List<Robot>> getAllRobots(){
    return new ResponseEntity<>(robotService.getAllRobots(), HttpStatus.OK);
  }

  @GetMapping("/robots/robot/{serialNumber}")
  public ResponseEntity<Robot> getRobotBySerialNumber(@PathVariable String serialNumber){
    return new ResponseEntity<>(robotService.getRobotBySerialNumber(serialNumber), HttpStatus.OK);
  }

  @GetMapping("/robots/{category}")
  public ResponseEntity<List<Robot>> getRobotByCategory(@PathVariable String category){
    return new ResponseEntity<>(robotService.getRobotByCategory(category), HttpStatus.OK);
  }

}
