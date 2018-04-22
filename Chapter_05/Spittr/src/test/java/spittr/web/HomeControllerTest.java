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

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();//搭建MockMvc
        mockMvc.perform(get("/"))//对"/"执行GET请求
                .andExpect(view().name("home"));//预期得到home视图
    }
}
