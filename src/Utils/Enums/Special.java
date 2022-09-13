package Utils.Enums;

public enum Special {
  none(ItemType.any, 0), jump(ItemType.leg, 0), weak_foresight(ItemType.eye, 15), weak_drain(ItemType.arm, 20);

  Special(ItemType type, int manacost) {
  }
}
