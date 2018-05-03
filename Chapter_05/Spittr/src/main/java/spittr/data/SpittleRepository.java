package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {

    List<Spittle> findRecentSpittles();

    /**
     * max代表返回Spittle ID属性的最大值
     * count参数声明要返回多少个Spittle对象
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     * spittle()方法会将参数传递到SpittleRepository的findOne()方法中
     * 用来获取某个Spittle对象，然后将方法添加到模型中。
     * 模型的key值将会是spittle
     * 这个是根据addAttribute()方法中的类型推断到的
     * @param id
     * @return
     */
    Spittle findOne(long id);

    void save(Spittle spittle);

}