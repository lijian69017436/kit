package com.zbxsoft.core.mapper.test;

import org.junit.Test;

import com.li.li.Photo;
import com.zbxsoft.core.mapper.JsonMapper;

public class JsonMapperTest {

	@Test
	public void buildNormalMapper_test(){
		
		 JsonMapper json = JsonMapper.buildNormalMapper();
		 Photo p = new Photo();
		 p.setId("2");
		System.out.println( json.toJsonP("json", p));
		 
	}
}
