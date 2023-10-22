package Laba2;

public class Bike extends Vehicle{
  public Bike(String brand, String model, Integer maxWeight,  Integer numberOfPassengers, Integer maxSpeed, Trailer trailer) {
    super(brand, model, maxWeight, numberOfPassengers, maxSpeed, trailer);
  }

  public Bike(String brand, String model, Integer maxWeight,  Integer numberOfPassengers, Integer maxSpeed) {
    super(brand, model, maxWeight, numberOfPassengers, maxSpeed, null);
  }
}