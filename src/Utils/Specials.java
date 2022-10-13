package Utils;

import Objects.Player;
import Objects.Special;

public class Specials {
  public static Special none() {
    return new Special("none", 0, Player::none);
  }
  public static Special jump(Player user) {
    return new Special("jump", 0, user::jump);
  }
  public static Special weakForesight(Player user) {
    return new Special("weak foresight", 15, user::weakForesight);
  }
  public static Special weakDrain(Player user) {
    return new Special("weak drain", 25, user::weakDrain);
  }
}
