package Objects;

public class Enemy extends Character {
  private String name;

  public Enemy(String name, int maxHp, int maxMana) {
    super("Enemy", maxHp, maxMana);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
