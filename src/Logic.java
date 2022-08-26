import Objects.Item;
import Objects.Player;
import Utils.Enums.Command;

import javax.annotation.processing.SupportedAnnotationTypes;

public class Logic {
  public Logic() {}

  public static void readInput (Player user, String input) {
    switch (getCommand(input, user)) {
      case help:
        System.out.println("\"i\" - to view inventory, \"q\" - quit");
        if (user.isCombat()) System.out.println("\"a\" - to use default attack, or type the name of a special on an item to use it");
        break;
      case inv:
        System.out.println("eye: " + user.getEye().name() + " - " + user.getEye().special());
        System.out.println("heart: " + user.getHeart().name() + " - " + user.getHeart().special());
        System.out.println("arm: " + user.getArm().name() + " - " + user.getArm().special());
        System.out.println("leg: " + user.getLeg().name() + " - " + user.getLeg().special());
        break;
      case quit:
        Game.end();
        break;
      case unknown:
        System.out.println("Unknown command (" + input + "), try \"help\" to get help");
    }
  }

  public static Command getCommand(String input, Player user) {
    if (input.equals("h") || input.equals("help")) {
      return Command.help;
    } else if (input.equals("i") || input.equals("inv")) {
      return Command.inv;
    } else if (input.equals("q")) {
      return Command.quit;
    } else if (input.equals(user.getEye().special().toString())) {
      return Command.special_eye;
    } else if (input.equals(user.getHeart().special().toString())) {
      return Command.special_heart;
    } else if (input.equals(user.getArm().special().toString())) {
      return Command.special_arm;
    } else if (input.equals(user.getLeg().special().toString())) {
      return Command.special_leg;
    } else { return Command.unknown; }
  }

  public static void combat(Player user) {
    if (!user.isCombat() || user.getTurn()) return;
    Command enemymove = getAi();
    switch (enemymove) {
      case attack:
        user.damage(calcdamage(user.getEnemy().getItems()));
        break;
    }
  }
  public static Command getAi() {
    return Command.attack;
  }

  public static int calcdamage(Item[] items) {
    return 0;
  }
}
