package Objects;

import Utils.LocationMap;
import Utils.Quests;
import Utils.Utils;

public class Player {
  private int maxHp;
  private int hp;
  private int maxMana;
  private int mana;
  private Item eye;
  private Item heart;
  private Item arm;
  private Item leg;
  private boolean combat;
  private boolean playerTurn;
  private Enemy enemy;
  private boolean dead;
  private boolean loot;
  private Quest quest;
  private int xPos;
  private int yPos;
  private boolean questCompleted;
  private boolean randomEncounters;
  private float encounterChance;

  public Player() {
    this.maxHp = 0;
    this.maxMana = 0;
    this.combat = false;
    this.playerTurn = true;
    this.dead = false;
    this.loot = false;
    this.quest = Quests.first;
    this.xPos = 0;
    this.yPos = 0;
    this.questCompleted = false;
    this.randomEncounters = false;
    this.encounterChance = 0;
  }

  public void damage(int dmg) {
    hp -= dmg;
  }
  public void heal(int heal) {
    hp += heal;
    if (hp> maxHp) hp = maxHp;
  }
  public void healMana(int heal) {
    mana += heal;
    if (mana> maxMana) mana = maxMana;
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
    return playerTurn;
  }
  public void setTurn(boolean turn) {
    playerTurn = turn;
  }
  public void toggleTurn() {
    playerTurn = !playerTurn;
  }
  public int getMaxMana() {
    return maxMana;
  }
  public int getMana() {
    return mana;
  }
  public void setMaxMana(int maxmana) {
    this.maxMana = maxmana;
  }
  public void setMaxHp(int maxhp) {
    this.maxHp = maxhp;
  }
  public int getHp() {
    return hp;
  }
  public int getMaxHp() {
    return maxHp;
  }
  public void fullHeal() {
    this.hp = this.maxHp;
  }
  public void fullMana() {
    this.mana = this.maxMana;
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
    if (quest == Quests.first) setComplete(true);
  }
  public Quest getQuest() {
    return quest;
  }
  public void setQuest(Quest quest) {
    this.quest = quest;
  }
  public void setComplete(boolean bool) {
    questCompleted = bool;
  }
  public boolean getComplete() {
    return questCompleted;
  }
//  public int getxPos() {
//    return xPos;
//  }
//  public void setxPos(int xPos) {
//    this.xPos = xPos;
//  }
//  public int getyPos() {
//    return yPos;
//  }
//  public void setyPos(int yPos) {
//    this.yPos = yPos;
//  }
  /**
   * @param direction n, s, e, w
   * @return true or false
   */
  public boolean canMove(String direction) {
    return switch (direction) {
      case "n" -> LocationMap.map[yPos][xPos].n();
      case "e" -> LocationMap.map[yPos][xPos].e();
      case "s" -> LocationMap.map[yPos][xPos].s();
      case "w" -> LocationMap.map[yPos][xPos].w();
      default -> false;
    };
  }
  /**
   * @param direction n, s, e, w
   */
  public void move(String direction) {
    if (!getMapPos().town() && !this.randomEncounters) {
      if (Utils.randPercent() <= this.encounterChance) {
        startCombat(Utils.calcEncounter(), false);
        System.out.println("You have been ambushed");
        return;
      }
    }
    switch (direction) {
      case "n" -> this.yPos -= 1;
      case "e" -> this.xPos += 1;
      case "s" -> this.yPos += 1;
      case "w" -> this.xPos -= 1;
    }
  }
  public Location getMapPos() {
    return LocationMap.map[yPos][xPos];
  }
  public boolean isRandomEncounters() {
    return randomEncounters;
  }
  public void setRandomEncounters(boolean randomEncounters) {
    this.randomEncounters = randomEncounters;
  }
  public float getEncounterChance() {
    return encounterChance;
  }
  public void setEncounterChance(float encounterChance) {
    this.encounterChance = encounterChance;
  }
  public void startCombat(Enemy enemy, boolean heal) {
    this.enemy = enemy;
    this.combat = true;
    this.playerTurn = true;
    this.maxHp = Utils.calcHp(this.getItems());
    this.maxMana = Utils.calcMana(this.getItems());
    if (heal) {
      fullHeal();
      fullMana();
    }
  }
  public static void none() {
    System.out.println("you are unable to use a special ability");
  }
  public void jump() {
    System.out.println("jump");
  }
  public void weakForesight() {
    System.out.println("weakforsight ");
  }
  public void weakDrain() {
    System.out.println("weakdrain ");
  }
}
