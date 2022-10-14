package Utils;

import Objects.Player;
import Objects.Special;

public class Specials {
  public static Special none() {
    return new Special("none", 0, () -> {System.out.println("you are unable to use a special ability");});
  }
  public static Special jump(Player user) {
    return new Special("jump", 0, () -> {System.out.println("jump");});
  }
  public static Special weakForesight(Player user) {
    return new Special("weak foresight", 15, () -> {System.out.println("weakforsight ");});
  }
  public static Special weakDrain(Player user) {
    return new Special("weak drain", 25, () -> {System.out.println("weakdrain ");});
  }
}
