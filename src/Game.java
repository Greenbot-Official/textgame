import Objects.*;
import Utils.*;

import java.util.Scanner;

public class Game {
  private static boolean isRunning;
  private int loopCount = 0;
  public static final Scanner input = new Scanner(System.in);

  private final Player user;

  private final Logger logger = Constants.logger;

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
    logger.log("starting loop");
    while (isRunning) {
      loopCount++;
      logger.log("start loop " + loopCount);
      if (user.getComplete()) Logic.questComplete(user);
      if (!user.isLoot() && !user.isDead() && !user.isCombat()) Logic.menu(user);
      if (user.isLoot()) Logic.lootMenu(user);
      Logic.combat(user);
      String text = input.nextLine().toLowerCase();
      Logic.readInput(user, text);
      if (user.getHp() <= 0) user.die();
      if (user.getEnemy().getHp() <= 0 && user.isCombat()) user.kill();
      logger.log(("end loop " + loopCount));
    }
  }

  public static void end() {
    isRunning = false;
  }

  private void init() {
    logger.log("initializing...");
    initItems();
    user.setEye(Items.eye);
    user.setHeart(Items.heart);
    user.setArm(Items.arm);
    user.setLeg(Items.leg);
    user.setQuest(Quests.first);
    user.startCombat(new Enemy(Utils.calcHp(Enemies.feederItems), Enemies.feederItems), true);
    user.setRandomEncounters(false);
  }

  // all not none specials are initialized here
  private void initItems() {
    logger.log("initializing items...");
    Items.leg.setSpecial(Specials.jump(user));
    Items.feederEye.setSpecial(Specials.weakForesight(user));
    Items.feederHeart.setSpecial(Specials.weakDrain(user));
    Items.feederLeg.setSpecial(Specials.jump(user));

    LocationMap.gameInit();
  }

}
