package Utils;

import Objects.Location;
import Objects.NPC;
import Objects.Quest;

import java.util.ArrayList;

public class LocationMap {
  private static final Location empty = new Location("empty", false, false, false, false, false);

  private static final Location roadN = new Location("road", true, false, false, false, false);
  private static final Location roadE = new Location("road", false, true, false, false, false);
  private static final Location roadS = new Location("road", false, false, true, false, false);
  private static final Location roadW = new Location("road", false, false, false, true, false);

  private static final Location roadNE = new Location("road", true, true, false, false, false);
  private static final Location roadNS = new Location("road", true, false, true, false, false);
  private static final Location roadNW = new Location("road", true, false, false, true, false);
  private static final Location roadES = new Location("road", false, true, true, false, false);
  private static final Location roadEW = new Location("road", false, true, false, true, false);
  private static final Location roadSW = new Location("road", false, false, true, true, false);

  private static final ArrayList<Quest> villagerQuests = new ArrayList<>();
  private static final ArrayList<String> villagerTalk = new ArrayList<>();

  private static final NPC villager = new NPC("Villager", villagerQuests, villagerTalk, "hi lol");

  private static final ArrayList<NPC> ftownNpcs = new ArrayList<>();
  private static final Location ftown = new Location("first town", ftownNpcs, true, false, true, false, true);

  public static void gameInit() {
    villagerQuests.add(Quests.test);
    villagerTalk.add("here is a test quest");
    ftownNpcs.add(villager);
  }

  /**
   * @apiNote [Y,X] north is -y
   */
  public static Location[][] map =
    {{roadE, roadEW, roadSW},
      {empty, empty, ftown},
      {empty, empty, roadN}};
}
