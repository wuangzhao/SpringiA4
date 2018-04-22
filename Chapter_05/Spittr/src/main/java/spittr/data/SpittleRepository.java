package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  /**
   * max代表返回Spittle ID属性的最大值
   *count参数声明要返回多少个Spittle对象
   */
  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
