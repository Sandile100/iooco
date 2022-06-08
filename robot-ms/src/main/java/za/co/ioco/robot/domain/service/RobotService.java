package za.co.ioco.robot.domain.service;

import za.co.ioco.robot.domain.model.Category;
import za.co.ioco.robot.domain.model.Robot;
import za.co.ioco.robot.exeption.ResourceNotFoundException;
import za.co.ioco.robot.infrastructure.robot.model.RobotValueObject;
import za.co.ioco.robot.infrastructure.robot.service.RobotWebService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RobotService
{
  final RobotWebService robotService;

  public RobotService(RobotWebService robotService)
  {
    this.robotService = robotService;
  }

  public List<Robot> getAllRobots()
  {
    List<RobotValueObject> robotValueObjects = robotService.getAllRobots();
    return convertRobot(robotValueObjects, mapRobot);
  }

  public List<Robot> getRobotByCategory(final String category)
  {
    List<RobotValueObject> robotValueObjects = robotService.getAllRobots()
            .stream().filter(e -> e.getCategory().equals(category)).collect(Collectors.toList());
    return convertRobot(robotValueObjects, mapRobot);
  }

  public Robot getRobotBySerialNumber(final String serialNumber)
  {
    RobotValueObject robotValueObject = robotService.getAllRobots()
            .stream()
            .filter(e -> e.getSerialNumber().equals(serialNumber))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException(String.format("Robot with %s serial number was not found", serialNumber)));
    return mapRobot.apply(robotValueObject);
  }

  public Function<RobotValueObject, Robot> mapRobot = robotValueObject -> {
    Robot robot = new Robot();
    robot.setModel(robotValueObject.getModel());
    robot.setSerialNumber(robotValueObject.getSerialNumber());
    robot.setManufacturedDate(robotValueObject.getManufacturedDate());
    robot.setCategory(Category.of(robotValueObject.getCategory()));
    return robot;
  };

  public <T, R> List<R> convertRobot(List<T> list, Function<T, R> function)
  {
    List<R> robots = new ArrayList<>();
    for (T t : list)
    {
      robots.add(function.apply(t));
    }

    return robots;
  }
}
