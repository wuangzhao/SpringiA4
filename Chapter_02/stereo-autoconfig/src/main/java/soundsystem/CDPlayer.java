package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//组件类
public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  @Autowired//自动装配
  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

}
