package Laba2;

public class Truck extends Vehicle{
  public Truck(String brand, String model, Integer maxWeight,  Integer numberOfPassengers, Integer maxSpeed, Trailer trailer) {
    super(brand, model, maxWeight, numberOfPassengers, maxSpeed, trailer);
  }

  public Truck(String brand, String model, Integer maxWeight,  Integer numberOfPassengers, Integer maxSpeed) {
    super(brand, model, maxWeight, numberOfPassengers, maxSpeed, null);
  }
}