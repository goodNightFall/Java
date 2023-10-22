package Laba3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SettingsMenu {
  public static void Clear() {
    System.out.print("\033[H\033[J");
  }

  public static void Continue() {
    System.out.println("Press any key to exit");
  }

  public static void MainMenu() {
    Clear();
    System.out.println("0 - Exit");
    System.out.println("1 - Print vehicles");
    System.out.println("2 - Add new vehicle");
    System.out.println("3 - Read vehicles from data base");
    System.out.println("4 - Write vehicles to data base");
    System.out.println("5 - Choose vehicle");
    System.out.print("Your choose: ");
  }

  public static void ChooseId() {
    System.out.print("Your choose: ");
  }

  public static void ChangeMenu() {
    Clear();
    System.out.println("0 - Exit");
    System.out.println("1 - Change brand");
    System.out.println("2 - Change model");
    System.out.println("3 - Change max weight");
    System.out.println("4 - Change number of passengers");
    System.out.println("5 - Change max speed");
    System.out.println("6 - Change trailer");
    System.out.println("7 - Delete");
    System.out.print("Your choose: ");
  }

  public static void ChangeTrailerMenu() {
    Clear();
    System.out.println("0 - Exit");
    System.out.println("1 - Change brand");
    System.out.println("2 - Change model");
    System.out.println("3 - Change max weight");
    System.out.println("4 - Change number of passengers");
    System.out.println("5 - Change max speed");
    System.out.print("Your choose: ");
  }

  public static void typeOfVehicle() {
    System.out.println("Select the type of vehicle: ");
    System.out.println("1 - Car");
    System.out.println("2 - Bike");
    System.out.println("3 - Bus");
    System.out.println("4 - Truck");
    System.out.print("Your choose: ");
  }

  public static void Brand() {
    System.out.print("Brand: ");
  }

  public static void Model() {
    System.out.print("Model: ");
  }

  public static void MaxWeight() {
    System.out.print("Maximum weight: ");
  }

  public static void numberOfPassengers() {
    System.out.print("Number of passengers: ");
  }

  public static void maxSpeed() {
    System.out.print("Maximum speed: ");
  }

  public static void hasTrailer() {
    System.out.println("Is there a trailer?");
    System.out.println("1 - Yes");
    System.out.println("2 - No");
    System.out.print("Your choose: ");
  }

  public static Trailer createTrailer(Scanner scanner, Random id) {
    while (true) {
      Clear();
      Brand();
      String brand = scanner.next();

      Clear();
      Model();
      String model = scanner.next();

      Clear();
      MaxWeight();
      Integer maxWeight = scanner.nextInt();

      Clear();
      numberOfPassengers();
      Integer numberOfPassengers = scanner.nextInt();

      Clear();
      maxSpeed();
      Integer maxSpeed = scanner.nextInt();

      return new Trailer(id.nextInt(10000), brand, model, maxWeight, numberOfPassengers, maxSpeed);
    }
  }

  public static void InputError() {
    System.out.println("Input error. Try again");
    Continue();
  }

  public static void TypeError() {
    System.out.println("Can't have a trailer!!!");
  }

  public static void PrintAll(ArrayList<Vehicle> vehicle) {
    if (vehicle.size() == 0) {
      System.out.println("Empty");
    } else {
      for (Vehicle item : vehicle) {
        System.out.println(item);
      }
    }
  }

  public static void WriteToFile(String value, String fileName, Boolean isOverWrite) throws IOException {
    FileWriter writer = new FileWriter(fileName, isOverWrite);
    writer.write(value);
    writer.close();
  }

  public static void LogWriteError() {
    System.out.println("Log write error!");
  }
}
