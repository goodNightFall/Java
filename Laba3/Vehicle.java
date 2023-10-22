package Laba3;

public class Vehicle {
  protected Integer id;
  protected String brand;
  protected String model;
  protected Integer maxWeight;
  protected Integer numberOfPassengers;
  protected Integer maxSpeed;
  protected Trailer trailer;

  public Vehicle(Integer id, String brand, String model, Integer maxWeight, Integer numberOfPassengers,
      Integer maxSpeed,
      Trailer trailer) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.maxWeight = maxWeight;
    this.numberOfPassengers = numberOfPassengers;
    this.maxSpeed = maxSpeed - 20;
    this.trailer = trailer;
  }

  public Vehicle(Integer id, String brand, String model, Integer maxWeight, Integer numberOfPassengers,
      Integer maxSpeed) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.maxWeight = maxWeight;
    this.numberOfPassengers = numberOfPassengers;
    this.maxSpeed = maxSpeed;
  }

  public Integer getId() {
    return this.id;
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

  public Trailer getTrailer() {
    return this.trailer;
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
    if (trailer == null) {
      return Integer.toString(this.id) + " Brand: " + this.brand + " Model: " + this.model + " MaxWeight: "
          + Integer.toString(this.maxWeight) +
          " NumberOfPassengers: " + Integer.toString(this.numberOfPassengers) + " MaxSpeed: "
          + Integer.toString(this.maxSpeed);
    } else {
      return Integer.toString(this.id) + " Brand: " + this.brand + " Model: " + this.model + " MaxWeight: "
          + Integer.toString(this.maxWeight) +
          " NumberOfPassengers: " + Integer.toString(this.numberOfPassengers) + " MaxSpeed: "
          + Integer.toString(this.maxSpeed) +
          " Trailer: " + trailer.toString();
    }
  }
}