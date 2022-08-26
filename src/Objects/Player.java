package Objects;

public class Player {
  private String name;
  private int maxhp;
  private int hp;
  private int maxmana;
  private int mana;
  private int maxenergy;
  private int energy;

  private Item eye;
  private Item heart;
  private Item arm;
  private Item leg;
  private boolean combat;
  private boolean playerturn;
  private Enemy enemy;

  public Player(String name) {
    this.name = name;
    maxhp = 100;
    hp = maxhp;
    maxmana = 100;
    mana = maxmana;
    maxenergy = 100;
    energy = maxenergy;
    combat = false;
    playerturn = true;
  }

  public void setName(String name) {
    this.name = name;
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
  public void healenergy(int heal) {
    energy += heal;
    if (energy>maxenergy) energy = maxenergy;
  }
  public void addmaxhp(int add) {
    maxhp += add;
  }
  public void addmaxmana(int add) {
    maxmana += add;
  }
  public void addmaxenergy(int add) {
    maxenergy += add;
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
}
