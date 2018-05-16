package com.js.lijian.servlet;

import org.junit.Test;

public class tests {

	@Test
	public void test1(){
		int i= -1;
		i>>>=10;
		System.out.println(i);
		long l=-1;
		l>>>=10;
		System.out.println(l);
		short s=-1;
		s>>>=10;
		System.out.println(s);
		byte b=-1;
		b>>>=10;
		b>>=10;
		System.out.println(b+"");
		
	}
}
