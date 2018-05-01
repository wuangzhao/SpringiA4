package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 可以将其映射到对/homepage的请求
 *
 * @ RequestMapping（{"/", "/homepage"})
 * 现在HomeController的home()方法能够映射到对"/"和"/homepage"的GET的请求
 */

@Controller
@RequestMapping("/")//将控制器映射到"/"
public class HomeController {

    //路径现在被转移到类级别@RequestMapping上。
    //当控制器在类级别上添加@RequestMapping注解时，这个注解会应用到控制器的所有处理器的方法上。
    //处理器方法上的@RequestMapping注解会类级别上的@RequestMapping的声明进行补充
    //这个注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。
    @RequestMapping(method = GET)//处理GET请求
    public String home(Model model) {
        return "home";//视图名为home
    }

}
