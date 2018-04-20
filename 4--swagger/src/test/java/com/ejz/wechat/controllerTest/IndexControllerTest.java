package com.ejz.wechat.controllerTest;

import java.io.File;

import org.junit.Test;

public class IndexControllerTest {

	@Test
	public void dd(){
		String savePath = this.getClass().getResource("")+"uploadImg";
		File l = new File(savePath);
		System.out.println(savePath);
		System.out.println(l.getPath());
	}
	
	
	
}
