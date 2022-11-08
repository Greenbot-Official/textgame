package Objects;

import Utils.Constants;
import Utils.Logger;

public class Effect {
  private final static Logger logger = Constants.logger;
  private final String name;
  private final String desc;
  private int duration;

  public Effect(String name, String desc, int duration) {
    this.name = name;
    this.desc = desc;
    this.duration = duration;
    logger.log("initialized Effect: " + this);
  }
}
