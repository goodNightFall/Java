package Laba3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ChangeItem {
  public static void ChangeBrand(ArrayList<Vehicle> vehicle, Integer id, Scanner scanner) {
    SettingsMenu.Clear();
    for (Vehicle item : vehicle) {
      if (Objects.equals(item.getId(), id)) {
        System.out.println("New brand: ");
        String brand = scanner.next();
        item.setBrand(brand);
        return;
      }
    }

    System.out.println("There isn't vehicle!");
  }

  public static void ChangeModel(ArrayList<Vehicle> vehicle, Integer id, Scanner scanner) {
    SettingsMenu.Clear();
    for (Vehicle item : vehicle) {
      if (Objects.equals(item.getId(), id)) {
        System.out.println("New model: ");
        String model = scanner.next();
        item.setModel(model);
        return;
      }
    }

    System.out.println("There isn't vehicle!");
  }

  public static void ChangeMaxWeight(ArrayList<Vehicle> vehicle, Integer id, Scanner scanner, Config config) {
    SettingsMenu.Clear();

    for (Vehicle item : vehicle) {
      if (Objects.equals(item.getId(), id)) {
        System.out.println("New max weight: ");
        try {
          Integer weight = scanner.nextInt();
          item.setMaxWeight(weight);
        } catch (java.util.InputMismatchException e) {
          config.ErrorLog("Incorrect input", "Laba3/logs.txt");
        }
        return;
      }
    }

    System.out.println("There isn't vehicle!");
  }

  public static void ChangeNumberOfPassengers(ArrayList<Vehicle> vehicle, Integer id, Scanner scanner, Config config) {
    SettingsMenu.Clear();

    for (Vehicle item : vehicle) {
      if (Objects.equals(item.getId(), id)) {
        System.out.println("New number of passengers: ");
        try {
          Integer numberOfPassengers = scanner.nextInt();
          item.setNumberOfPassengers(numberOfPassengers);
        } catch (java.util.InputMismatchException e) {
          config.ErrorLog("Incorrect input", "Laba3/logs.txt");
        }

        return;
      }
    }

    System.out.println("There isn't vehicle!");
  }

  public static void ChangeMaxSpeed(ArrayList<Vehicle> vehicle, Integer id, Scanner scanner, Config config) {
    SettingsMenu.Clear();

    for (Vehicle item : vehicle) {
      if (Objects.equals(item.getId(), id)) {
        System.out.println("New max speed: ");
        try {
          Integer maxSpeed = scanner.nextInt();
          item.setMaxSpeed(maxSpeed);
        } catch (java.util.InputMismatchException e) {
          config.ErrorLog("Incorrect input", "Laba3/logs.txt");
        }

        return;
      }
    }

    System.out.println("There isn't vehicle!");
  }

  public static void Delete(ArrayList<Vehicle> vehicle, Integer id) {
    SettingsMenu.Clear();

    for (Vehicle item : vehicle) {
      if (Objects.equals(item.getId(), id)) {
        vehicle.remove(item);
        return;
      }
    }

    System.out.println("There isn't vehicle!");
  }

  public static void ChangeTrailer(ArrayList<Vehicle> vehicle, Integer id, Integer changeTrailerCommand,
      Scanner scanner, Config config) {
    try {
      switch (changeTrailerCommand) {
        case 1:
          SettingsMenu.Clear();
          for (Vehicle item : vehicle) {
            if (Objects.equals(item.getId(), id)) {
              System.out.println("New brand: ");
              String brand = scanner.next();
              item.getTrailer().setBrand(brand);

              return;
            }
          }

          System.out.println("There isn't vehicle!");
          break;

        case 2:
          SettingsMenu.Clear();
          for (Vehicle item : vehicle) {
            if (Objects.equals(item.getId(), id)) {
              System.out.println("New model: ");
              String model = scanner.next();
              item.getTrailer().setModel(model);
              return;
            }
          }

          System.out.println("There isn't vehicle!");
          break;

        case 3:
          SettingsMenu.Clear();

          for (Vehicle item : vehicle) {
            if (Objects.equals(item.getId(), id)) {
              System.out.println("New max weight: ");
              try {
                Integer weight = scanner.nextInt();
                item.getTrailer().setMaxWeight(weight);
              } catch (java.util.InputMismatchException e) {
                config.ErrorLog("Incorrect input", "Laba3/logs.txt");
              }

              return;
            }
          }

          System.out.println("There isn't vehicle!");
          break;

        case 4:
          SettingsMenu.Clear();

          for (Vehicle item : vehicle) {
            if (Objects.equals(item.getId(), id)) {
              System.out.println("New number of passengers: ");
              try {
                Integer numberOfPassengers = scanner.nextInt();
                item.getTrailer().setNumberOfPassengers(numberOfPassengers);
              } catch (java.util.InputMismatchException e) {
                config.ErrorLog("Incorrect input", "Laba3/logs.txt");
              }

              return;
            }
          }

          System.out.println("There isn't vehicle!");
          break;

        case 5:
          SettingsMenu.Clear();

          for (Vehicle item : vehicle) {
            if (Objects.equals(item.getId(), id)) {
              System.out.println("New max speed: ");
              try {
                Integer maxSpeed = scanner.nextInt();
                item.getTrailer().setMaxSpeed(maxSpeed);
              } catch (java.util.InputMismatchException e) {
                config.ErrorLog("Incorrect input", "Laba3/logs.txt");
              }

              return;
            }
          }

          System.out.println("There isn't vehicle!");
          break;

        default:
          break;
      }
    } catch (java.util.InputMismatchException e) {
      config.ErrorLog("Incorrect input", "Laba3/logs.txt");
    }
  }
}
