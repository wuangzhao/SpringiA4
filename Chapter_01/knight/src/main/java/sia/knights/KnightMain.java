package sia.knights;

import org.springframework.context.support.
        ClassPathXmlApplicationContext;
//因为knight.xml中的bean是使用XML文件进行配置的，所以使用
// ClassPathXmlApplicationContext作为应用上下文相对是比较合适的

public class KnightMain {

    public static void main(String[] args) throws Exception {
        //加载Spring上下文
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "META-INF/spring/knight.xml");
        //获取knight bean
        Knight knight = context.getBean(Knight.class);
        //使用knights
        knight.embarkOnQuest();
        context.close();
    }

    //这里main方法基于knight.xml文件创建了Spring应用上下文。随后它调用该应用上下文获取一个
    //ID为knight的bean。得到Knight对象的引用后，只需简单调用embarkOnQuest方法就可以执行所赋予的
    //探险任务。注意这个类完全不知道我们的英雄骑士接受哪种探险任务，而且完全没意识到这个是由
    //BraveKnight来执行的。只有Knight.xml知道哪个骑士执行了哪种探险任务

}
