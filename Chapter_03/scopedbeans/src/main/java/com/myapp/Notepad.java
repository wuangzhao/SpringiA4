package com.myapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//prototype(原型)，每次操作都能得到新的实例
public class Notepad {
  // the details of this class are inconsequential to this example
}
