package Objects;

import java.util.List;

public class NPC {
    private String name;
    private List<Quest> quests;
    private List<String> talk;

    public String getDefaultTalk() {
        return defaultTalk;
    }

    public void setDefaultTalk(String defaultTalk) {
        this.defaultTalk = defaultTalk;
    }

    private String defaultTalk;
    private int talkIndex = 0;

    public int getTalkIndex() {
        return talkIndex;
    }

    public void setTalkIndex(int talkIndex) {
        this.talkIndex = talkIndex;
    }


    /** @apiNote the npc will say talk.get(x) while assigning quests.get(x) */
    public NPC(String name, List<Quest> quests, List<String> talk, String defaultTalk) {
        this.name = name;
        this.quests = quests;
        this.talk = talk;
        this.defaultTalk = defaultTalk;
    }

    public String getName() {
        return name;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public List<String> getTalk() {
        return talk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public void setTalk(List<String> talk) {
        this.talk = talk;
    }

}
