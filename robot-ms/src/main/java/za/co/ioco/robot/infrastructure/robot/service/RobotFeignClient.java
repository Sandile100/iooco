package za.co.ioco.robot.infrastructure.robot.service;

import za.co.ioco.robot.infrastructure.robot.model.RobotValueObject;

import feign.FeignException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "robotFeignClient", url = "${robot.client.baseUrl}")
public interface RobotFeignClient
{
  @GetMapping("/robotcpu")
  List<RobotValueObject> getAllRobots() throws FeignException;
}
