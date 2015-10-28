package design.design.memo.game;

import org.junit.Test;
import common.li.Log;

/**
 * 普通的 保存游戏进度 
 */
public class GameRole {
  private int vit;
  private int atk;
  private int def;
  
  public void stateDisplay(){
    Log.debug("较色当前状态");
    Log.debug("体力 : %d", this.vit);
    Log.debug("攻击力 : %d", this.atk);
    Log.debug("防御力 : %d", this.def);
    Log.debug("");
  }
  public void getInitState(){
    this.vit=100;
    this.atk=100;
    this.def=100;
  }
  public void fight(){
    this.vit=0;
    this.atk=0;
    this.def=0;
  }
  
  @Test
  public void TestClient(){
    GameRole lixiaoyao = new GameRole();
    lixiaoyao.getInitState();
    lixiaoyao.stateDisplay();
    
    GameRole backup = new GameRole();
    backup.setAtk(lixiaoyao.getAtk());
    backup.setVit(lixiaoyao.getVit());
    backup.setDef(lixiaoyao.getDef());
    
    lixiaoyao.fight();
    lixiaoyao.stateDisplay();
    
    lixiaoyao.setAtk(backup.getAtk());
    lixiaoyao.setDef(backup.getDef());
    lixiaoyao.setVit(backup.getVit());
    lixiaoyao.stateDisplay();
    
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
