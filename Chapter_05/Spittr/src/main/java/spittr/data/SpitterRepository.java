package spittr.data;

import spittr.Spitter;

//通过用户名获取一个Spitter对象，showSpitterProfile()得到这个对象并将其
//添加到模型中，然后返回profile，也就是基本信息页面的逻辑视图名。
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

}
