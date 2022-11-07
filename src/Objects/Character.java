package Objects;

import Utils.Constants;
import Utils.Logger;

public abstract class Character {
  protected Logger logger = Constants.logger;
  protected int maxHp;
  protected int hp;
  protected int maxMana;
  protected int mana;

  public Character(int maxHp, int maxMana) {
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.maxMana = maxMana;
    this.mana = maxMana;
  }

  public void damage(int dmg) {
    this.hp -= dmg;
  }

  public void heal(int heal) {
    this.hp = Math.min((hp + heal), maxHp);
  }
}
