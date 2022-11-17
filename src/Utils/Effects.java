package Utils;

import Objects.Effect;

public class Effects {
  public static final Effect none = new Effect("none", "error", 0, false);
  public static final Effect burn = new Effect("burn", "take fire damage each turn", 3, true);
}
