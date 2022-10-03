package Utils;

import Objects.Item;
import Utils.Enums.Attribute;
import Utils.Enums.ItemType;
import Utils.Enums.Special;

public final class Items {
  public static final Item eye = new Item("eye", ItemType.eye, Attribute.end, 1, Special.none);
  public static final Item heart = new Item("heart", ItemType.heart, Attribute.end, 1, Special.none);
  public static final Item arm = new Item("arm", ItemType.arm, Attribute.end, 1, Special.none);
  public static final Item leg = new Item("leg", ItemType.leg, Attribute.end, 1, Special.jump);
  public static final Item feederEye = new Item("feeder eye", ItemType.eye, Attribute.str, 1, Special.weak_foresight);
  public static final Item feederHeart = new Item("feeder heart", ItemType.heart, Attribute.str, 1, Special.weak_drain);
  public static final Item feederArm = new Item("feeder arm", ItemType.arm, Attribute.str, 1, Special.none);
  public static final Item feederLeg = new Item("feeder leg", ItemType.leg, Attribute.str, 1, Special.jump);
}
