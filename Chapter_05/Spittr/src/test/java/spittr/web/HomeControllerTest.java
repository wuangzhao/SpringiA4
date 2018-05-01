package spittr.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.ui.Model;
import spittr.web.HomeController;

public class HomeControllerTest {

    /**
     * 发起GET请求，并断言结果识图的名称位home
     * 它首先传递一个HomeController实例到MockMvcBuilders.standaloneSetup()
     * 并调用build()来构建MockMvc实例。
     * 然后它使用MockMvc实例来执行针对"/"的GET请求并设置期望得到的视图名称
     * @throws Exception
     */
    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();//搭建MockMvc
        mockMvc.perform(get("/"))//对"/"执行GET请求
                .andExpect(view().name("home"));//预期得到home视图
    }

    @Test
    public void assTestHomePage(){
        HomeController controller = new HomeController();
        assertEquals("home", controller.home(null));
    }
}
