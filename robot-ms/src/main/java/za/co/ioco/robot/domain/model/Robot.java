package za.co.ioco.robot.domain.model;

public class Robot
{
  private String model;
  private String serialNumber;
  private String manufacturedDate;
  private Category category;

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

  public Category getCategory()
  {
    return category;
  }

  public void setCategory(Category category)
  {
    this.category = category;
  }
}
