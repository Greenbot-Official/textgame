package Objects;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Logger {
  private File file;

  public Logger(File file) {
    this.file = file;
    createFile();
    log("creating new logger at: " + this.file.getPath());
  }

  public Logger(String file) {
    this.file = new File(file);
    createFile();
    log("creating new logger at: " + this.file.getPath());
  }

  private void createFile() {
    try {
      if (this.file.createNewFile()) {
        log("File created: " + this.file.getName());
      } else {
        System.out.println("Log file already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public String readLogs() {
    try {
      Scanner fileReader = new Scanner(file);
      StringBuilder data = new StringBuilder();
      while (fileReader.hasNextLine()) {
        data.append(fileReader.nextLine()).append("\n");
      }
      fileReader.close();
      return data.toString();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }

  public void log(String text) {
    try {
      Files.write(file.toPath(), (readLogs() + text).getBytes());
    } catch (IOException e) {
      System.out.println("failed to log");
      e.printStackTrace();
    }
  }
}
