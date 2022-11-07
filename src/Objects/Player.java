package Objects;

public class Player extends Character {

  public Player(int maxHp, int maxMana) {
    super(maxHp, maxMana);
    logger.log("initialized Player: " + this);
  }

}
