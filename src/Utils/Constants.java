package Utils;

import java.sql.Time;
import java.time.Instant;

public class Constants {
  public static final String logPath= "src/Logs/" + Time.from(Instant.now()).getTime();
  public static Logger logger = new Logger(logPath);
}
