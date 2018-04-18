package com.imooc;

import com.imooc.Singer.AspectConfig;
import com.imooc.Singer.Tony;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectTest {

    @Autowired
    private Tony tony;

    @Test
    public void tonyTest(){
        tony.sing();
    }

}
