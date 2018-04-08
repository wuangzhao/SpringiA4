package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(CDPlayerConfig.class)//导入
@ImportResource("classpath:cd-config.xml")//同时让Spring加载它和其他基于Java的配置
public class SoundSystemConfig {

}
