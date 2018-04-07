package sia.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;

import sia.knights.BraveKnight;
import sia.knights.Quest;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);//创造mock Quest
        //使用mock框架Mockito去创建一个Quest接口的mock实现。
        //通过这个mock对象，就可以创建一个新的BravenKnight实例，并通过构造器注入这个mock Quest，
        // 当调用embarkOnQuest方法时，你就可以要求Mockis框架验证Quest的mock实现的embark()方法仅仅被调用了一次
        BraveKnight knight = new BraveKnight(mockQuest);//注入mock Quest
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }

}
