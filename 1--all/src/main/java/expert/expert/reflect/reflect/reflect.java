package expert.expert.reflect.reflect;

import java.lang.reflect.Field;
/**
 * 反射 应用
 * @ClassName: reflect 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2015年12月14日 下午4:02:49 
 *
 */
public class reflect {
  /**
   * 1,前置条件     2个  对象 字段相同 太多
   * 2,把有值对象的 值   (赋值到)   无值对象上去
   * @param input 有值的  对象
   * @param out 需要赋值的对象
   * @return
   */
  private Object ObjctToObjct(Object input , Object out) {
    Field[] field = input.getClass().getDeclaredFields();
    for(Field fil:field){
      fil.setAccessible(true);
      try {
        if(null != fil.get(input)){ //如果 这个 属性 不为空
          Field s = out.getClass().getDeclaredField(fil.getName()); //根据 这个属性名字 得到 另一个对象的 filed
          if(null != s){
            s.setAccessible(true);  //设置 这个对象可以更改
            s.set(out, fil.get(input));
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return out;
  }
}
