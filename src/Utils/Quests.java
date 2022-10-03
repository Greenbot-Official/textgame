package Utils;

import Objects.Quest;

public class Quests {
  public static Quest none = new Quest("None", null, "no active quest");
  public static Quest town = new Quest("Going to town", none, "find your way to the first town");
  public static Quest first = new Quest("First Quest", town, "kill your first enemy");
}
