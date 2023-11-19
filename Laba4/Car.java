package Laba4;

public class Car extends Vehicle {
  public Car(Integer id, String brand, String model, Integer maxWeight, Integer numberOfPassengers, Integer maxSpeed,
      Trailer trailer) {
    super(id, brand, model, maxWeight, numberOfPassengers, maxSpeed, trailer);
  }

  public Car(Integer id, String brand, String model, Integer maxWeight, Integer numberOfPassengers, Integer maxSpeed) {
    super(id, brand, model, maxWeight, numberOfPassengers, maxSpeed);
  }
}