package com.imooc.Singer;

import org.springframework.stereotype.Component;

public class Tony implements someone {

    @Override
    public void sing() {
        System.out.println("i'm tony");
    }
}
