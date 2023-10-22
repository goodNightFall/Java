package Laba3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Properties;

public class Config {
  private String username;
  private Boolean logs;

  public Config(String configFileName) {
    try {
      Properties props = new Properties();
      props.load(new FileInputStream(new File(configFileName)));

      this.logs = Boolean.parseBoolean(props.getProperty("SET_LOGS"));
      this.username = props.getProperty("USER_NAME");
    } catch (IOException e) {
      System.out.println("Problems with opening the config");
      this.logs = false;
      this.username = "undefined";
    }
  }

  public Config() {
    this.logs = false;
    this.username = "undefined";
  }

  public String getUsername() {
    return this.username;
  }

  public Boolean getLogs() {
    return this.logs;
  }

  public void ErrorLog(String logValue, String fileName) {
    if (this.logs) {
      try {
        SettingsMenu.WriteToFile("\t" + logValue + " " + LocalTime.now() + "\n", fileName, true);
      } catch (IOException e) {
        System.out.println("Log write error! " + logValue);
      }
    }
  }

  public void StartLog(String fileName) {
    if (this.logs) {
      try {
        SettingsMenu.WriteToFile("The program was opened by " + this.username + " " + LocalTime.now() + "\n", fileName,
            true);
      } catch (IOException e) {
        SettingsMenu.LogWriteError();
      }
    }
  }

  public void EndLog(String fileName) {
    if (this.logs) {
      try {
        SettingsMenu.WriteToFile("The program was ended" + " " + LocalTime.now() + "\n\n", fileName, true);
      } catch (IOException e) {
        SettingsMenu.LogWriteError();
      }
    }
  }

  public void WriteLog(String fileName) {
    if (this.logs) {
      try {
        SettingsMenu.WriteToFile("\tWriting to the data base by " + this.username + " " + LocalTime.now() + "\n",
            fileName,
            true);
      } catch (IOException e) {
        SettingsMenu.LogWriteError();
      }
    }
  }

  public void ReadLog(String fileName) {
    if (this.logs) {
      try {
        SettingsMenu.WriteToFile("\tReading from a data base by " + this.username + " " + LocalTime.now() + "\n",
            fileName,
            true);
      } catch (IOException e) {
        SettingsMenu.LogWriteError();
      }
    }
  }

  public void AddLog(String fileName) {
    if (this.logs) {
      try {
        SettingsMenu.WriteToFile(
            "\tNew vehicle was added to the data base by " + this.username + " " + LocalTime.now() + "\n", fileName,
            true);
      } catch (IOException e) {
        SettingsMenu.LogWriteError();
      }
    }
  }
}
