package com.imooc;

import com.imooc.Singer.AspectConfig;
import com.imooc.Singer.Tony;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class runwithTest {

    @Autowired
    Tony tony;

    @Test
    public void runwithtonytest(){
        tony.sing();
    }

}
