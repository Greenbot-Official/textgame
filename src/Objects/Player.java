package Objects;

import Utils.LocationMap;
import Utils.Quests;
import Utils.Utils;
import Utils.Constants;

public class Player {
  private final Logger logger = Constants.logger;
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
    logger.log("initialized player: " + this);
  }

  public void damage(int dmg) {
    hp -= dmg;
    logger.log("took " + dmg + "dmg");
  }
  public void heal(int heal) {
    hp += heal;
    if (hp> maxHp) hp = maxHp;
    logger.log("healed " + heal + "hp");
  }
  public void healMana(int heal) {
    mana += heal;
    if (mana> maxMana) mana = maxMana;
    logger.log("healed " + heal + "mana");
  }
  public boolean isCombat() {
    return combat;
  }
  public void setEye(Item eye) {
    this.eye = eye;
    logger.log("set eye to: " + eye.toString());
  }
  public void setHeart(Item heart) {
    this.heart = heart;
    logger.log("set heart to: " + heart.toString());
  }
  public void setArm(Item arm) {
    this.arm = arm;
    logger.log("set arm to: " + arm.toString());
  }
  public void setLeg(Item leg) {
    this.leg = leg;
    logger.log("set leg to: " + leg.toString());
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
    logger.log("set enemy to: " + enemy.toString());
  }
  public void setCombat(boolean iscombat) {
    combat = iscombat;
    logger.log("set combat to: " + iscombat);
  }
  public boolean getTurn() {
    return playerTurn;
  }
  public void setTurn(boolean turn) {
    playerTurn = turn;
    logger.log("set turn to: " + turn);
  }
  public void toggleTurn() {
    playerTurn = !playerTurn;
    logger.log("set turn to: " + this.playerTurn);
  }
  public int getMaxMana() {
    return maxMana;
  }
  public int getMana() {
    return mana;
  }
  public void setMaxMana(int maxmana) {
    this.maxMana = maxmana;
    logger.log("set maxMana to: " + maxmana);
  }
  public void setMaxHp(int maxhp) {
    this.maxHp = maxhp;
    logger.log("set maxHp to: " + maxhp);
  }
  public int getHp() {
    return hp;
  }
  public int getMaxHp() {
    return maxHp;
  }
  public void fullHeal() {
    this.hp = this.maxHp;
    logger.log("full healed health");
  }
  public void fullMana() {
    this.mana = this.maxMana;
    logger.log("full healed mana");
  }
  public boolean isDead() {
    return dead;
  }
  public void setDead (boolean dead) {
    this.dead = dead;
    logger.log("set dead to: " + dead);
  }
  public boolean isLoot () {
    return loot;
  }
  public void setLoot (boolean loot) {
    this.loot = loot;
    logger.log("set loot to: " + loot);
  }
  public void die() {
    System.out.println("you have died");
    setDead(true);
    logger.log("player has died");
  }
  public void kill () {
    System.out.println("\nyou have killed an enemy");
    setLoot(true);
    setCombat(false);
    if (quest == Quests.first) setComplete(true);
    logger.log("player has killed: " + this.enemy.toString());
  }
  public Quest getQuest() {
    return quest;
  }
  public void setQuest(Quest quest) {
    this.quest = quest;
    logger.log("set quest to: " + quest.toString());
  }
  public void setComplete(boolean bool) {
    questCompleted = bool;
    logger.log("set questCompleted to: " + bool);
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
        logger.log("random encounter");
        return;
      }
    }
    switch (direction) {
      case "n" -> this.yPos -= 1;
      case "e" -> this.xPos += 1;
      case "s" -> this.yPos += 1;
      case "w" -> this.xPos -= 1;
    }
    logger.log("moved: " + direction);
  }
  public Location getMapPos() {
    return LocationMap.map[yPos][xPos];
  }
  public boolean isRandomEncounters() {
    return randomEncounters;
  }
  public void setRandomEncounters(boolean randomEncounters) {
    this.randomEncounters = randomEncounters;
    logger.log("set randomEncounters to: " + randomEncounters);
  }
  public float getEncounterChance() {
    return encounterChance;
  }
  public void setEncounterChance(float encounterChance) {
    this.encounterChance = encounterChance;
    logger.log("set encounterChance to: " + encounterChance);
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
    logger.log("started combat with: " + enemy.toString());
  }
}
