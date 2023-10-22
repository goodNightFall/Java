package Laba3;

public class Truck extends Vehicle {
  public Truck(Integer id, String brand, String model, Integer maxWeight, Integer numberOfPassengers, Integer maxSpeed,
      Trailer trailer) {
    super(id, brand, model, maxWeight, numberOfPassengers, maxSpeed, trailer);
  }

  public Truck(Integer id, String brand, String model, Integer maxWeight, Integer numberOfPassengers,
      Integer maxSpeed) {
    super(id, brand, model, maxWeight, numberOfPassengers, maxSpeed);
  }
}