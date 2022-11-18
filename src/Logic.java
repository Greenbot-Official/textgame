import Objects.*;
import Objects.Character;
import Utils.Effects;
import Utils.Enums.Command;

public class Logic {

  public static void readInput(Player user, String[] input) {
    switch (getCommand(user, input[0])) {
      case quit -> Game.end();
      case help -> {
        System.out.println("help - displays this menu\ninv - displays inventory\nspells - displays spells\n");
        if (user.isCombat()) System.out.println("cast {spell name} - uses spell on enemy\n");
      }
      case inv -> System.out.println("inv");
      case cast -> {
        try {
          cast(user, input[1]);
          user.setUpdateEffects(true);
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("could not find that spell");
        }
      }
      case spells -> {
        Spell spell;
        for (int i = 0 ; i < user.getSpells().size() ; i++) {
          spell = user.getSpells().get(i);
          System.out.println(spell.getName() + " - mana cost: " + spell.getManaCost() + " damage: " + spell.getDamage() + " description: " + spell.getDesc());
        }
      }
      case unknown -> System.out.println("unknown command");
    }
  }

  public static void hud(Player user) {
    if (user.isCombat()) {
      System.out.println("Hp " + user.getHp() + "/" + user.getMaxHp());
      System.out.println("Mana " + user.getMana() + "/" + user.getMaxMana());
      System.out.println("\n" + user.getEnemy().getName());
      System.out.println("Hp " + user.getEnemy().getHp() + "/" + user.getEnemy().getMaxHp());
      System.out.println("Mana " + user.getEnemy().getMana() + "/" + user.getEnemy().getMaxMana());
    }
  }

  public static Command getCommand(Player user, String input) {
    switch (input) {
      case "h", "help", "?" -> {
        return Command.help;
      } case "q", "quit" -> {
        return Command.quit;
      } case "i", "inv", "inventory" -> {
        return Command.inv;
      } case "s", "spells" -> {
        return Command.spells;
      }
    }
    if (user.isCombat()) {
      switch (input) {
        case "c", "cast" -> {
          return Command.cast;
        }
      }
    }
    return Command.unknown;
  }

  public static void cast(Player user, String input) {
    Spell spell;
    for (int i = 0 ; i < user.getSpells().size() ; i++) {
      spell = user.getSpells().get(i);
      if (user.getMana() - spell.getManaCost() < 0) {
        System.out.println("not enough mana!");
        return;
      }
      if (spell.getName().equals(input)) {
        if (spell.isHeal()) user.heal(spell.getDamage());
        else user.getEnemy().damage(spell.getDamage());
        if (spell.getEffect().isDebuff()) user.getEnemy().addEffect(spell.getEffect());
        else user.addEffect(spell.getEffect());
        user.useMana(spell.getManaCost());
        user.setTurn(false);
        System.out.println("cast spell " + input);
        return;
      }
    }
    System.out.println("you do not have that spell!");
  }

  public static void enemyCast(Player user, Enemy enemy, Spell spell) {
    enemy.useMana(spell.getManaCost());
    if (spell.isHeal()) enemy.heal(spell.getDamage());
    else user.damage(spell.getDamage());
    if (spell.getEffect().isDebuff()) user.addEffect(spell.getEffect());
    else enemy.addEffect(spell.getEffect());
    user.setTurn(true);
    System.out.println("enemy cast " + spell.getName());
  }

  public static void combat(Player user) {
    if (!user.isCombat() || user.isTurn()) return;
    enemyCast(user, user.getEnemy(), getAi(user.getEnemy()));
  }

  public static Spell getAi(Enemy enemy) {
    return enemy.getSpells().get(0);
  }

  public static void die(Player user) {
    System.out.println("you have been killed");
    user.setCombat(false);
    user.setDead(true);
  }

  public static void kill(Player user) {
    System.out.println("you killed the " + user.getEnemy().getName());
    user.setCombat(false);
  }

  public static void updateEffects(Player user) {
    if (user.isUpdateEffects()) {
      user.setUpdateEffects(false);
      if (user.getEffects().size() == 0) return;
      for (int i = 0 ; i < user.getEffects().size() ; i++) {
        runEffect(user.getEffects().get(i), user);
      }
      if (user.getEnemy().getEffects().size() == 0) return;
      for (int i = 0 ; i < user.getEnemy().getEffects().size() ; i++) {
        runEffect(user.getEnemy().getEffects().get(i), user.getEnemy());
      }
      user.getEffects().removeIf(effect -> (effect.getDuration()) <= 0);
      user.getEnemy().getEffects().removeIf(effect -> (effect.getDuration()) <= 0);
    }
    if (user.getHp() <= 0 && user.isNotDead()) die(user);
    if (user.getEnemy().getHp() <= 0 && user.isNotDead()) kill(user);
  }

  public static void runEffect(Effect effect, Character target) {
    switch (effect.getName()) {
      case "burn" -> {
        target.damage(5);
        System.out.println(target.getName() + " took 5 damage from burn");
        effect.decrement();
      } default -> System.out.println("unknown effect");
    }
  }
}
