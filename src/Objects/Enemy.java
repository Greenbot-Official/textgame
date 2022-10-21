package Objects;

import Utils.Constants;

public class Enemy {
  private final Logger logger = Constants.logger;
  private final int maxhp;
  private int hp;
  private final Item eye;
  private final Item heart;
  private final Item arm;
  private final Item leg;

  public Enemy(int hp, Item eye, Item heart, Item arm, Item leg) {
    this.maxhp = hp;
    this.hp = hp;
    this.eye = eye;
    this.heart = heart;
    this.arm = arm;
    this.leg = leg;
    logger.log("initialized enemy: " + this);
  }

  public Enemy(int hp, Item[] item) {
    this.maxhp = hp;
    this.hp = hp;
    this.eye = item[0];
    this.heart = item[1];
    this.arm = item[2];
    this.leg = item[3];
    logger.log("initialized enemy: " + this);
  }

  public int getHp() {
    return hp;
  }
  public void damage(int dmg) {
    hp -= dmg;
    logger.log(this + " took " + dmg + "dmg");
  }
  public int getMaxhp() {
    return maxhp;
  }
  public Item getEye() {
    return eye;
  }
  public Item getHeart() {
    return heart;
  }
  public Item getArm() {
    return arm;
  }
  public Item getLeg() {
    return leg;
  }
  public Item[] getItems() {
    return new Item[]{getEye(), getHeart(), getArm(), getLeg()};
  }
}
