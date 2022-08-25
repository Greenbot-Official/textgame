package Utils;

import Objects.Item;
import Utils.Enums.Atribute;
import Utils.Enums.ItemType;
import Utils.Enums.Special;

public class Items {
  public static Item eye = new Item("eye", ItemType.eye, Atribute.none, 0, Special.none, 0);
  public static Item heart = new Item("heart", ItemType.heart, Atribute.none, 0, Special.none, 1);
  public static Item arm = new Item("arm", ItemType.arm, Atribute.none, 0, Special.punch, 2);
  public static Item leg = new Item("leg", ItemType.leg, Atribute.none, 0, Special.jump, 3);
  public static Item feederEye = new Item("feeder eye", ItemType.eye, Atribute.spd, 1, Special.weak_foresight, 4);
  public static Item feederHeart = new Item("feeder heart", ItemType.heart, Atribute.spd, 1, Special.none, 5);
  public static Item feederArm = new Item("feeder arm", ItemType.arm, Atribute.spd, 1, Special.claw, 6);
  public static Item feederLeg = new Item("feeder leg", ItemType.leg, Atribute.spd, 1, Special.jump, 7);
}
