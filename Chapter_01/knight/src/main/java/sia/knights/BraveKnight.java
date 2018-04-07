package sia.knights;

public class BraveKnight implements Knight {

    private Quest quest;
    //Quest被注入进来
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }

}
