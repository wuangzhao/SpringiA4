package spittr.web;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import spittr.Spitter;
import spittr.data.SpitterRepository;
import spittr.web.SpitterController;

public class SpitterControllerTest {

    /**
     * 因为视图名为registerForm所以
     * jsp的名称需要是registerForm.jsp
     * 这个JSP必须包含一个HTML<form>标签
     * 在这个标签中用户输入注册应用的信息
     * @throws Exception
     */
    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();//构建MockMVC
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));//断言registerForm视图
    }

    /**
     * 在构建完SpitterRepository的mock实现有以及所要执行的控制器和MockMvc之后
     * shouldProcessRegion()方法对"spitter/register"发起了一个GET请求。作为请求的一部分
     * 用户信息以参数的形式放到request中，从而模拟提交表单。
     *
     * 在处理POST请求时，在请求结束后，最好进行下一重定向，这样浏览器刷新就不会重复提交表单了。
     * 在这个测试中，预期会请求重定向到"/spitter/jbauer"也就是新建用户的基本信息页面。
     *
     * 最后，测试会校验SpittleRepository的mock实现最终会真正用来保存表单上传入的数据
     * @throws Exception
     */
    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);//构建Repository
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours")
                .param("email", "jbauer@ctu.gov"))
                .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);//检验保存情况
    }

    @Test
    public void shouldFailValidationWithNoData() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerForm"))
                .andExpect(model().errorCount(5))
                .andExpect(model().attributeHasFieldErrors(
                        "spitter", "firstName", "lastName", "username", "password", "email"));
    }

}
