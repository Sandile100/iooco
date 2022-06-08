package za.co.ioco.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RobotMsApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(RobotMsApplication.class, args);
  }

}
