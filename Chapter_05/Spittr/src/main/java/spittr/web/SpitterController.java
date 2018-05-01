package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@SuppressWarnings("ALL")
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    /**
     * 注入SpitterRepository
     *
     * @param spitterRepository
     */
    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    /**
     * 返回名为registerForm的逻辑视图
     *
     * @return
     */
    @RequestMapping(value = "/register", method = GET)//处理对"/register"的GET请求
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @Valid Spitter spitter,//校验Spitter输入
            Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";//如果校验出现错误，则重新返回表单
        }

        spitterRepository.save(spitter);//保存Spitter
        return "redirect:/spitter/" + spitter.getUsername();//重定向到基本信息页
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
