package Utils;

import Objects.Location;

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

  private static final Location ftown = new Location("first town", true, false, true, false, true);

  /**
   * @apiNote [Y,X] north is -y
   */
  public static Location[][] map =
    {{roadE, roadEW, roadSW},
      {empty, empty, ftown},
      {empty, empty, roadN}};
}
