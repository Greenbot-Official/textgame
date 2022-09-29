package Utils;

import Objects.Location;
import Objects.Road;
import Objects.Town;

public class LocationMap {
  private static final Location empty = new Road("empty", false, false, false, false);

  private static final Location roadN = new Road("road", true, false, false, false);
  private static final Location roadE = new Road("road", false, true, false, false);
  private static final Location roadS = new Road("road", false, false, true, false);
  private static final Location roadW = new Road("road", false, false, false, true);

  private static final Location roadNE = new Road("road", true, true, false, false);
  private static final Location roadNS = new Road("road", true, false, true, false);
  private static final Location roadNW = new Road("road", true, false, false, true);
  private static final Location roadES = new Road("road", false, true, true, false);
  private static final Location roadEW = new Road("road", false, true, false, true);
  private static final Location roadSW = new Road("road", false, false, true, true);

  private static final Location ftown = new Town("first town", true, false, true, false);

  /**
   * @apiNote [Y,X] north is -y
   */
  public static Location[][] map =
    {{roadE, roadEW, roadSW},
      {empty, empty, ftown},
      {empty, empty, roadN}};
}
