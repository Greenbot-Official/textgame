package Objects;

import Utils.Constants;
import Utils.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends BaseObject {
  protected String name;
  protected int maxHp;
  protected int hp;
  protected int maxMana;
  protected int mana;
  protected List<Spell> spellList;
  protected List<Effect> effectList;

  public Character(String name, int maxHp, int maxMana) {
    super(name);
    this.name = name;
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.maxMana = maxMana;
    this.mana = maxMana;
    this.spellList = new ArrayList<>();
    this.effectList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }
  public int getMaxHp() {
    return maxHp;
  }
  public int getHp() {
    return hp;
  }
  public int getMaxMana() {
    return maxMana;
  }
  public int getMana() {
    return mana;
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
  public void addSpell(Spell spell) {
    spellList.add(spell);
    logger.log(this + " added spell: " + spell);
  }
  public void removeSpell(int index) {
    spellList.remove(index);
    logger.log(this + " removed spell: " + spellList.get(index));
  }
  public List<Effect> getEffects() {
    return effectList;
  }
  public void addEffect(Effect effect) {
    effectList.add(new Effect(effect));
    logger.log(this + " added effect: " + effect);
  }
  public void removeEffect(int index) {
    effectList.remove(index);
    logger.log(this + " removed effect: " + effectList.get(index));
  }
}
