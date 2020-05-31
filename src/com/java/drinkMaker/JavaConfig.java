package com.java.drinkMaker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//if we use @Bean, no need of @ComponentScan
@ComponentScan(basePackages="com.java.drinkMaker")
//we can use @Value("${rasna.color}" from property file)
@PropertySource("classpath:rasna-info.properties")
public class JavaConfig {
	/*We can skip this part by using @Autowired and @Component*/
	
	@Bean(name={"sugarFromBean","multipleBeanName"})
	public Sugar sugarFromBean(){
		/*constructor injection*/
		Sugar sugarObj = new Sugar(this.sugarCaneObj());
		
		/*setter injection*/
		//sugarObj.setSugarCane(this.sugarCaneObj());
		return sugarObj;
	}
	
	@Bean
	public SugarCane sugarCaneObj(){
		return new SugarCane();
	}
}
