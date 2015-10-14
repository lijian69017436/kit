package annotation_proxy.com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface anntation {
	String name();    
	String value();
	
}
