package Objects;

public class Road implements Location {

  private final String name;
  private boolean n;
  private boolean e;
  private boolean s;
  private boolean w;

  public Road(String name, boolean n, boolean e, boolean s, boolean w) {
    this.name = name;
    this.n = n;
    this.e = e;
    this.s = s;
    this.w = w;
  }
  @Override
  public String name() {
    return name;
  }
  @Override
  public boolean n() {
    return n;
  }
  public void setN(boolean n) {
    this.n = n;
  }
  @Override
  public boolean e() {
    return e;
  }
  @Override
  public void setE(boolean e) {
    this.e = e;
  }
  @Override
  public boolean s() {
    return s;
  }
  @Override
  public void setS(boolean s) {
    this.s = s;
  }
  @Override
  public boolean w() {
    return w;
  }
  @Override
  public void setW(boolean w) {
    this.w = w;
  }
  @Override
  public boolean town() {
    return false;
  }
}
