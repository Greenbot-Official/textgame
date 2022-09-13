package Objects;

public class Player {
  private String name;


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

  public Player(String name) {
    this.name = name;
    maxhp = 0;
    hp = maxhp;
    maxmana = 0;
    mana = maxmana;
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
}
