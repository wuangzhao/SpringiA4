package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)//测试运行器
@ContextConfiguration(classes = CDPlayerConfig.class)//配置加载
public class CDPlayerTest {


    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();



    @Autowired//自动装配
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;


    @Test
    public void cdShouldNotBeNull() {
        cd.play();
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",
                log.getLog());
    }


}
