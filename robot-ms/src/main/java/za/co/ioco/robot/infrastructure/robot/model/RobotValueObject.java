package za.co.ioco.robot.infrastructure.robot.model;

import java.io.Serializable;

public class RobotValueObject implements Serializable
{
  private String model;
  private String serialNumber;
  private String manufacturedDate;
  private String category;

  public String getModel()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public String getSerialNumber()
  {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber)
  {
    this.serialNumber = serialNumber;
  }

  public String getManufacturedDate()
  {
    return manufacturedDate;
  }

  public void setManufacturedDate(String manufacturedDate)
  {
    this.manufacturedDate = manufacturedDate;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String category)
  {
    this.category = category;
  }
}
