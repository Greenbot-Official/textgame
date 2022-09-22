package Objects;

import Utils.Quests;

public record Quest (String questname, Quest nextQuest, String desc) {
}
