package Objects;

import Utils.Enums.Atribute;
import Utils.Enums.ItemType;
import Utils.Enums.Special;

public record Item(String name, ItemType type, Atribute atribute, int atrib, Special special, int id) {
}
