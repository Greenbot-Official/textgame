package Objects;

import Utils.Constants;
import Utils.Logger;

public abstract class BaseObject {
  protected final Logger logger = Constants.logger;

  public BaseObject(String name) {
    logger.log("initialized " + name + ": " + this);
  }
}
