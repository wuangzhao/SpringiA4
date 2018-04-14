package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfigWithRequiredProperties {

  @Autowired
  Environment env;
  
  @Bean
  public BlankDisc blankDisc() {
    return new BlankDisc(
        env.getRequiredProperty("disc.title"),
            //在使用getProperty（）方法的时候没有指定默认值
            //并且这个属性没有定义的话，获取到的值是null
            //如果希望这个属性必要要定义
            //可以使用getRequiredProperty()。
            //如果disc.title属性没有定义的话，将会抛出一个IllegalStateException异常
        env.getRequiredProperty("disc.artist"));
  }
  
}
