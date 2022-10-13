package Objects;

import Utils.Enums.Attribute;
import Utils.Enums.ItemType;

import java.util.Objects;

public final class Item {
  private final String name;
  private final ItemType type;
  private final Attribute attribute;
  private final int atrib;
  private Special special;

  public Item(String name, ItemType type, Attribute attribute, int atrib, Special special) {
    this.name = name;
    this.type = type;
    this.attribute = attribute;
    this.atrib = atrib;
    this.special = special;
  }

  public String name() {
    return name;
  }

  public ItemType type() {
    return type;
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
  }

}
