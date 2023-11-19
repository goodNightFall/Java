package Laba4;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class LogsFile {
    private static Integer count = 0;

    public static void StartLog(String fileName) {
        try {
            WriteToFile("The program was opened " + LocalTime.now() + "\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
        }
    }
      
    
    public static void EndLog(String fileName) {
        try {
            WriteToFile("The program was ended " + LocalTime.now() + "\n\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
        }
    }

    public static void AddLog(String fileName, Integer ID, Long time) {
        try {
            WriteToFile("\tadd, " + "ID = " + ID + ", " + time + "\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
        }
    }

    public static void AddTotalLog(String fileName, Long time) {
        try {
            WriteToFile("\taddTotal = " + time + "\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
        }
    }

    public static void AddMediumLog(String fileName, Long time) {
        try {
            WriteToFile("\taddMedium = "  + time + "\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
        }
    }

    public static void removeLog(String fileName, Integer ID, Long time) {
        try {
            WriteToFile("\tremove, " + "ID = " + ID + ", " + time + "\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
        }
    }

    public static void RemoveTotalLog(String fileName, Long time) {
        try {
            WriteToFile("\tremoveTotal = " + time + "\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
        }
    }

    public static void RemoveMediumLog(String fileName, Long time) {
        try {
            WriteToFile("\tremoveMedium = "  + time + "\n\n", fileName, true);
        } catch (IOException e) {
            count += 1;
            LogWriteError();
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
