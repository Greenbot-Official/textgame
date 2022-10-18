package Objects;

import Utils.Constants;

import java.util.Objects;

public final class Quest {
  private final Logger logger = Constants.logger;
  private final String questName;
  private final Quest nextQuest;
  private final String desc;

  public Quest(String questName, Quest nextQuest, String desc) {
    this.questName = questName;
    this.nextQuest = nextQuest;
    this.desc = desc;
    logger.log("initialized quest: " + this);
  }

  public String questName() {
    return questName;
  }

  public Quest nextQuest() {
    return nextQuest;
  }

  public String desc() {
    return desc;
  }
}
