package design.design.budiler.drawing;

/**
 * 创建 一个 product产品对象      各个部件指定的抽象接口
 * @author Administrator
 *
 */
public interface Builder {
  public void BuidPartA();
  public void BuidPartB();
  public Product GetResult();
  
}
/**
 * 2种 不同 的  部件  构建产品
 * @author Administrator
 */
class ConcreteBuilder1 implements Builder{
  private Product product=new Product();
  @Override
  public void BuidPartA() {
    product.Add("部件 A");
  }
  @Override
  public void BuidPartB() {
    product.Add("部件 B");
  }
  @Override
  public Product GetResult() {
    return product;
  }
}

class ConcreteBuilder2 implements Builder{
  private Product product=new Product();
  @Override
  public void BuidPartA() {
    product.Add("部件 x");
  }
  @Override
  public void BuidPartB() {
    product.Add("部件 c");
  }
  @Override
  public Product GetResult() {
    return product;
  }
}
