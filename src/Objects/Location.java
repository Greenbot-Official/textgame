package Objects;

public class Location {

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
  }
  public String name() {
    return name;
  }
  public boolean n() {
    return n;
  }
  public void setN(boolean n) {
    this.n = n;
  }
  public boolean e() {
    return e;
  }
  public void setE(boolean e) {
    this.e = e;
  }
  public boolean s() {
    return s;
  }
  public void setS(boolean s) {
    this.s = s;
  }
  public boolean w() {
    return w;
  }
  public void setW(boolean w) {
    this.w = w;
  }
  public boolean town() {
    return town;
  }
}
