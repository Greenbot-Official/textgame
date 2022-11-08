package Objects;

import Utils.Constants;
import Utils.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
  protected Logger logger = Constants.logger;
  protected int maxHp;
  protected int hp;
  protected int maxMana;
  protected int mana;
  protected List<Spell> spellList;
  protected List<Effect> effectList;

  public Character(int maxHp, int maxMana) {
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.maxMana = maxMana;
    this.mana = maxMana;
    this.spellList = new ArrayList<>();
    this.effectList = new ArrayList<>();
  }

  public void damage(int dmg) {
    this.hp -= dmg;
  }
  public void heal(int heal) {
    this.hp = Math.min((hp + heal), maxHp);
  }
  public void useMana(int mana) {
    this.mana -= mana;
  }
  public void healMana(int mana) {
    this.mana = Math.min((this.mana + mana), maxMana);
  }
  public List<Spell> getSpells() {
    return spellList;
  }
  public List<Effect> getEffects() {
    return effectList;
  }
}
