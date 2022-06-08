package za.co.ioco.robot.domain.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Category
{
  LAND("Land"),
  FLYING("Flying");

  private static final Map<String, Category> CATEGORY_MAP = new HashMap<>();
  static
  {
    for (Category category : EnumSet.allOf(Category.class))
    {
      CATEGORY_MAP.put(category.description, category);
    }
  }

  private String description;

  Category(String description)
  {
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }
  public static Category of(String description)
  {
    return CATEGORY_MAP.get(description);
  }
}
