package Objects;

import Utils.Constants;
import Utils.Enums.Attribute;
import Utils.Enums.ItemType;

import java.util.Objects;

public final class Item {
  private final Logger logger = Constants.logger;
  private final String name;
  private final Attribute attribute;
  private final int atrib;
  private Special special;

  public Item(String name, Attribute attribute, int atrib, Special special) {
    this.name = name;
    this.attribute = attribute;
    this.atrib = atrib;
    this.special = special;
    logger.log("initialized item: " + this);
  }

  public String name() {
    return name;
  }

  public Attribute attribute() {
    return attribute;
  }

  public int atrib() {
    return atrib;
  }

  public Special special() {
    return special;
  }

  public void setSpecial(Special special) {
    this.special = special;
    logger.log("set " + this + " special to " + special);
  }

}
