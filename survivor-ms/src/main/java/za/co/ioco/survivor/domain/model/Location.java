package za.co.ioco.survivor.domain.model;

import java.io.Serializable;

public class Location implements Serializable
{
 private Double latitude;
 private Double longitude;
 private String address;

 public Double getLatitude()
 {
  return latitude;
 }

 public void setLatitude(Double latitude)
 {
  this.latitude = latitude;
 }

 public Double getLongitude()
 {
  return longitude;
 }

 public void setLongitude(Double longitude)
 {
  this.longitude = longitude;
 }

 public String getAddress()
 {
  return address;
 }

 public void setAddress(String address)
 {
  this.address = address;
 }
}
