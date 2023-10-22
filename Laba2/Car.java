package Laba2;

public class Car extends Vehicle{
  public Car(String brand, String model, Integer maxWeight,  Integer numberOfPassengers, Integer maxSpeed, Trailer trailer) {
    super(brand, model, maxWeight, numberOfPassengers, maxSpeed, trailer);
  }

  public Car(String brand, String model, Integer maxWeight,  Integer numberOfPassengers, Integer maxSpeed) {
    super(brand, model, maxWeight, numberOfPassengers, maxSpeed, null);
  }
}