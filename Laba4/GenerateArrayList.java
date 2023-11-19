package Laba4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GenerateArrayList {

    public static void FillRandomList(ArrayList<Vehicle> vehicleList, Integer numberOfObjects){
        Random generateNum = new Random();

        Long startTime = System.nanoTime();

        for (Integer i = 0; i < numberOfObjects; i++){
            int leftLimit = 97; 
            int rightLimit = 122; 
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

            Long startCurrLong = System.nanoTime();

            vehicleList.add(new Vehicle(generateNum.nextInt(1000), generatedString, generatedString, 
            generateNum.nextInt(1000), generateNum.nextInt(1000), generateNum.nextInt(1000)));

            Long endCurrLong = System.nanoTime();
            LogsFile.AddLog("Laba4/logs.txt", i, endCurrLong - startCurrLong);
        }

        Long endTime = System.nanoTime();
        LogsFile.AddTotalLog("Laba4/logs.txt", endTime - startTime);
        LogsFile.AddMediumLog("Laba4/logs.txt", (endTime - startTime)/numberOfObjects);
        Long startRemoveTime = System.nanoTime();

        for (Integer i = 0; i < vehicleList.size() * 0.1 ; i++){
            Long startRemoveCurrLong = System.nanoTime();

            vehicleList.remove(new Random().nextInt(vehicleList.size()));

            Long endRemoveCurrLong = System.nanoTime();
            LogsFile.removeLog("Laba4/logs.txt", new Random().nextInt(vehicleList.size()), endRemoveCurrLong - startRemoveCurrLong);
        }

        Long endRemoveTime = System.nanoTime();
        LogsFile.RemoveTotalLog("Laba4/logs.txt", endRemoveTime - startRemoveTime);
        LogsFile.RemoveMediumLog("Laba4/logs.txt", (endRemoveTime - startRemoveTime)/numberOfObjects);
    }






    public static void FillRandomLinked(LinkedList<Vehicle> vehicleLinked, Integer numberOfObjects){
        
        Random generateNum = new Random();

        Long startTime = System.nanoTime();

        for (Integer i = 0; i < numberOfObjects; i++){
            int leftLimit = 97; 
            int rightLimit = 122; 
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

            Long startCurrLong = System.nanoTime();

            vehicleLinked.add(new Vehicle(generateNum.nextInt(1000), generatedString, generatedString, 
            generateNum.nextInt(1000), generateNum.nextInt(1000), generateNum.nextInt(1000)));

            Long endCurrLong = System.nanoTime();
            LogsFile.AddLog("Laba4/logs.txt", i, endCurrLong - startCurrLong);
        }

        Long endTime = System.nanoTime();
        LogsFile.AddTotalLog("Laba4/logs.txt", endTime - startTime);
        LogsFile.AddMediumLog("Laba4/logs.txt", (endTime - startTime)/numberOfObjects);

        Long startRemoveTime = System.nanoTime();

        for (Integer i = 0; i < vehicleLinked.size() * 0.1 ; i++){
            Long startRemoveCurrLong = System.nanoTime();

            vehicleLinked.remove(new Random().nextInt(vehicleLinked.size()));

            Long endRemoveCurrLong = System.nanoTime();
            LogsFile.removeLog("Laba4/logs.txt", new Random().nextInt(vehicleLinked.size()), endRemoveCurrLong - startRemoveCurrLong);
        }

        Long endRemoveTime = System.nanoTime();
        LogsFile.RemoveTotalLog("Laba4/logs.txt", endRemoveTime - startRemoveTime);
        LogsFile.RemoveMediumLog("Laba4/logs.txt", (endRemoveTime - startRemoveTime)/numberOfObjects);
    }
    
}
