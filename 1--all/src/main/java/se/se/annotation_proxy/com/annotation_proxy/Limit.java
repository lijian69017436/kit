package se.se.annotation_proxy.com.annotation_proxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {
	String  limit();//annotation 
	
}
