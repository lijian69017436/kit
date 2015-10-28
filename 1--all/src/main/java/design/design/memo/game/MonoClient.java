package design.design.memo.game;

import org.junit.Test;

import common.li.Log;

public class MonoClient {
  @Test
  public void client(){
    GameRole1 lixiaoyao = new GameRole1();
    lixiaoyao.getInitState();
    lixiaoyao.stateDisplay();
    
    RoleStateCaretaker state = new RoleStateCaretaker();//保存角色状态
    state.setMe(lixiaoyao.saveState());//在封装里边 把当前  值保存在另一个对象里边 
    
    lixiaoyao.fight();
    lixiaoyao.stateDisplay();

    lixiaoyao.RecoveryState(state.getMe());//根据上次保存的对象 得到 值
    lixiaoyao.stateDisplay();
    
    
  }
}

class GameRole1 {//游戏 角色
  private int vit;
  private int atk;
  private int def;

  public void stateDisplay() {
    Log.debug("较色当前状态");
    Log.debug("体力 : %d", this.vit);
    Log.debug("攻击力 : %d", this.atk);
    Log.debug("防御力 : %d", this.def);
    Log.debug("");
  }
  public void getInitState() {
    this.vit = 100;
    this.atk = 100;
    this.def = 100;
  }
  public void fight() {
    this.vit = 0;
    this.atk = 0;
    this.def = 0;
  }
  public RoleStateMemento saveState(){//保存 角色状态
    return new RoleStateMemento(vit,atk,def);
  }
  public void RecoveryState(RoleStateMemento me){//恢复较色状态
    this.vit=me.getVit();
    this.atk=me.getAtk();
    this.def=me.getDef();
  }
}






