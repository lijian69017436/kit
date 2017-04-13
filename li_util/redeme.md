swagger2  使用 项目
1,引入jar包    此项目引用maven 
		
		<!-- swagger2 包 begin -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.6.1</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.6.1</version>
		</dependency>
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-databind</artifactId>
		    <version>2.8.6</version>
		</dependency>
		
		<!-- swagger2 end -->
2, 配置 spring mvc 配置文件 
	<mvc:resources location="classpath:/META-INF/resources/"          mapping="swagger-ui.html"/>  
	<mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>  
	
3, 编写配置文件 
  src/main/java/com/ejz/wechat/util/SwagerConfig.java

4, 扫描的controller 上加上注解 @api 等