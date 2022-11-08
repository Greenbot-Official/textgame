import Objects.Player;
import Utils.Constants;
import Utils.Logger;
import Utils.Spells;

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
    Logic.hud(this.user);
    text = input.nextLine().toLowerCase().split(" ", 2);
    Logic.readInput(user, text);
  }

  private void init() {
    user = new Player(100, 100);
    user.getSpells().add(Spells.flame);
  }

  public static void end() {
    isRunning = false;
  }
}
