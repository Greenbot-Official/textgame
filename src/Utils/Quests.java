package Utils;

import Objects.Quest;

public final class Quests {
  public static final Quest none = new Quest("None", null, "no active quest");
  public static final Quest town = new Quest("Going to town", none, "find your way to the first town");
  public static final Quest first = new Quest("First Quest", town, "kill your first enemy");
}
