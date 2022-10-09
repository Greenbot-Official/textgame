import Objects.Enemy;
import Objects.Player;
import Utils.Enemies;
import Utils.Items;
import Utils.Utils;
import Utils.Quests;
import Utils.LocationMap;
import java.util.Scanner;

public class Game {
  private static boolean isRunning;
  public static final Scanner input = new Scanner(System.in);

  private final Player user;

  public Game() {
//    input = new Scanner(System.in);
    user = new Player();
  }

  public void start() {
    init();
    isRunning = true;
    while (isRunning) {
      loop();
    }
    System.out.println("exiting...");
  }

  private void loop() {
    if (user.getComplete()) Logic.questComplete(user);
    if (!user.isLoot() && !user.isDead() && !user.isCombat()) Logic.menu(user);
    if (user.isLoot()) Logic.lootMenu(user);
    String text = input.nextLine().toLowerCase();
    Logic.readInput(user, text);
    Logic.combat(user);
    if (user.getHp() <= 0) user.die();
    if (user.getEnemy().getHp() <= 0 && user.isCombat()) user.kill();
  }

  public static void end() {
    isRunning = false;
  }

  private void init() {
    user.setEye(Items.eye);
    user.setHeart(Items.heart);
    user.setArm(Items.arm);
    user.setLeg(Items.leg);
    user.setMaxhp(Utils.calchp(user.getItems()));
    user.fullheal();
    user.setMaxmana(Utils.calcmana(user.getItems()));
    user.fullmana();
    user.setQuest(Quests.first);
    user.setEnemy(new Enemy(Enemies.feederhp, Enemies.feederItems));
    user.setCombat(true);
    user.setTurn(true);
    Logic.combat(user);

    LocationMap.gameInit();
  }

}
