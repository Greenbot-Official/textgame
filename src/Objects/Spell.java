package Objects;

import Utils.Constants;
import Utils.Effects;
import Utils.Enums.Element;
import Utils.Logger;

import static Utils.Effects.*;

public class Spell extends BaseObject {
  private final String name;
  private final String desc;
  private final int manaCost;
  private final int damage;
  private Effect effect;
  private final Element element;
  private final boolean heal;

  public Spell(String name, String desc, int manaCost, int damage, Element element, boolean heal, Effect effect) {
    super("Spell");
    this.name = name;
    this.desc = desc;
    this.manaCost = manaCost;
    this.damage = damage;
    this.effect = effect;
    this.element = element;
    this.heal = heal;
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
  public boolean isHeal() {
    return heal;
  }
  public void setEffect(Effect effect) {
    this.effect = effect;
    logger.log("set " + this + " special: " + effect);
  }
}
