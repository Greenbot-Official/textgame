import Objects.Enemy;
import Objects.Player;
import Utils.Constants;
import Utils.Items;

import java.util.Scanner;

public class Game {
  private static boolean isRunning;
  private Scanner input;

  private Player user;
  public Game(String name) {
    input = new Scanner(System.in);
    user = new Player("player");
  }

  public void start() {
    init();
    isRunning = true;
    loop();
    System.out.println("exiting ...");
  }


  private void loop() {
    while (isRunning) {
      String text = input.nextLine().toLowerCase();
      Logic.readInput(user, text);
      Logic.combat(user);
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
    user.setEnemy(new Enemy(Constants.feederhp, Constants.feederItems));
    user.setCombat(true);
  }

}
