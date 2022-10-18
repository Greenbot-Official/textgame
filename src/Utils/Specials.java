package Utils;

import Objects.Logger;
import Objects.Player;
import Objects.Special;

public class Specials {
  private static Logger logger = Constants.logger;
  public static Special none() {
    return new Special("none", 0, () -> {
      System.out.println("you are unable to use a special ability");
      logger.log("used special: none");
    });
  }
  public static Special jump(Player user) {
    return new Special("jump", 0, () -> {
      System.out.println("jump");
      logger.log("used special: jump");
    });
  }
  public static Special weakForesight(Player user) {
    return new Special("weak foresight", 15, () -> {
      System.out.println("weakforsight ");
      logger.log("used special: weakForesight");
    });
  }
  public static Special weakDrain(Player user) {
    return new Special("weak drain", 25, () -> {
      System.out.println("weakdrain ");
      logger.log("used special: weakDrain");
    });
  }
}
