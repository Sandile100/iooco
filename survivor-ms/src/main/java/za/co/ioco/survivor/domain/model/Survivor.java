package za.co.ioco.survivor.domain.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "survivor")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Survivor
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "age")
  private int age;
  @Type(type = "json")
  @Column(name = "location", columnDefinition = "json")
  private Location location;
  @Enumerated(EnumType.ORDINAL)
  @Column(name = "status")
  private Status status;
  @Type(type = "json")
  @Column(name = "resources", columnDefinition = "json")
  private List<Resource> resourceList;

  public Survivor()
  {
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public Location getLocation()
  {
    return location;
  }

  public void setLocation(Location location)
  {
    this.location = location;
  }

  public Status getStatus()
  {
    return status;
  }

  public void setStatus(Status status)
  {
    this.status = status;
  }

  public List<Resource> getResourceList()
  {
    return resourceList;
  }

  public void setResourceList(List<Resource> resourceList)
  {
    this.resourceList = resourceList;
  }
}
