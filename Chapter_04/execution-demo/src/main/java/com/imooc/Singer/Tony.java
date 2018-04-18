package com.imooc.Singer;

import org.springframework.stereotype.Component;

@Component
public class Tony implements someone {

    public void sing() {
        System.out.println("sing");
    }
}
