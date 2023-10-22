package Laba3;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static Vehicle AddNewVehicle(Scanner scanner, Config config, Random id) {
		while (true) {
			SettingsMenu.Clear();
			SettingsMenu.typeOfVehicle();
			Integer typeOfVehicle = scanner.nextInt();

			SettingsMenu.Clear();
			SettingsMenu.Brand();
			String brand = scanner.next();

			SettingsMenu.Clear();
			SettingsMenu.Model();
			String model = scanner.next();

			SettingsMenu.Clear();
			SettingsMenu.MaxWeight();
			Integer maxWeight = scanner.nextInt();

			SettingsMenu.Clear();
			SettingsMenu.numberOfPassengers();
			Integer numberOfPassengers = scanner.nextInt();

			SettingsMenu.Clear();
			SettingsMenu.maxSpeed();
			Integer maxSpeed = scanner.nextInt();

			SettingsMenu.Clear();
			try {
				switch (typeOfVehicle) {
					case 1:
						try {
							SettingsMenu.Clear();
							SettingsMenu.hasTrailer();
							Integer hasTrailer = scanner.nextInt();
							switch (hasTrailer) {
								case 1:
									config.AddLog("Laba3/logs.txt");
									Trailer trailer = SettingsMenu.createTrailer(scanner, id);
									return new Car(id.nextInt(10000), brand, model, maxWeight, numberOfPassengers, maxSpeed, trailer);

								case 2:
									config.AddLog("Laba3/logs.txt");
									return new Car(id.nextInt(10000), brand, model, maxWeight, numberOfPassengers, maxSpeed);

								default:
									SettingsMenu.InputError();
									continue;
							}
						} catch (java.util.InputMismatchException e) {
							config.ErrorLog("Incorrect input", "Laba3/logs.txt");
						}

					case 2:
						config.AddLog("Laba3/logs.txt");
						return new Bike(id.nextInt(10000), brand, model, maxWeight, numberOfPassengers, maxSpeed);

					case 3:
						config.AddLog("Laba3/logs.txt");
						return new Bus(id.nextInt(10000), brand, model, maxWeight, numberOfPassengers, maxSpeed);

					case 4:
						SettingsMenu.Clear();
						SettingsMenu.hasTrailer();
						Integer hasTrailer = scanner.nextInt();
						try {
							switch (hasTrailer) {
								case 1:
									config.AddLog("Laba3/logs.txt");
									Trailer trailer = SettingsMenu.createTrailer(scanner, id);
									return new Truck(id.nextInt(10000), brand, model, maxWeight, numberOfPassengers, maxSpeed, trailer);

								case 2:
									config.AddLog("Laba3/logs.txt");
									return new Truck(id.nextInt(10000), brand, model, maxWeight, numberOfPassengers, maxSpeed);

								default:
									SettingsMenu.InputError();
									continue;
							}
						} catch (java.util.InputMismatchException e) {
							config.ErrorLog("Incorrect input", "Laba3/logs.txt");
						}

					default:
						SettingsMenu.InputError();
						continue;
				}
			} catch (java.util.InputMismatchException e) {
				config.ErrorLog("Incorrect input", "Laba3/logs.txt");
			}
		}
	}

	public static void WriteVehicletoDataBase(ArrayList<Vehicle> vehicle, Boolean isOverWrite) throws IOException {
		FileWriter writer = new FileWriter("Laba3/data-base.txt", isOverWrite);
		for (int i = 0; i < vehicle.size(); i++) {
			writer.write(vehicle.get(i) + "\n");
		}
		writer.close();
	}

	public static ArrayList<Vehicle> ReadFromFile() throws IOException {
		Scanner fileScanner = new Scanner(new File("Laba3/data-base.txt"));
		ArrayList<Vehicle> vehicleFromFile = new ArrayList<>();

		while (fileScanner.hasNextLine()) {
			String[] line = fileScanner.nextLine().split(" ");
			if (line.length > 13) {
				Trailer trailer = new Trailer(Integer.parseInt(line[12]), line[14], line[16], Integer.parseInt(line[18]),
						Integer.parseInt(line[20]),
						Integer.parseInt(line[22]));
				Vehicle newVehicle = new Vehicle(Integer.parseInt(line[0]), line[2], line[4], Integer.parseInt(line[6]),
						Integer.parseInt(line[8]),
						Integer.parseInt(line[10]), trailer);
				vehicleFromFile.add(newVehicle);
			} else {
				Vehicle newVehicle = new Vehicle(Integer.parseInt(line[0]), line[2], line[4], Integer.parseInt(line[6]),
						Integer.parseInt(line[8]),
						Integer.parseInt(line[10]));
				vehicleFromFile.add(newVehicle);
			}
		}

		fileScanner.close();
		return vehicleFromFile;
	}

	public static void MainMenu(Config config, ArrayList<Vehicle> vehicle, Random id) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome, " + config.getUsername() + "!");
		SettingsMenu.Continue();
		scanner.next();

		while (true) {
			try {
				SettingsMenu.Clear();
				SettingsMenu.MainMenu();
				Integer command = scanner.nextInt();

				switch (command) {
					case 0:
						scanner.close();
						return;

					case 1:
						SettingsMenu.Clear();
						SettingsMenu.PrintAll(vehicle);
						SettingsMenu.Continue();
						scanner.next();
						break;

					case 2:
						SettingsMenu.Clear();
						Vehicle newVehicle = AddNewVehicle(scanner, config, id);
						vehicle.add(newVehicle);
						SettingsMenu.Continue();
						scanner.next();
						break;

					case 3:
						SettingsMenu.Clear();
						try {
							vehicle = (ArrayList<Vehicle>) ReadFromFile().clone();
							config.ReadLog("Laba3/logs.txt");
						} catch (IOException e) {
							config.ErrorLog("Read error!\n", "Laba3/logs.txt");
						}
						SettingsMenu.Continue();
						scanner.next();
						break;

					case 4:
						SettingsMenu.Clear();
						try {
							WriteVehicletoDataBase(vehicle, true);
							config.WriteLog("Laba3/logs.txt");
						} catch (IOException e) {
							config.ErrorLog("Write error!", "Laba3/logs.txt");
						}
						SettingsMenu.Continue();
						scanner.next();
						break;

					case 5:
						SettingsMenu.Clear();
						try {
							vehicle = (ArrayList<Vehicle>) ReadFromFile().clone();
							SettingsMenu.PrintAll(vehicle);
							SettingsMenu.ChooseId();
							Integer chooseId = scanner.nextInt();
							SettingsMenu.ChangeMenu();
							Integer changeCommand = scanner.nextInt();
							switch (changeCommand) {
								case 0:
									SettingsMenu.MainMenu();
									break;

								case 1:
									SettingsMenu.Clear();
									ChangeItem.ChangeBrand(vehicle, chooseId, scanner);
									WriteVehicletoDataBase(vehicle, false);
									SettingsMenu.MainMenu();
									break;

								case 2:
									SettingsMenu.Clear();
									ChangeItem.ChangeModel(vehicle, chooseId, scanner);
									WriteVehicletoDataBase(vehicle, false);
									SettingsMenu.MainMenu();
									break;

								case 3:
									SettingsMenu.Clear();
									ChangeItem.ChangeMaxWeight(vehicle, chooseId, scanner, config);
									WriteVehicletoDataBase(vehicle, false);
									SettingsMenu.MainMenu();
									break;

								case 4:
									SettingsMenu.Clear();
									ChangeItem.ChangeNumberOfPassengers(vehicle, chooseId, scanner, config);
									WriteVehicletoDataBase(vehicle, false);
									SettingsMenu.MainMenu();
									break;

								case 5:
									SettingsMenu.Clear();
									ChangeItem.ChangeMaxSpeed(vehicle, chooseId, scanner, config);
									WriteVehicletoDataBase(vehicle, false);
									SettingsMenu.MainMenu();
									break;

								case 6:
									SettingsMenu.ChangeTrailerMenu();
									Integer changeTrailerCommand = scanner.nextInt();
									ChangeItem.ChangeTrailer(vehicle, chooseId, changeTrailerCommand, scanner, config);
									break;

								case 7:
									SettingsMenu.Clear();
									ChangeItem.Delete(vehicle, chooseId);
									WriteVehicletoDataBase(vehicle, false);
									SettingsMenu.MainMenu();
									break;

								default:
									continue;
							}
						} catch (java.util.InputMismatchException e) {
							config.ErrorLog("Incorrect input", "Laba3/logs.txt");
						}

						break;

					default:
						continue;
				}
			} catch (java.util.InputMismatchException e) {
				config.ErrorLog("Incorrect input", "Laba3/logs.txt");
				scanner.nextLine();
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Random id = new Random();
		Config config = new Config("Laba3/Config.ini");
		ArrayList<Vehicle> vehicle = new ArrayList<>();
		try {
			config.StartLog("Laba3/logs.txt");
			MainMenu(config, vehicle, id);
			config.EndLog("Laba3/logs.txt");
		} catch (IOException e) {
			config.ErrorLog(e.getMessage(), "Laba3/logs.txt");
		}
	}
}
