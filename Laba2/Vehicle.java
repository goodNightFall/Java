package Laba2;

public class Vehicle {
  protected String brand;
  protected String model;
  protected Integer maxWeight;
  protected Integer numberOfPassengers;
  protected Integer maxSpeed;
  protected Trailer trailer;

  public Vehicle(String brand, String model, Integer maxWeight,  Integer numberOfPassengers, Integer maxSpeed, Trailer trailer) {
    this.brand = brand;
    this.model = model;
    this.maxWeight = maxWeight;
    this.numberOfPassengers = numberOfPassengers;
    this.maxSpeed = maxSpeed - 20;
    this.trailer = trailer;
  }

  public String getBrand() {
    return this.brand;
  }

  public String getModel() {
    return this.model;
  }

  public Integer getMaxWeight() {
    return this.maxWeight;
  }

  public Integer getNumberOfPassengers() {
    return this.numberOfPassengers;
  }

  public Integer getMaxSpeed() {
    return this.maxSpeed;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setMaxWeight(Integer maxWeight) {
    this.maxWeight = maxWeight;
  }

  public void setNumberOfPassengers(Integer numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }

  public void setMaxSpeed(Integer maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  @Override
  public String toString() {
    if(trailer == null){
      return "Brand: " + this.brand + " Model: " + this.model + " MaxWeight: " +  Integer.toString(this.maxWeight) + 
      " NumberOfPassengers: " + Integer.toString(this.numberOfPassengers) + " MaxSpeed: " + Integer.toString(this.maxSpeed);
    } else {
        return "Brand: " + this.brand + " Model: " + this.model + " MaxWeight: " +  Integer.toString(this.maxWeight) + 
        " NumberOfPassengers: " + Integer.toString(this.numberOfPassengers) + " MaxSpeed: " + Integer.toString(this.maxSpeed) +
        " Trailer: " + trailer.toString();
    }
  }
}