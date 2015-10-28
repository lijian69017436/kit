package design.design.memo.game;
/**
 * 角色 状态存储箱
 * @author Administrator
 *
 */
public class RoleStateMemento {
  private int vit;
  private int atk;
  private int def;
  public RoleStateMemento(int vit, int atk, int def) {
    this.vit = vit;
    this.atk = atk;
    this.def = def;
  }
  
  public int getVit() {
    return vit;
  }
  public void setVit(int vit) {
    this.vit = vit;
  }
  public int getAtk() {
    return atk;
  }
  public void setAtk(int atk) {
    this.atk = atk;
  }
  public int getDef() {
    return def;
  }
  public void setDef(int def) {
    this.def = def;
  }
}

class RoleStateCaretaker{
  private RoleStateMemento me;

  public RoleStateMemento getMe() {
    return me;
  }
  public void setMe(RoleStateMemento me) {
    this.me = me;
  }
}