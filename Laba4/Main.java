package Laba4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		LogsFile.StartLog("Laba4/logs.txt");
		Integer numberOfObjects = 10;

		ArrayList<Vehicle> vehicleList = new ArrayList<>();
		GenerateArrayList.FillRandomList(vehicleList, numberOfObjects);

		ArrayList<Vehicle> vehicleListCapacity = new ArrayList<>();
		GenerateArrayList.FillRandomList(vehicleListCapacity, (numberOfObjects * 3) / 2 + 1);

		LinkedList<Vehicle> vehicleLinked = new LinkedList<>();
		GenerateArrayList.FillRandomLinked(vehicleLinked, numberOfObjects);
		LogsFile.EndLog("Laba4/logs.txt");
	}
}
