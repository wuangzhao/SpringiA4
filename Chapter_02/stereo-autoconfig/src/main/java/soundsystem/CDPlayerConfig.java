package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//本质上还是@Component 有特定要求 
@ComponentScan//组件扫描
@EnableAspectJAutoProxy
public class CDPlayerConfig {
}
