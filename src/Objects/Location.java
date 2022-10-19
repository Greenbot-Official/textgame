package Objects;

import Utils.Constants;
import java.util.ArrayList;
import java.util.List;

public class Location {
  private final Logger logger = Constants.logger;
  private final String name;
  private List<NPC> npcs;
  private boolean n;
  private boolean e;
  private boolean s;
  private boolean w;
  private final boolean town;
  public Location (String name, List<NPC> npcs, boolean n, boolean e, boolean s, boolean w, boolean town) {
    this.name = name;
    this.npcs = npcs;
    this.n = n;
    this.e = e;
    this.s = s;
    this.w = w;
    this.town = town;
    logger.log("initialized location: " + this);
  }

  public Location(String name, boolean n, boolean e, boolean s, boolean w, boolean town) {
    this.name = name;
    this.npcs = new ArrayList<>();
    this.n = n;
    this.e = e;
    this.s = s;
    this.w = w;
    this.town = town;
  }
  public List<NPC> getNpcs() {
    return npcs;
  }

  public void setNpcs(List<NPC> npcs) {
    this.npcs = npcs;
  }

  public String name() {
    return name;
  }
  public boolean n() {
    return n;
  }
  public void setN(boolean n) {
    this.n = n;
    logger.log("set N to: " + n);
  }
  public boolean e() {
    return e;
  }
  public void setE(boolean e) {
    this.e = e;
    logger.log("set E to: " + e);
  }
  public boolean s() {
    return s;
  }
  public void setS(boolean s) {
    this.s = s;
    logger.log("set S to: " + s);
  }
  public boolean w() {
    return w;
  }
  public void setW(boolean w) {
    this.w = w;
    logger.log("set W to: " + w);
  }
  public boolean town() {
    return town;
  }
}
