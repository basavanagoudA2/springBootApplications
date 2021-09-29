package com.js.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.js.boot.beans.Contract;
import com.js.boot.initilizer.YmlConfigApplicationContextInitilizer;

@SpringBootApplication
@PropertySource("classpath:app-global-ymlConfig.yml")
/**propertySource doesnt support for reading yml file than if want load custom yml file so we should gor 
 * either following one approach
 * 1.ymlPropertySourceLoader
 * 2.YmlFactoryBean
 * 
 * */
public class YmlConfigBootApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder=new SpringApplicationBuilder(YmlConfigBootApplication.class);
		builder.initializers(new YmlConfigApplicationContextInitilizer());
		SpringApplication springApplication=builder.build();
		ApplicationContext applicationContext=springApplication.run(args);
		
		Contract contract=applicationContext.getBean(Contract.class);
		System.out.println(contract);
	}

}
