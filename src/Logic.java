import Objects.Player;

public class Logic {
  public Logic() {}

  public static void readInput (Player user, String input) {
    String command = getCommand(input);
    switch (command) {
      case "help":
        System.out.println("\"i\" - to view inventory, \"q\" - quit");
        if (user.isCombat()) System.out.println("\"a\" - to use default attack, or type the name of a special on an item to use it");
        break;
      case "inv":
        System.out.println("eye: " + user.getEye().name() + " - " + user.getEye().special());
        System.out.println("heart: " + user.getHeart().name() + " - " + user.getHeart().special());
        System.out.println("arm: " + user.getArm().name() + " - " + user.getArm().special());
        System.out.println("leg: " + user.getLeg().name() + " - " + user.getLeg().special());
        break;
      case "q":
        Game.end();
        break;
      default:
        System.out.println("Unknown command (" + input + "(" + command + ")" + "), try \"help\" to get help");
    }
  }

  public static String getCommand(String input) {
    if (input.equals("h") || input.equals("help")) {
      return "help";
    } else if (input.equals("i") || input.equals("inv")) {
      return "inv";
    } else if (input.equals("q")) {
      return "q";
    }else { return "unknown"; }
  }

  public static void combat(Player user) {
    if (!user.isCombat() || user.getTurn()) return;
  }
}
