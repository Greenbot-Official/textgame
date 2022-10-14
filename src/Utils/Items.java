package Utils;

import Objects.Item;
import Objects.Player;
import Objects.Special;
import Utils.Enums.Attribute;
import Utils.Enums.ItemType;

public class Items {
  // specials are initialized in Game because im a silly little goose
  public static Item eye = new Item("eye", Attribute.end, 1, Specials.none());
  public static Item heart = new Item("heart", Attribute.end, 1, Specials.none());
  public static Item arm = new Item("arm", Attribute.end, 1, Specials.none());
  public static Item leg = new Item("leg", Attribute.end, 1, Specials.none());
  public static Item feederEye = new Item("feeder eye", Attribute.str, 1, Specials.none());
  public static Item feederHeart = new Item("feeder heart", Attribute.str, 1, Specials.none());
  public static Item feederArm = new Item("feeder arm", Attribute.str, 1, Specials.none());
  public static Item feederLeg = new Item("feeder leg", Attribute.str, 1, Specials.none());
}
