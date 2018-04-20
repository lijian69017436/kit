package com.li.base.action;

import com.li.base.BaseAction;

public class SubmitFromAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private SubmitVo ee;
	
	public void yonghuming(){
	  String name = this.getClass().getCanonicalName().trim();
		System.out.println(name+"--------"+ee.getName());
	}

	
  public SubmitVo getEe() {
    return ee;
  }
  public void setEe(SubmitVo ee) {
    this.ee = ee;
  }
}


