package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * @param max
     * @param count 要同时处理有参数和没有参数的场景，需要对其进行修改，让它们能接受参数
     *              如果参数在请求中不存在的话，就使用默认值
     * @return
     * @RequestParam 用于将请求参数区数据映射到功能处理方法的参数上
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    /**
     * 允许在@RequestMapping的路径中添加占位符
     * 占位符的名称要用大括号("{"和"}")括起来。
     * 路径中的其他部分要与所处理的请求完全匹配
     * 但是占位符部分可以是任意值
     *
     * @PathVariable("spittleId")注解
     * 这表明在请求路径中，不管占位符部分的值是什么都会传递到处理器方法的spittleId参数中、
     * 如果对"/spittles/54321"发送GET请求，那么将会把"54321"传递进来，作为spittleId的值
     *
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

//    /**
//     * 因为方法名相同所以可以去掉@PathVariable中的value属性
//     * 如果没有value属性的话，它会假设占位符的名称与方法的参数名相同
//     * @param spittleId
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
//    public String spittle_( @PathVariable long spittleId,
//            Model model) {
//        model.addAttribute(spittleRepository.findOne(spittleId));
//        return "spittle";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

}
