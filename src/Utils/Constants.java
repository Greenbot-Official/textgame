package Utils;

import Objects.Logger;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;

public class Constants {
  public static final String logPath= "src/Logs/" + Time.from(Instant.now()).getTime();
  public static final Logger logger = new Logger(logPath);
}
