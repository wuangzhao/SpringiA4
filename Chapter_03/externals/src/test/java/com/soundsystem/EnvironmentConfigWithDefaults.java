package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfigWithDefaults {

  @Autowired
  Environment env;
  
  @Bean
  public BlankDisc blankDisc() {
    return new BlankDisc(
        env.getProperty("disc.title", "Rattle and Hum"),//当指定属性不存在时，使用默认值
        env.getProperty("disc.artist", "U2"));
  }
  
}
