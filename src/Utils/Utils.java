package Utils;

import Objects.Enemy;
import Objects.Item;
import Utils.Enums.Attribute;

public class Utils {
  public static int calcDamage(Item[] items) {
    float mult = 0f;
    mult += items[0].attribute() == Attribute.str ? items[0].atrib() : 0f;
    mult += items[1].attribute() == Attribute.str ? items[1].atrib() : 0f;
    mult += items[2].attribute() == Attribute.str ? items[2].atrib() : 0f;
    mult += items[3].attribute() == Attribute.str ? items[3].atrib() : 0f;
    return (int) (10 * (1 + (mult * 0.1)));
  }

  public static int calcHp(Item[] items) {
    float mult = 0f;
    mult += items[0].attribute() == Attribute.end ? items[0].atrib() : 0f;
    mult += items[1].attribute() == Attribute.end ? items[1].atrib() : 0f;
    mult += items[2].attribute() == Attribute.end ? items[2].atrib() : 0f;
    mult += items[3].attribute() == Attribute.end ? items[3].atrib() : 0f;
    return (int) (50 + (mult * 10));
  }

  public static int calcMana(Item[] items) {
    float mult = 0f;
    mult += items[0].attribute() == Attribute.mag ? items[0].atrib() : 0f;
    mult += items[1].attribute() == Attribute.mag ? items[1].atrib() : 0f;
    mult += items[2].attribute() == Attribute.mag ? items[2].atrib() : 0f;
    mult += items[3].attribute() == Attribute.mag ? items[3].atrib() : 0f;
    return (int) (50 + (mult * 10));
  }

  /**
   * @return number 0 - 100
   */
  public static int randPercent() {
    return (int) (Math.random() * 100);
  }

  /**
   * @return enemy based on current items
   */
  // add scaling
  public static Enemy calcEncounter() {
    return Enemies.feeder;
  }
}
