package Objects;

import Utils.Constants;

public class Location {
  private final Logger logger = Constants.logger;
  private final String name;
  private boolean n;
  private boolean e;
  private boolean s;
  private boolean w;
  private final boolean town;
  public Location (String name, boolean n, boolean e, boolean s, boolean w, boolean town) {
    this.name = name;
    this.n = n;
    this.e = e;
    this.s = s;
    this.w = w;
    this.town = town;
    logger.log("initialized location: " + this);
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
