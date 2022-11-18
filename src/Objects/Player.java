package Objects;

import Utils.Enemies;

public class Player extends Character {
  private boolean combat;
  private boolean turn;
  private boolean dead;
  private Enemy enemy;

  public Player(int maxHp, int maxMana) {
    super("Player", maxHp, maxMana);
    this.combat = false;
    this.turn = true;
    this.dead = false;
    this.enemy = Enemies.none;
  }

  public boolean isCombat() {
    return combat;
  }
  public void setCombat(boolean combat) {
    this.combat = combat;
    logger.log("set combat to: " + combat);
  }
  public boolean isTurn() {
    return turn;
  }
  public void setTurn(boolean turn) {
    this.turn = turn;
    logger.log("set turn to: " + turn);
  }
  public boolean isNotDead() {
    return !dead;
  }
  public void setDead(boolean dead) {
    this.dead = dead;
    logger.log("set dead to: " + dead);
  }
  public Enemy getEnemy() {
    return enemy;
  }
  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
    logger.log("set enemy to: " + enemy
    );
  }
}
