package Objects;

import Utils.Constants;
import Utils.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends BaseObject {
  protected int maxHp;
  protected int hp;
  protected int maxMana;
  protected int mana;
  protected List<Spell> spellList;
  protected List<Effect> effectList;

  public Character(String name, int maxHp, int maxMana) {
    super(name);
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.maxMana = maxMana;
    this.mana = maxMana;
    this.spellList = new ArrayList<>();
    this.effectList = new ArrayList<>();
  }

  public void damage(int dmg) {
    this.hp -= dmg;
    logger.log(this + " was dealt dmg: " + dmg);
  }
  public void heal(int heal) {
    int temp = Math.min((hp + heal), maxHp);
    this.hp = temp;
    logger.log(this + " healed: " + temp);
  }
  public void useMana(int mana) {
    this.mana -= mana;
    logger.log(this + " used mana: " + mana);
  }
  public void healMana(int mana) {
    int temp = Math.min((this.mana + mana), maxMana);
    this.mana = temp;
    logger.log(this + " healed mana: " + temp);
  }
  public List<Spell> getSpells() {
    return spellList;
  }
  public List<Effect> getEffects() {
    return effectList;
  }
}
