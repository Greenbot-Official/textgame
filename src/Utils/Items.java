package Utils;

import Objects.Item;
import Utils.Enums.Attribute;
import Utils.Enums.ItemType;
import Utils.Enums.Special;

public class Items {
  public static Item eye = new Item("eye", ItemType.eye, Attribute.end, 1, Special.none);
  public static Item heart = new Item("heart", ItemType.heart, Attribute.end, 1, Special.none);
  public static Item arm = new Item("arm", ItemType.arm, Attribute.end, 1, Special.none);
  public static Item leg = new Item("leg", ItemType.leg, Attribute.end, 1, Special.jump);
  public static Item feederEye = new Item("feeder eye", ItemType.eye, Attribute.str, 1, Special.weak_foresight);
  public static Item feederHeart = new Item("feeder heart", ItemType.heart, Attribute.str, 1, Special.weak_drain);
  public static Item feederArm = new Item("feeder arm", ItemType.arm, Attribute.str, 1, Special.none);
  public static Item feederLeg = new Item("feeder leg", ItemType.leg, Attribute.str, 1, Special.jump);
}
