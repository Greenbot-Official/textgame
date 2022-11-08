package Objects;

import Utils.Constants;
import Utils.Enums.Element;
import Utils.Logger;

public class Spell {
  private static final Logger logger = Constants.logger;
  private final String name;
  private final String desc;
  private final int manaCost;
  private final int damage;
  private final Effect effect;
  private final Element element;

  public Spell(String name, String desc, int manaCost, int damage, Effect effect, Element element) {
    this.name = name;
    this.desc = desc;
    this.manaCost = manaCost;
    this.damage = damage;
    this.effect = effect;
    this.element = element;
    logger.log("initialized Spell: " + this);
  }

  public String getName() {
    return name;
  }
  public String getDesc() {
    return desc;
  }
  public int getManaCost() {
    return manaCost;
  }
  public int getDamage() {
    return damage;
  }
  public Effect getEffect() {
    return effect;
  }
}
