package Objects;

import Utils.Constants;
import Utils.Logger;

public class Effect extends BaseObject {
  private final String name;
  private final String desc;
  private int duration;
  private boolean debuff;

  public Effect(String name, String desc, int duration, boolean debuff) {
    super("Effect");
    this.name = name;
    this.desc = desc;
    this.duration = duration;
    this.debuff = debuff;
  }
  public String getName() {
    return name;
  }
  public String getDesc() {
    return desc;
  }
  public int getDuration() {
    return duration;
  }
  public void setDuration(int duration) {
    this.duration = duration;
    logger.log(this + " duration set to: " + duration);
  }
  public void decrement() {
    setDuration(this.duration - 1);
  }
  public boolean isDebuff() {
    return debuff;
  }
}
