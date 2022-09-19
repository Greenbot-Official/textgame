package Objects;

import Utils.Enums.Attribute;
import Utils.Enums.ItemType;
import Utils.Enums.Special;

public record Item(String name, ItemType type, Attribute attribute, int atrib, Special special) {
}
