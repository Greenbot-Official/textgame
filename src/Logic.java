import Objects.Player;
import Utils.Enums.Command;

public class Logic {

  public static void readInput(Player user, String input) {
    switch (getCommand(user, input)) {
      case quit -> Game.end();
      case help -> System.out.println("help - displays this menu\ninv - displays inventory\n");
      case inv -> System.out.println("inv");
      case unknown -> System.out.println("unknown command");
    }
  }

  public static void hud(Player user) {

  }

  public static Command getCommand(Player user, String input) {
    return switch (input) {
      case "h", "help" -> Command.help;
      case "q", "quit" -> Command.quit;
      case "i", "inv", "inventory" -> Command.inv;
      default -> Command.unknown;
    };
  }
}
