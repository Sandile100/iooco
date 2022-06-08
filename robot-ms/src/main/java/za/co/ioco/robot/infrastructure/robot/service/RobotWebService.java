package za.co.ioco.robot.infrastructure.robot.service;

import za.co.ioco.robot.infrastructure.robot.model.RobotValueObject;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames={"robotCache"})
public class RobotWebService
{
  final RobotFeignClient robotFeignClient;

  public RobotWebService(RobotFeignClient robotFeignClient)
  {
    this.robotFeignClient = robotFeignClient;
  }

  @Cacheable(value = "robotCache")
  public List<RobotValueObject> getAllRobots(){
    return robotFeignClient.getAllRobots();
  }

}
