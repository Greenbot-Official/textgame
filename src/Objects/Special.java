package Objects;

import Utils.Constants;

import java.util.Objects;

public final class Special {
  private final Logger logger = Constants.logger;
  private final String name;
  private final int manaCost;
  private final Runnable ability;

  public Special(String name, int manaCost, Runnable ability) {
    this.name = name;
    this.manaCost = manaCost;
    this.ability = ability;
    logger.log("initialized special: " + this);
  }

  public String name() {
    return name;
  }

  public int manaCost() {
    return manaCost;
  }

  public Runnable ability() {
    return ability;
  }
}
