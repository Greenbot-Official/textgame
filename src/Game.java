import Objects.Enemy;
import Objects.Player;
import Utils.Constants;
import Utils.Items;
import Utils.Utils;
import Utils.Quests;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
  private static boolean isRunning;
  private final Scanner input;

  private final Player user;

  public Game() {
    input = new Scanner(System.in);
    user = new Player();
  }

  public void start() {
    init();
    isRunning = true;
    loop();
    System.out.println("exiting ...");
  }

  private void loop() {
    while (isRunning) {
      if (user.getComplete()) Logic.questComplete(user);
      if (!user.isLoot() && !user.isDead() && !user.isCombat()) Logic.menu(user);
      if (user.isLoot()) Logic.lootMenu(user);
      String text = input.nextLine().toLowerCase();
      Logic.readInput(user, text);
      Logic.combat(user);
      if (user.getHp() <= 0) user.die();
      if (user.getEnemy().getHp() <= 0 && user.isCombat()) user.kill();
    }
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
    user.setEnemy(new Enemy(Constants.feederhp, Constants.feederItems));
    user.setCombat(true);
    user.setTurn(true);
    Logic.combat(user);
  }

}
