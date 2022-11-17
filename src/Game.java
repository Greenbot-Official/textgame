import Objects.Player;
import Utils.Constants;
import Utils.Enemies;
import Utils.Logger;
import Utils.Spells;

import java.io.IOException;
import java.util.Scanner;

public class Game {
  private static boolean isRunning;
  private final Logger logger = Constants.logger;
  private final Scanner input = new Scanner(System.in);
  private String[] text;

  private Player user;

  public Game() {
  }

  public void start() {
    logger.log("initializing");
    init();
    isRunning = true;
    logger.log("starting loop");
    for (int loopCount = 0 ; isRunning ; loopCount++) {
      logger.log("loop: " + loopCount);
      loop();
    }
    logger.log("exiting... ");
  }


  private void loop() {
    Logic.hud(user);
    text = input.nextLine().toLowerCase().split("\s", 2);
    try {
      logger.log("command: " + text[0] + " args: " + text[1]);
    } catch (ArrayIndexOutOfBoundsException e) {
      logger.log("command: " + text[0]);
    }
    Logic.readInput(user, text);
    Logic.combat(user);
  }

  private void init() {
    user = new Player(100, 100);
    initSpells();
    user.setCombat(true);
    user.setTurn(true);
    user.setEnemy(Enemies.fireMage);
  }

  private void initSpells() {
    logger.log("initializing spells...");
    user.addSpell(Spells.flame);
    Enemies.fireMage.addSpell(Spells.flame);
  }

  public static void end() {
    isRunning = false;
  }
}
