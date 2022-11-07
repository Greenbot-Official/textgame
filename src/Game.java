import Objects.Player;
import Utils.Constants;
import Utils.Logger;

import java.util.Scanner;

public class Game {
  private static boolean isRunning;
  private final Logger logger = Constants.logger;
  private final Scanner input = new Scanner(System.in);
  private String text;

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

  private void init() {
    user = new Player(100, 100);
  }

  private void loop() {
    Logic.hud(this.user);
    text = input.nextLine().toLowerCase();
    Logic.readInput(user, text);
  }

  public static void end() {
    isRunning = false;
  }
}
