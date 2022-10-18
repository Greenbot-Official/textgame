import Objects.Player;
import Utils.Enums.Command;

import static Utils.Utils.calcDamage;

import Utils.Quests;

public class Logic {
  public Logic() {}

  public static void readInput (Player user, String input) {
    switch (getCommand(input, user)) {
      case help:
        System.out.println("\"i\" - to view inventory, \"quest\" - view current quest, \"q\" - quit");
        if (user.isCombat()) System.out.println("\"a\" - to use default attack, or type the name of a special on an item to use it");
        if (user.isLoot()) System.out.println("type the name of the part you want to loot");
        if (!user.isLoot() && !user.isCombat() && !user.isDead()) System.out.println("type \"n, s, e, w\" to move in that direction");
        break;
      case inv:
        System.out.println("eye: " + user.getEye().name() + " - " + user.getEye().special().name());
        System.out.println("heart: " + user.getHeart().name() + " - " + user.getHeart().special().name());
        System.out.println("arm: " + user.getArm().name() + " - " + user.getArm().special().name());
        System.out.println("leg: " + user.getLeg().name() + " - " + user.getLeg().special().name());
        break;
      case attack:
        user.getEnemy().damage(calcDamage(user.getItems()));
        System.out.println("you hit the enemy for: " + calcDamage(user.getItems()) + " damage");
        user.setTurn(false);
        break;
      case getquest:
        System.out.println(user.getQuest().questName() + " - " + user.getQuest().desc());
        break;
      case north:
        if (user.canMove("n")) {
          user.move("n");
          System.out.println("moved north");
          if (user.getMapPos().town()) enterTown(user);
        } else {
          System.out.println("can't go that way");
        }
        break;
      case east:
        if (user.canMove("e")) {
          user.move("e");
          System.out.println("moved east");
          if (user.getMapPos().town()) enterTown(user);
        } else {
          System.out.println("can't go that way");
        }
        break;
      case south:
        if (user.canMove("s")) {
          user.move("s");
          System.out.println("moved south");
          if (user.getMapPos().town()) enterTown(user);
        } else {
          System.out.println("can't go that way");
        }
        break;
      case west:
        if (user.canMove("w")) {
          user.move("w");
          System.out.println("moved west");
          if (user.getMapPos().town()) enterTown(user);
        } else {
          System.out.println("can't go that way");
        }
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
      case special_eye:
        user.getEye().special().ability().run();
        break;
      case special_heart:
        user.getHeart().special().ability().run();
        break;
      case special_arm:
        user.getArm().special().ability().run();
        break;
      case special_leg:
        user.getLeg().special().ability().run();
        break;
      case unknown:
        System.out.println("Unknown command (" + input + "), try \"help\" to get help");
        break;
    }
  }

  public static Command getCommand(String input, Player user) {
    // global commands
    switch (input) {
      case "h":
      case "help":
        return Command.help;
      case "i":
      case "inv":
        return Command.inv;
      case "q":
        return Command.quit;
      case "quest":
      case "getquest":
        return Command.getquest;
    }
    if (!user.isCombat() && !user.isDead() && !user.isLoot()) {
      switch (input) {
        case "n":
        case "north":
          return Command.north;
        case "e":
        case "east":
          return Command.east;
        case "s":
        case "south":
          return Command.south;
        case "w":
        case "west":
          return Command.west;
      }
    } else if (user.isCombat() && !user.isDead()) {
      // combat commands
      if (input.equals("a") || input.equals("attack")) {
        return Command.attack;
      } else if (input.equals(user.getEye().special().name())) {
        return Command.special_eye;
      } else if (input.equals(user.getHeart().special().name())) {
        return Command.special_heart;
      } else if (input.equals(user.getArm().special().name())) {
        return Command.special_arm;
      } else if (input.equals(user.getLeg().special().name())) {
        return Command.special_leg;
      }

    } else if (user.isDead()) {
      // dead commands

    } else if (user.isLoot()) {
      // loot table commands
      switch (input) {
        case "eye":
        case "1":
          return Command.loot_eye;
        case "heart":
        case "2":
          return Command.loot_heart;
        case "arm":
        case "3":
          return Command.loot_arm;
        case "leg":
        case "4":
          return Command.loot_leg;
      }
    }
    return Command.unknown;
  }

  public static void menu(Player user) {
    if (user.getMapPos().town()) {
      System.out.println();
    }
    String tmp = "\nyou can go";
    if (user.canMove("n")) tmp = tmp + ", North";
    if (user.canMove("e")) tmp = tmp + ", East";
    if (user.canMove("s")) tmp = tmp + ", South";
    if (user.canMove("w")) tmp = tmp + ", West";
    System.out.println(tmp);
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
          user.damage(calcDamage(user.getEnemy().getItems()));
          System.out.println("Enemy hit you for: " + calcDamage(user.getEnemy().getItems()) + " damage");
          user.setTurn(true);
          break;
      }
    }
    System.out.println("Hp: " + user.getHp() + "/" + user.getMaxHp());
    System.out.println("Mana: " + user.getMana() + "/" + user.getMaxMana());
    System.out.println("\nEnemy:");
    System.out.println("Hp: " + user.getEnemy().getHp() + "/" + user.getEnemy().getMaxhp());
  }

  public static void questComplete(Player user) {
    System.out.println("Completed quest: " + user.getQuest().questName());
    if (user.getQuest() == Quests.town) user.setRandomEncounters(true);
    user.setComplete(false);
    user.setQuest(user.getQuest().nextQuest());
  }

  public static void enterTown(Player user) {
    System.out.println("\nyou have entered town");
    if (user.getQuest() == Quests.town) user.setComplete(true);
  }

  public static Command getAi() {
    return Command.attack;
  }

}