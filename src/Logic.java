import Objects.Item;
import Objects.Player;
import Utils.Enums.Attribute;
import Utils.Enums.Command;
import Utils.Utils;

import javax.annotation.processing.SupportedAnnotationTypes;

import static Utils.Utils.calcdamage;

public class Logic {
  public Logic() {}

  public static void readInput (Player user, String input) {
    switch (getCommand(input, user)) {
      case help:
        System.out.println("\"i\" - to view inventory, \"q\" - quit");
        if (user.isCombat()) System.out.println("\"a\" - to use default attack, or type the name of a special on an item to use it");
        if (user.isLoot()) System.out.println("type the name of the part you want to loot");
        break;
      case inv:
        System.out.println("eye: " + user.getEye().name() + " - " + user.getEye().special());
        System.out.println("heart: " + user.getHeart().name() + " - " + user.getHeart().special());
        System.out.println("arm: " + user.getArm().name() + " - " + user.getArm().special());
        System.out.println("leg: " + user.getLeg().name() + " - " + user.getLeg().special());
        break;
      case attack:
        user.getEnemy().damage(calcdamage(user.getItems()));
        System.out.println("you hit the enemy for: " + calcdamage(user.getItems()) + " damage");
        user.setTurn(false);
        break;
      case quit:
        Game.end();
        break;
      case loot_eye:
        user.setEye(user.getEnemy().getEye());
        user.setLoot(false);
        break;
      case loot_heart:
        user.setHeart(user.getEnemy().getHeart());
        user.setLoot(false);
        break;
      case loot_arm:
        user.setArm(user.getEnemy().getArm());
        user.setLoot(false);
        break;
      case loot_leg:
        user.setLeg(user.getEnemy().getLeg());
        user.setLoot(false);
        break;
      case unknown:
        System.out.println("Unknown command (" + input + "), try \"help\" to get help");
        break;
    }
  }

  public static Command getCommand(String input, Player user) {
    if (!user.isCombat() && !user.isDead() && !user.isLoot()) {
      // not in combat commands
      if (input.equals("h") || input.equals("help")) {
        return Command.help;
      } else if (input.equals("i") || input.equals("inv")) {
        return Command.inv;
      } else if (input.equals("q")) {
        return Command.quit;
      } else { return Command.unknown; }

    } else if (user.isCombat() && !user.isDead()) {
      // combat commands
      if (input.equals("h") || input.equals("help")) {
        return Command.help;
      } else if (input.equals("i") || input.equals("inv")) {
        return Command.inv;
      } else if (input.equals("q")) {
        return Command.quit;
      } else if (input.equals("a") || input.equals("attack")) {
        return Command.attack;
      } else if (input.equals(user.getEye().special().toString())) {
        return Command.special_eye;
      } else if (input.equals(user.getHeart().special().toString())) {
        return Command.special_heart;
      } else if (input.equals(user.getArm().special().toString())) {
        return Command.special_arm;
      } else if (input.equals(user.getLeg().special().toString())) {
        return Command.special_leg;
      } else { return Command.unknown; }

    } else if (user.isDead()) {
      // dead commands
      if (input.equals("h") || input.equals("help")) {
        return Command.help;
      } else if (input.equals("i") || input.equals("inv")) {
        return Command.inv;
      } else if (input.equals("q")) {
        return Command.quit;
      } else { return Command.unknown; }

    } else if (user.isLoot()) {
      // loot table commands
      if (input.equals("h") || input.equals("help")) {
        return Command.help;
      } else if (input.equals("i") || input.equals("inv")) {
        return Command.inv;
      } else if (input.equals("q")) {
        return Command.quit;
      } else if (input.equals("eye") || input.equals("1")) {
        return Command.loot_eye;
      } else if (input.equals("heart") || input.equals("2")) {
        return Command.loot_heart;
      } else if (input.equals("arm") || input.equals("3")) {
        return Command.loot_arm;
      } else if (input.equals("leg") || input.equals("4")) {
        return Command.loot_leg;
      } else { return Command.unknown; }
    }
    return Command.unknown;
  }

  public static void lootMenu(Player user) {
    System.out.println("eye - " + user.getEnemy().getEye().name());
    System.out.println("heart - " + user.getEnemy().getHeart().name());
    System.out.println("arm - " + user.getEnemy().getArm().name());
    System.out.println("leg - " + user.getEnemy().getLeg().name());
    System.out.println();
  }
  public static void combat(Player user) {
    if (!user.isCombat()) return;
    if (!user.getTurn()) {
      Command enemymove = getAi();
      switch (enemymove) {
        case attack:
          user.damage(calcdamage(user.getEnemy().getItems()));
          System.out.println("Enemy hit you for: " + calcdamage(user.getEnemy().getItems()) + " damage");
          user.setTurn(true);
          break;
      }
    }
    System.out.println("Hp: " + user.getHp() + "/" + user.getMaxhp());
    System.out.println("Mana: " + user.getMana() + "/" + user.getMaxmana());
    System.out.println("\nEnemy:");
    System.out.println("Hp: " + user.getEnemy().getHp() + "/" + user.getEnemy().getMaxhp());
  }
  public static Command getAi() {
    return Command.attack;
  }

}
