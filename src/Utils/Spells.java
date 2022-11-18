package Utils;

import Objects.Spell;
import Utils.Enums.Element;

public class Spells {
  public static final Spell none = new Spell("none", "error", 0, 0, Element.none, false, Effects.none);
  public static final Spell flame = new Spell("flame", "shoots a stream of fire out of your hands", 10, 10, Element.fire, false, Effects.burn);
}
