package Objects;

import Utils.LocationMap;
import Utils.Quests;
import org.ietf.jgss.GSSName;

public class Player {
  private int maxhp;
  private int hp;
  private int maxmana;
  private int mana;
  private Item eye;
  private Item heart;
  private Item arm;
  private Item leg;
  private boolean combat;
  private boolean playerturn;
  private Enemy enemy;
  private boolean dead;
  private boolean loot;
  private Quest quest;
  private int xPos;
  private int yPos;

  public Player() {
    maxhp = 0;
    hp = maxhp;
    maxmana = 0;
    mana = maxmana;
    combat = false;
    playerturn = true;
    dead = false;
    loot = false;
    this.quest = Quests.first;
    xPos = 0;
    yPos = 0;
  }

  public void damage(int dmg) {
    hp -= dmg;
  }
  public void heal(int heal) {
    hp += heal;
    if (hp>maxhp) hp = maxhp;
  }
  public void healmana(int heal) {
    mana += heal;
    if (mana>maxmana) mana = maxmana;
  }
  public boolean isCombat() {
    return combat;
  }
  public void setEye(Item eye) {
    this.eye = eye;
  }
  public void setHeart(Item heart) {
    this.heart = heart;
  }
  public void setArm(Item arm) {
    this.arm = arm;
  }
  public void setLeg(Item leg) {
    this.leg = leg;
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
  public Enemy getEnemy() {
    return enemy;
  }
  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
  }
  public void setCombat(boolean iscombat) {
    combat = iscombat;
  }
  public boolean getTurn() {
    return playerturn;
  }
  public void setTurn(boolean turn) {
    playerturn = turn;
  }
  public void toggleTurn() {
    playerturn = !playerturn;
  }

  public int getMaxmana() {
    return maxmana;
  }

  public int getMana() {
    return mana;
  }
  public void setMaxmana(int maxmana) {
    this.maxmana = maxmana;
  }
  public void setMaxhp(int maxhp) {
    this.maxhp = maxhp;
  }
  public int getHp() {
    return hp;
  }
  public int getMaxhp() {
    return maxhp;
  }
  public void fullheal() {
    this.hp = this.maxhp;
  }
  public void fullmana() {
    this.mana = this.maxmana;
  }
  public boolean isDead() {
    return dead;
  }
  public void setDead (boolean dead) {
    this.dead = dead;
  }
  public boolean isLoot () {
    return loot;
  }
  public void setLoot (boolean loot) {
    this.loot = loot;
  }
  public void die() {
    System.out.println("you have died");
    setDead(true);
  }
  public void kill () {
    System.out.println("\nyou have killed an enemy");
    setLoot(true);
    setCombat(false);
  }
  public Quest getQuest() {
    return quest;
  }
  public void setQuest(Quest quest) {
    this.quest = quest;
  }
  public int getxPos() {
    return xPos;
  }
  public void setxPos(int xPos) {
    this.xPos = xPos;
  }
  public int getyPos() {
    return yPos;
  }
  public void setyPos(int yPos) {
    this.yPos = yPos;
  }

  /**
   * @param direction n, s, e, w
   * @return true or false
   */
  public boolean canMove(String direction) {
    switch (direction) {
      case "n":
        return LocationMap.map[yPos][xPos].n();
      case "e":
        return LocationMap.map[yPos][xPos].e();
      case "s":
        return LocationMap.map[yPos][xPos].s();
      case "w":
        return LocationMap.map[yPos][xPos].w();
      default:
        return false;
    }
  }
  /**
   * @param direction n, s, e, w
   */
  public void move(String direction) {
    switch (direction) {
      case "n":
        yPos -= 1;
        break;
      case "e":
        xPos += 1;
        break;
      case "s":
        yPos += 1;
        break;
      case "w":
        xPos -= 1;
        break;
    }
  }
  public Location getMapPos() {
    return LocationMap.map[yPos][xPos];
  }
}
