import Objects.Enemy;
import Objects.Item;
import Objects.Player;
import Utils.Enemies;
import Utils.Items;
import Utils.Utils;
import Utils.Quests;
import Utils.Specials;

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
      Logic.combat(user);
      String text = input.nextLine().toLowerCase();
      Logic.readInput(user, text);
      if (user.getHp() <= 0) user.die();
      if (user.getEnemy().getHp() <= 0 && user.isCombat()) user.kill();
    }
  }

  public static void end() {
    isRunning = false;
  }

  private void init() {
    initItems();
    user.setEye(Items.eye);
    user.setHeart(Items.heart);
    user.setArm(Items.arm);
    user.setLeg(Items.leg);
    user.setQuest(Quests.first);
    user.startCombat(Enemies.feeder, true);
    user.setRandomEncounters(false);
  }

  // all not none specials are initialized here
  private void initItems() {
    Items.leg.setSpecial(Specials.jump(user));
    Items.feederEye.setSpecial(Specials.weakForesight(user));
    Items.feederHeart.setSpecial(Specials.weakDrain(user));
    Items.feederLeg.setSpecial(Specials.jump(user));
  }

}
